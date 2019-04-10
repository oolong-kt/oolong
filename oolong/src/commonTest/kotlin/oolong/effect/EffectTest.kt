package oolong.effect

import oolong.Effect
import oolong.runTest
import kotlin.js.JsName
import kotlin.test.Test
import kotlin.test.assertEquals

class EffectTest {

    sealed class ParentMsg {
        data class ChildMsgW(val childMsg: ChildMsg) : ParentMsg()
    }

    sealed class ChildMsg {
        object NoOp : ChildMsg()
    }

    @Test
    @JsName("map_should_dispatch_mapped_message")
    fun `map should dispatch mapped message`() = runTest { resolve ->
        val childEffect: Effect<ChildMsg> = { dispatch -> dispatch(ChildMsg.NoOp) }
        val parentEffect = map(childEffect) { ParentMsg.ChildMsgW(it) }
        parentEffect { msg ->
            assertEquals(msg, ParentMsg.ChildMsgW(ChildMsg.NoOp))
            resolve()
        }
    }

}
