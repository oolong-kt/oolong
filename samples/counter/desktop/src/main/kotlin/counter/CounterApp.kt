package counter

import oolong.Oolong
import tornadofx.App
import tornadofx.find

class CounterApp : App(CounterView::class) {

    init {
        val counterView = find(CounterView::class)

        Oolong.runtime(
            Counter.init,
            Counter.update,
            Counter.view,
            counterView.render
        )
    }

}