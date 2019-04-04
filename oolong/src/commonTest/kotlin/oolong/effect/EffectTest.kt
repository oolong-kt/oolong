package oolong.effect

import oolong.Effect
import kotlin.js.JsName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class EffectTest {

    sealed class ParentMsg {
        data class ChildMsgW(val childMsg: ChildMsg) : ParentMsg()
    }

    sealed class ChildMsg {
        object NoOp : ChildMsg()
    }

    @Test
    @JsName("map_should_dispatch_mapped_message")
    fun `map should dispatch mapped message`() {
        val expected = ChildMsg.NoOp
        val childEffect: Effect<ChildMsg> = { dispatch -> dispatch(expected) }
        val parentEffect: Effect<ParentMsg> = map(childEffect) { ParentMsg.ChildMsgW(it) }

        childEffect { actual ->
            assertEquals(expected, actual)
        }
        parentEffect { actual ->
            assertTrue(actual is ParentMsg.ChildMsgW)
            assertEquals(expected, actual.childMsg)
        }
    }

}
