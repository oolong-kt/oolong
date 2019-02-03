package counter

import oolong.Oolong
import tornadofx.App
import tornadofx.find

class CounterApp : App(CounterView::class) {

    init {
        find(CounterView::class).run {
            Oolong.runtime(
                Counter.init,
                Counter.update,
                Counter.view,
                render
            )
        }
    }

}