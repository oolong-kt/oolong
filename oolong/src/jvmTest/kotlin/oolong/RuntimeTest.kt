package oolong

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import oolong.delay.delay
import oolong.effect.none
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import kotlin.test.assertEquals
import kotlin.test.fail

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
@TestInstance(Lifecycle.PER_CLASS)
private class RuntimeTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @BeforeAll
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @AfterAll
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun `runtime should call render initially`() = runBlockingTest {
        val initialState = 1
        runtime(
            { initialState to none() },
            { _: Unit, model: Int -> model to none() },
            { model: Int -> model },
            { props: Int, _: Dispatch<Unit> ->
                assertEquals(initialState, props)
            }
        )
    }

    @Test
    fun `runtime should call render after dispatch`() = runBlockingTest {
        var count = 0
        runtime(
            { "init" to none() },
            { msg: String, _: String -> msg to none() },
            { model: String -> model },
            { model: String, dispatch: Dispatch<String> ->
                count++
                when (model) {
                    "init" -> {
                        dispatch("next")
                    }
                    "next" -> {
                        dispatch("done")
                    }
                    "done" -> {
                        assertEquals(count, 3)
                    }
                }
            }
        )
    }

    @Test
    fun `effects do not block runtime`() = runBlockingTest {
        val states = mutableListOf<String>()
        runtime(
            { "init" to delay(100) { "effect" } },
            { msg: String, _: String -> msg to none() },
            { model: String -> model },
            { model: String, dispatch: Dispatch<String> ->
                states.add(model)
                when (model) {
                    "init" -> {
                        dispatch("next")
                    }
                    "effect" -> {
                        dispatch("done")
                    }
                    "done" -> {
                        assertEquals(listOf("init", "next", "effect", "done"), states)
                    }
                }
            }
        )
    }

    @Test
    fun `runtime should not call update view render if disposed`() = runBlockingTest {
        var initialRender = true
        val dispose = runtime(
            { "state" to none() },
            { msg: String, _: String -> msg to effect { dispatch: Dispatch<String> -> dispatch("next") } },
            { model: String -> model },
            { _: String, _: Dispatch<String> ->
                if (initialRender) initialRender = false
                else fail()
            }
        )
        dispose()
    }

    private fun <Model : Any, Msg : Any, Props : Any> TestCoroutineScope.runtime(
        init: Init<Model, Msg>,
        update: Update<Model, Msg>,
        view: View<Model, Props>,
        render: Render<Msg, Props>
    ): Dispose = runtime(
        init,
        update,
        view,
        render,
        coroutineContext,
        coroutineContext,
        coroutineContext
    )
}
