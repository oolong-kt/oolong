package sample.counter

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import counter.Counter
import oolong.Dispatch

class CounterView : LinearLayout {

    private val incrementButton by lazy { findViewById<Button>(R.id.increment_button) }
    private val countTextView by lazy { findViewById<TextView>(R.id.count_text_view) }
    private val decrementButton by lazy { findViewById<Button>(R.id.decrement_button) }

    @Suppress("ConvertSecondaryConstructorToPrimary")
    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
        defStyleRes: Int = 0
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    fun render(props: Counter.Props, dispatch: Dispatch<Counter.Msg>) {
        countTextView.text = "${props.count}"
        incrementButton.setOnClickListener { dispatch(props.onIncrement()) }
        decrementButton.setOnClickListener { dispatch(props.onDecrement()) }
    }

}
