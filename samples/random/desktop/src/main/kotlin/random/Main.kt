package random

import tornadofx.launch

object Main {

    @JvmStatic
    fun main(vararg args: String) {
        launch<RandomApp>(*args)
    }

}