package random

import javafx.application.Platform
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.control.Label
import oolong.Render
import random.Random.Props
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.label
import tornadofx.vbox

class RandomView : View() {

    private lateinit var faceLabel: Label
    private lateinit var rollButton: Button

    override val root: Parent =
        vbox {
            faceLabel = label()
            rollButton = button("Roll")
        }

    val render: Render<Props> = { props ->
        Platform.runLater {
            faceLabel.text = "${props.dieFace}"
            rollButton.action { props.onRoll() }
        }
    }

}