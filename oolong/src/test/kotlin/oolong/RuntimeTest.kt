package oolong

import com.google.common.truth.Truth.assertThat
import io.kotlintest.specs.DescribeSpec
import kotlin.concurrent.thread
import kotlin.test.assertFailsWith

class RuntimeTest : DescribeSpec({

    describe("a Counter runtime") {
        val terminate = Oolong.runtime(
            Counter.init,
            Counter.update,
            Counter.view,
            Counter.render,
            Counter.subscriptions
        )

        context("dispatch called off the main thread") {
            it("throws an exception") {
                thread(name = "test") {
                    assertFailsWith<IllegalThreadStateException> {
                        Counter.props.increment()
                    }
                }.join()
            }
        }

        context("an increment msg") {
            val expected = Counter.props.count + 1
            Counter.props.increment()
            val actual = Counter.props.count
            it("increments the count") {
                assertThat(actual).isEqualTo(expected)
            }
        }

        context("a decrement msg") {
            val expected = Counter.props.count - 1
            Counter.props.decrement()
            val actual = Counter.props.count
            it("decrements the count") {
                assertThat(actual).isEqualTo(expected)
            }
        }

        context("termination") {
            terminate()
            it("stops reducing") {
                val expected = Counter.props.count
                Counter.props.increment()
                val actual = Counter.props.count
                assertThat(actual).isEqualTo(expected)
            }
        }

    }

})
