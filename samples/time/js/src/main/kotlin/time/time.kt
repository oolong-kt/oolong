package time

import kotlinx.html.dom.append
import kotlinx.html.p
import oolong.Oolong
import kotlin.browser.document
import kotlin.dom.clear
import kotlin.js.Date

private val render = { props: Time.Props ->
    with(document.getElementById("container")!!) {
        clear()
        append {
            p { +Date().toTimeString() }
        }
        Unit
    }
}

fun main() {
    Oolong.runtime(
            Time.init,
            Time.update,
            Time.view,
            render
    )
}
