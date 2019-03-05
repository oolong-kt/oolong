package time

import oolong.Dispose
import oolong.Oolong
import tornadofx.App
import tornadofx.find
import tornadofx.launch

class TimeApp : App(TimeView::class, Styles::class) {

    private val dispose: Dispose

    init {
        find(TimeView::class).run {
            dispose = Oolong.Main.runtime(
                Time.init,
                Time.update,
                Time.view,
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
            launch<TimeApp>(*args)
        }

    }

}