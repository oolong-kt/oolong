package time

import kotlinx.html.dom.append
import kotlinx.html.id
import kotlinx.html.p
import oolong.Oolong
import kotlin.browser.document
import kotlin.js.Date

private val render = { props: Time.Props ->
    // document.getElementById("label")?.innerHTML = Date(props.time).toTimeString()
    document.getElementById("label")?.innerHTML = Date().toTimeString()
}

fun main() {
    document.getElementById("container")?.append {
        p { id = "label" }
    }

    Oolong.runtime(
        Time.init,
        Time.update,
        Time.view,
        render
    )
}
