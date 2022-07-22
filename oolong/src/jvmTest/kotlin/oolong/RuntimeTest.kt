package oolong

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import oolong.next.next
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
class RuntimeTest {

    @Test
    fun `runtime should call render initially`() = runBlockingTest {
        val initialState = 1
        runtime(
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
        runtime(
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
        runtime(
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

    private fun <Model, Msg, Props> TestCoroutineScope.runtime(
        init: Init<Model, Msg>,
        update: Update<Model, Msg>,
        view: View<Model, Props>,
        render: Render<Props, Msg>
    ): Job = runtime(
        init,
        update,
        view,
        render,
        coroutineContext,
        coroutineContext,
        coroutineContext
    )

}
