package time

import tornadofx.launch

object Main {

    @JvmStatic
    fun main(vararg args: String) {
        launch<TimeApp>(*args)
    }

}