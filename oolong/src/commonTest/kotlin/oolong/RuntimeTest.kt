package oolong

import oolong.delay.delay
import oolong.effect.none
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class RuntimeTest {

    @Test
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

    @Test
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

    @Test
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

    @Test
    fun `runtime should not overflow stack`() = test(10_000) { resolve ->
        Oolong.runtime(
            { 0 to none() },
            { _: Unit, model: Int -> model + 1 to none() },
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
