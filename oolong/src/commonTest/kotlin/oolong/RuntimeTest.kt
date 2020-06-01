package oolong

import oolong.delay.delay
import oolong.effect.none
import kotlin.js.JsName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class RuntimeTest {

    @Test @JsName("runtimeShouldCallRenderInitially")
    fun `runtime should call render initially`() = test { resolve ->
        val initialState = 1
        Oolong.runtime(
            { initialState to none() },
            { _: Unit, model: Int -> model to none() },
            { model: Int -> model },
            { props: Int, _: Dispatch<Unit> ->
                assertEquals(initialState, props)
                resolve()
            }
        )
    }

    @Test @JsName("runtimeShouldCallRenderAfterDispatch")
    fun `runtime should call render after dispatch`() = test { resolve ->
        var count = 0
        Oolong.runtime(
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
                        resolve()
                    }
                }
            }
        )
    }

    @Test @JsName("effectsDoNotBlockRuntime")
    fun `effects do not block runtime`() = test { resolve ->
        val states = mutableListOf<String>()
        Oolong.runtime(
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
                        resolve()
                    }
                }
            }
        )
    }

    @Test @JsName("runtimeShouldNotCallUpdateViewRenderIfDisposed")
    fun `runtime should not call update view render if disposed`() = test { resolve ->
        var initialRender = true
        Oolong.runtime(
            { "state" to none() },
            { msg: String, _: String -> msg to effect { dispatch: Dispatch<String> -> dispatch("next") } },
            { model: String -> model },
            { _: String, _: Dispatch<String> ->
                if (initialRender) initialRender = false
                else fail()
                resolve()
            }
        )()
    }

}
