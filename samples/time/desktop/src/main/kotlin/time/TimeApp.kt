package time

import oolong.Oolong
import tornadofx.App
import tornadofx.find

class TimeApp : App(TimeView::class, Styles::class) {

    init {
        find(TimeView::class).run {
            Oolong.runtime(
                Time.init,
                Time.update,
                Time.view,
                render,
                Time.subscriptions
            )
        }
    }

}