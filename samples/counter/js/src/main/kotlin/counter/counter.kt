package counter

import kotlinx.html.button
import kotlinx.html.dom.append
import kotlinx.html.id
import kotlinx.html.p
import oolong.Oolong
import kotlin.browser.document

private val render = { props: Counter.Props ->
    document.getElementById("label")?.innerHTML = props.count.toString()
    document.getElementById("increment")?.addEventListener("click", { props.onIncrement() })
    document.getElementById("decrement")?.addEventListener("click", { props.onDecrement() })
    Unit
}

fun main() {
    document.getElementById("container")?.append {
        button {
            id = "increment"
            +"+1"
        }
        p { id = "label" }
        button {
            id = "decrement"
            +"-1"
        }
    }

    Oolong.runtime(
        Counter.init,
        Counter.update,
        Counter.view,
        render
    )
}
