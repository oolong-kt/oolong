package oolong

import oolong.util.delay.timeout
import oolong.util.effect.withoutEffects
import kotlin.js.JsName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class RuntimeTest {

    @Test
    @JsName("runtime_should_call_render_initially")
    fun `runtime should call render initially`() = runTest { resolve ->
        val initialState = 1
        Oolong.runtime(
            withoutEffects { -> initialState },
            withoutEffects { _: Unit, model: Int -> model },
            { model: Int -> model },
            { props: Int, _: Dispatch<Unit> ->
                assertEquals(initialState, props)
                resolve()
            }
        )
    }

    @Test
    @JsName("runtime_should_call_render_after_dispatch")
    fun `runtime should call render after dispatch`() = runTest { resolve ->
        var count = 0
        Oolong.runtime(
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
                        resolve()
                    }
                }
            }
        )
    }

    @Test
    @JsName("effects_do_not_block_runtime")
    fun `effects do not block runtime`() = runTest { resolve ->
        val states = mutableListOf<String>()
        Oolong.runtime(
            { ("init" to timeout(100) { "effect" }.first) as Pair<String, Effect<String>> },
            withoutEffects { msg: String, _: String -> msg },
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
                        resolve()
                    }
                }
            }
        )
    }

    @Test
    @JsName("runtime_should_not_overflow_stack")
    fun `runtime should not overflow stack`() = runTest { resolve ->
        Oolong.runtime(
            withoutEffects { -> 0 },
            withoutEffects { _: Unit, model: Int -> model + 1 },
            { model: Int -> model },
            { model: Int, dispatch: Dispatch<Unit> ->
                if (model > 50_000) {
                    resolve()
                } else {
                    dispatch(Unit)
                }
            }
        )
    }

    @Test
    @JsName("runtime_should_not_call_update_view_render_if_disposed")
    fun `runtime should not call update view render if disposed`() = runTest { resolve ->
        var initialRender = true
        Oolong.runtime(
            withoutEffects { -> "state" },
            { msg: String, _: String -> msg to { dispatch: Dispatch<String> -> dispatch("next") } },
            { model: String -> model },
            { _: String, _: Dispatch<String> ->
                if (initialRender) initialRender = false
                else fail()
                resolve()
            }
        )()
    }

}
