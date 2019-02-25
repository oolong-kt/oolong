package counter

import kotlin.test.Test
import kotlin.test.assertEquals

class CounterTest {

    @Test
    fun increment_messages_adds_1_to_count() {
        val (state, _) = Counter.update(
            Counter.Msg.Increment,
            Counter.Model()
        )
        assertEquals(state.count, 1)
    }

    @Test
    fun decrement_messages_subtracts_1_from_count() {
        val (state, _) = Counter.update(
            Counter.Msg.Decrement,
            Counter.Model()
        )
        assertEquals(state.count, -1)
    }

}