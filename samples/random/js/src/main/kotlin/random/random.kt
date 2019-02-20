package random

import kotlinx.html.button
import kotlinx.html.dom.append
import kotlinx.html.id
import kotlinx.html.p
import oolong.Oolong
import kotlin.browser.document

private val render = { props: Random.Props ->
    document.getElementById("label")?.innerHTML = props.dieFace.toString()
    document.getElementById("roll")?.addEventListener("click", { props.onRoll() })
    Unit
}

fun main() {
    document.getElementById("container")?.append {
        p { id = "label" }
        button {
            id = "roll"
            +"Roll"
        }
    }

    Oolong.runtime(
        Random.init,
        Random.update,
        Random.view,
        render
    )
}
