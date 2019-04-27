package oolong.todo

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class AppView : FrameLayout {

    @Suppress("ConvertSecondaryConstructorToPrimary")
    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
        defStyleRes: Int = 0
    ) : super(context, attrs, defStyleAttr, defStyleRes)

}
