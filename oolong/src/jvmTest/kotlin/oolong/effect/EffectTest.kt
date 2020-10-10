package oolong.effect

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import oolong.Effect
import oolong.effect
import oolong.effect.EffectTest.Parent.Msg.ChildMsg
import kotlin.test.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class EffectTest {

    @Test
    fun `map should dispatch mapped message`() = runBlockingTest {
        val childEffect: Effect<Child.Msg> = { dispatch -> dispatch(Child.Msg.NoOp) }
        val parentEffect = map(childEffect) { ChildMsg(it) }
        parentEffect { msg -> assertEquals(msg, ChildMsg(Child.Msg.NoOp)) }
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

    object Parent {
        sealed class Msg {
            data class ChildMsg(val childMsg: Child.Msg) : Msg()
        }
    }

    object Child {
        sealed class Msg {
            object NoOp : Msg()
        }
    }

}
