package random

import kotlinx.html.button
import kotlinx.html.dom.append
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import kotlinx.html.p
import oolong.Oolong
import kotlin.browser.document
import kotlin.dom.clear

private val render = { props: Random.Props ->
    with(document.getElementById("container")!!) {
        clear()
        append {
            p { +"${props.dieFace}" }
            button {
                id = "roll"
                +"Roll"
                onClickFunction = { props.onRoll() }
            }
        }
    }
    Unit
}

fun main() {
    Oolong.runtime(
        Random.init,
        Random.update,
        Random.view,
        render
    )
}
