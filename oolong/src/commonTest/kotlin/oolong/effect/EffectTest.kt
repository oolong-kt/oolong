package oolong.effect

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import oolong.Effect
import oolong.delay.delay
import oolong.effect
import oolong.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class EffectTest {

    sealed class ParentMsg {
        data class ChildMsgW(val childMsg: ChildMsg) : ParentMsg()
    }

    sealed class ChildMsg {
        object NoOp : ChildMsg()
    }

    @Test
    fun `map should dispatch mapped message`() = runBlocking {
        val childEffect: Effect<ChildMsg> = { dispatch -> dispatch(ChildMsg.NoOp) }
        val parentEffect = map(childEffect) { ParentMsg.ChildMsgW(it) }
        parentEffect { msg -> assertEquals(msg, ParentMsg.ChildMsgW(ChildMsg.NoOp)) }
        delay(10)
    }

    @Test
    fun `batch should not block iteration`() = runBlocking {
        val delay = 10L
        val range = 1..10
        val effects = batch(range.map { i ->
            effect<Int> { dispatch ->
                delay(delay)
                dispatch(i)
            }
        })
        val messages = mutableListOf<Int>()
        launch { effects { i -> messages.add(i) } }
        delay(delay * 2)
        assertEquals(range.toList(), messages.sorted())
    }

    @Test
    fun `disposable effect should cancel effect when disposed`() = runBlocking {
        val delay = 10L
        val (effect, dispose) = disposableEffect(delay(delay) { })
        launch { effect { fail("Effect was disposed and should not be called.") } }
        dispose()
        delay(delay * 2)
    }

}
