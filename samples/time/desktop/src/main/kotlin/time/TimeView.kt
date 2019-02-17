package time

import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import oolong.Render
import time.Time.Props
import tornadofx.View
import tornadofx.label

class TimeView : View() {

    override val root = VBox()

    private val timeLabel: Label

    init {
        with(root) {
            setPrefSize(400.0, 200.0)

            alignment = Pos.CENTER
            timeLabel = label()
        }
    }

    val render: Render<Props> = { props ->
        Platform.runLater {
            val (hour, minutes, seconds) = props
            timeLabel.text = "$hour:$minutes:$seconds"
        }
    }

}