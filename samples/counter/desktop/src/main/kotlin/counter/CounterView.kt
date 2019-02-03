package counter

import counter.Counter.RenderModel
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.Priority
import oolong.Render
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.hbox
import tornadofx.hboxConstraints
import tornadofx.hgrow
import tornadofx.insets
import tornadofx.label

class CounterView : View() {

    private lateinit var countLabel: Label
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button

    val render: Render<RenderModel> = { renderModel ->
        countLabel.text = "${renderModel.count}"
        incrementButton.action { renderModel.onIncrement() }
        decrementButton.action { renderModel.onDecrement() }
    }

    override val root: Parent =
        hbox {
            hboxConstraints {
                padding = insets(10)
            }
            decrementButton = button("-")
            countLabel = label {
                hboxConstraints {
                    margin = insets(10, 0)
                    hgrow = Priority.ALWAYS
                }
            }
            incrementButton = button("+")
        }

}