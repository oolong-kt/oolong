package random

import oolong.Dispose
import oolong.JavaFX
import tornadofx.App
import tornadofx.find
import tornadofx.launch

class RandomApp : App(RandomView::class, Styles::class) {

    private val dispose: Dispose

    init {
        find(RandomView::class).run {
            dispose = JavaFX.runtime(
                Random.init,
                Random.update,
                Random.view,
                render
            )
        }
    }

    override fun stop() {
        dispose()
        super.stop()
    }

    companion object {

        @JvmStatic
        fun main(vararg args: String) {
            launch<RandomApp>(*args)
        }

    }

}