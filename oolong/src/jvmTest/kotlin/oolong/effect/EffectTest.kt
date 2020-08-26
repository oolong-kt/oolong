package oolong.effect

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import oolong.Effect
import oolong.delay.delay
import oolong.effect
import oolong.effect.EffectTest.ChildMsg.NoOp
import oolong.effect.EffectTest.ParentMsg.ChildMsgW
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

@ExperimentalCoroutinesApi
class EffectTest {

    @Test
    fun `map should dispatch mapped message`() = runBlockingTest {
        val childEffect: Effect<ChildMsg> = { dispatch -> dispatch(NoOp) }
        val parentEffect = map(childEffect) { ChildMsgW(it) }
        parentEffect { msg -> assertEquals(msg, ChildMsgW(NoOp)) }
    }

    @Test
    fun `batch should not block iteration`() = runBlockingTest {
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
        advanceTimeBy(delay)
        assertEquals(range.toList(), messages.sorted())
    }

    @Test
    fun `cancellable effect should cancel effect when disposed`() = runBlockingTest {
        val delay = 10L
        val (effect, job) = cancellableEffect(delay(delay) { })
        launch { effect { fail("Effect was disposed and should not be called.") } }
        job.cancel()
        advanceTimeBy(delay)
    }

    @Test
    fun `disposable effect should cancel effect when disposed`() = runBlockingTest {
        val delay = 10L
        val (effect, dispose) = disposableEffect(delay(delay) { })
        launch { effect { fail("Effect was disposed and should not be called.") } }
        dispose()
        advanceTimeBy(delay)
    }

    sealed class ParentMsg {
        data class ChildMsgW(val childMsg: ChildMsg) : ParentMsg()
    }

    sealed class ChildMsg {
        object NoOp : ChildMsg()
    }

}
