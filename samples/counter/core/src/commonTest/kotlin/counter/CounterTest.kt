package counter

import kotlin.test.Test
import kotlin.test.assertEquals

class CounterTest {

    @Test
    fun `increment messages adds 1 to count`() {
        val (state, _) = Counter.update(
            Counter.Msg.Increment,
            Counter.Model()
        )
        assertEquals(state.count, 1)
    }

    @Test
    fun `decrement messages subtracts 1 from count`() {
        val (state, _) = Counter.update(
            Counter.Msg.Decrement,
            Counter.Model()
        )
        assertEquals(state.count, -1)
    }

}