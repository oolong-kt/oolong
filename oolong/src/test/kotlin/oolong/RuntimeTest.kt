package oolong

import com.google.common.truth.Truth.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.concurrent.thread

class RuntimeTest : Spek({

    given("a Counter runtime") {
        val program = Program(Counter.init, Counter.update, Counter.view)
        val terminate = runtime(program)

        on("dispatch called off the main thread") {
            it("throws an exception") {
                thread {
                    try {
                        Counter.dispatch(Counter.Msg.Increment)
                        assert(false)
                    } catch (e: Exception) {
                        assert(true)
                    }
                }.join()
            }
        }

        on("an increment message") {
            val count = Counter.model.count
            Counter.dispatch(Counter.Msg.Increment)
            it("increments the count") {
                assertThat(Counter.model.count).isEqualTo(count + 1)
            }
        }

        on("a decrement message") {
            val count = Counter.model.count
            Counter.dispatch(Counter.Msg.Decrement)
            it("increments the count") {
                assertThat(Counter.model.count).isEqualTo(count - 1)
            }
        }

        on("termination") {
            terminate()
            it("stops reducing") {
                val count = Counter.model.count
                Counter.dispatch(Counter.Msg.Increment)
                assertThat(Counter.model.count).isEqualTo(count)
            }
        }

    }

})
