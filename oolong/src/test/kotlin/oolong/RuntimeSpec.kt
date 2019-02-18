package oolong

import com.google.common.truth.Truth.assertThat
import io.kotlintest.specs.DescribeSpec
import oolong.util.noEffect

class RuntimeSpec : DescribeSpec({

    describe("runtime") {

        it("should call render initially") {
            val initialModel = 1
            testRuntime<Int, Unit, Int>(
                { initialModel to noEffect() },
                { _, _ -> initialModel to noEffect() },
                { model, _ -> model },
                { model -> assertThat(model).isEqualTo(initialModel) }
            )
        }

    }

})
