package oolong

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import oolong.next.next
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import kotlin.test.assertEquals
import kotlin.test.fail

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
@TestInstance(Lifecycle.PER_CLASS)
private class RuntimeTest {

    @Test
    fun `runtime should call render initially`() = runBlockingTest {
        val initialState = 1
        disposableRuntime(
            { next(initialState) },
            { _: Unit, model: Int -> next(model) },
            { model: Int -> model },
            { props: Int, _: Dispatch<Unit> ->
                assertEquals(initialState, props)
            }
        )
    }

    @Test
    fun `runtime should call render after dispatch`() = runBlockingTest {
        var count = 0
        disposableRuntime(
            { next("init") },
            { msg: String, _: String -> next(msg) },
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
        val initEffect = effect<String> { dispatch ->
            delay(100)
            dispatch("effect")
        }
        disposableRuntime(
            { next("init", initEffect) },
            { msg: String, _: String -> next(msg) },
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
    fun `runtime should not call update view render if cancelled`() = runBlockingTest {
        var initialRender = true
        val nextEffect = effect { dispatch: Dispatch<String> -> dispatch("next") }
        val job = runtime(
            { next("state") },
            { msg: String, _: String -> next(msg, nextEffect) },
            { model: String -> model },
            { _: String, _: Dispatch<String> ->
                if (initialRender) initialRender = false
                else fail()
            }
        )
        job.cancel()
    }

    @Test
    fun `runtime should not call update view render if disposed`() = runBlockingTest {
        var initialRender = true
        val nextEffect = effect { dispatch: Dispatch<String> -> dispatch("next") }
        val dispose = disposableRuntime(
            { next("state") },
            { msg: String, _: String -> next(msg, nextEffect) },
            { model: String -> model },
            { _: String, _: Dispatch<String> ->
                if (initialRender) initialRender = false
                else fail()
            }
        )
        dispose()
    }

    private fun <Model, Msg, Props> TestCoroutineScope.runtime(
        init: () -> Pair<Model, Effect<Msg>>,
        update: (Msg, Model) -> Pair<Model, Effect<Msg>>,
        view: (Model) -> Props,
        render: (Props, Dispatch<Msg>) -> Any?
    ): Job = runtime(
        init,
        update,
        view,
        render,
        coroutineContext,
        coroutineContext,
        coroutineContext
    )

    private fun <Model, Msg, Props> TestCoroutineScope.disposableRuntime(
        init: () -> Pair<Model, Effect<Msg>>,
        update: (Msg, Model) -> Pair<Model, Effect<Msg>>,
        view: (Model) -> Props,
        render: (Props, Dispatch<Msg>) -> Any?
    ): Dispose = Oolong.runtime(
        init,
        update,
        view,
        render,
        coroutineContext,
        coroutineContext,
        coroutineContext
    )
}
