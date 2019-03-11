package sample.time

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import time.Time
import java.text.DateFormat
import java.util.Date
import oolong.Dispatch

class TimeView : LinearLayout {

    private val formatter = DateFormat.getTimeInstance()
    private val timeTextView by lazy { findViewById<TextView>(R.id.time_text_view) }

    @Suppress("ConvertSecondaryConstructorToPrimary")
    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
        defStyleRes: Int = 0
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    fun render(props: Time.Props, dispatch: Dispatch<Time.Msg>) {
        timeTextView.text = formatter.format(Date())
    }

}
