package sample.random

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import random.Random

class RandomView : LinearLayout {

    private val dieFaceTextView by lazy { findViewById<TextView>(R.id.die_face_text_view) }
    private val rollButton by lazy { findViewById<Button>(R.id.roll_button) }

    @Suppress("ConvertSecondaryConstructorToPrimary")
    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
        defStyleRes: Int = 0
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    fun render(props: Random.Props) {
        dieFaceTextView.text = "${props.dieFace}"
        rollButton.setOnClickListener { props.onRoll() }
    }

}