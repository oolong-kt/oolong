package counter

import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import oolong.Render
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.label

class CounterView : View() {

    override val root = VBox()

    private val countLabel: Label
    private val incrementButton: Button
    private val decrementButton: Button

    init {
        with(root) {
            setPrefSize(100.0, 150.0)
            alignment = Pos.CENTER
            spacing = 10.0

            incrementButton = button("+1")
            countLabel = label()
            decrementButton = button("-1")
        }
    }

    val render: Render<Counter.Msg, Counter.Props> = { props, dispatch ->
        countLabel.text = "${props.count}"
        incrementButton.action { dispatch(props.onIncrement()) }
        decrementButton.action { dispatch(props.onDecrement()) }
    }

}
