package oolong

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Runnable
import oolong.util.effect.withoutEffects
import kotlin.coroutines.CoroutineContext
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class RuntimeTest {

    private val dispatcher = object : CoroutineDispatcher() {
        override fun dispatch(context: CoroutineContext, block: Runnable) {
            block.run()
        }
    }

    @Test
    fun runtime_should_call_render_initially() {
        val initialState = 1
        testRuntime(
            withoutEffects { -> initialState },
            withoutEffects { _: Unit, model: Int -> model },
            { model: Int -> model },
            { props: Int, _ -> assertEquals(initialState, props) }
        )
    }

    @Test
    fun runtime_should_call_render_after_dispatch() {
        var count = 0
        testRuntime(
            withoutEffects { -> "init" },
            withoutEffects { msg: String, _: String -> msg },
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
    fun runtime_should_not_call_update_view_render_if_disposed() {
        var initialRender = true
        testRuntime(
            withoutEffects { -> "state" },
            { msg: String, _: String -> msg to { dispatch -> dispatch("next") } },
            { model: String -> model },
            { _, _ ->
                if (initialRender) initialRender = false
                else fail()
            }
        )()
    }

    private fun <Model, Msg, Props> testRuntime(
        init: Init<Model, Msg>,
        update: Update<Model, Msg>,
        view: View<Model, Props>,
        render: Render<Msg, Props>
    ) = Oolong.runtime(init, update, view, render, GlobalScope, dispatcher, dispatcher)

}
