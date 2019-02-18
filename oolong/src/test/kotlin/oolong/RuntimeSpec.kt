package oolong

import com.google.common.truth.Truth.assertThat
import io.kotlintest.specs.DescribeSpec
import oolong.platform.Effect

class RuntimeSpec : DescribeSpec({

    describe("runtime") {

        it("should call view initially") {
            val initialModel = 1
            Platform.runtime(
                { initialModel to Effect.none() },
                { _: Unit, _: Int -> 1 to Effect.none() },
                { model: Int, _: Dispatch<Unit> ->
                    assertThat(model).isEqualTo(initialModel)
                    model
                },
                {},
                { Effect.none() },
                this,
                coroutineContext
            )()
        }
    }

})
