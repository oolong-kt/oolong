package counter

import tornadofx.launch

object Main {

    @JvmStatic
    fun main(vararg args: String) {
        launch<CounterApp>(*args)
    }

}