package counter

import kotlinx.html.button
import kotlinx.html.dom.append
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import kotlinx.html.p
import oolong.Oolong
import kotlin.browser.document
import kotlin.dom.clear

private val render = { props: Counter.Props ->
    with(document.getElementById("container")!!) {
        clear()
        append {
            button {
                id = "increment"
                +"+1"
                onClickFunction = { props.onIncrement() }
            }
            p { +"${props.count}" }
            button {
                id = "decrement"
                +"-1"
                onClickFunction = { props.onDecrement() }
            }
        }
    }
    Unit
}

fun main() {
    Oolong.runtime(
            Counter.init,
            Counter.update,
            Counter.view,
            render
    )
}
