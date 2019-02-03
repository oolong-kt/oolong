package random

import oolong.Oolong
import tornadofx.App
import tornadofx.find

class RandomApp : App(RandomView::class) {

    init {
        find(RandomView::class).run {
            Oolong.runtime(
                Random.init,
                Random.update,
                Random.view,
                render
            )
        }
    }

}