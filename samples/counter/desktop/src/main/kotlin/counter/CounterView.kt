package counter

import counter.Counter.Props
import javafx.application.Platform
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.control.Label
import oolong.Render
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.label
import tornadofx.vbox

class CounterView : View() {

    private lateinit var countLabel: Label
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button

    override val root: Parent =
        vbox {
            incrementButton = button("+1")
            countLabel = label()
            decrementButton = button("-1")
        }

    val render: Render<Props> = { props ->
        Platform.runLater {
            countLabel.text = "${props.count}"
            incrementButton.action { props.onIncrement() }
            decrementButton.action { props.onDecrement() }
        }
    }

}