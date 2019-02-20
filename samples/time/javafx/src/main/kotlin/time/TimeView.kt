package time

import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import oolong.Render
import time.Time.Props
import tornadofx.View
import tornadofx.label
import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField.HOUR_OF_DAY
import java.time.temporal.ChronoField.MINUTE_OF_HOUR
import java.time.temporal.ChronoField.SECOND_OF_MINUTE

class TimeView : View() {

    override val root = VBox()

    private val timeLabel: Label

    init {
        with(root) {
            setPrefSize(200.0, 100.0)

            alignment = Pos.CENTER
            timeLabel = label()
        }
    }

    val render: Render<Props> = { props ->
        // timeLabel.text = props.time.format(FORMATTER)
        timeLabel.text = LocalDateTime.now().format(FORMATTER)
    }

    companion object {

        private val FORMATTER = DateTimeFormatterBuilder()
            .appendValue(HOUR_OF_DAY, 2)
            .appendLiteral(':')
            .appendValue(MINUTE_OF_HOUR, 2)
            .optionalStart()
            .appendLiteral(':')
            .appendValue(SECOND_OF_MINUTE, 2)
            .toFormatter()

    }

}