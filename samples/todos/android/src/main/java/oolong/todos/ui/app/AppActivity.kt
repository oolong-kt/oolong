package oolong.todos.ui.app

import androidx.appcompat.app.AppCompatActivity
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import oolong.Dispatch
import oolong.todos.App
import oolong.todos.app.Msg
import oolong.todos.app.Props
import java.util.concurrent.atomic.AtomicBoolean

class AppActivity : AppCompatActivity() {

    private val initialized = AtomicBoolean(false)
    private val context by lazy { ComponentContext(this) }
    private lateinit var lithoView: LithoView

    override fun onResume() {
        super.onResume()
        App.setRender(::render)
    }

    override fun onPause() {
        App.clearRender()
        super.onPause()
    }

    override fun onBackPressed() {
        if (!App.popRoute()) {
            super.onBackPressed()
        }
    }

    private fun render(props: Props, dispatch: Dispatch<Msg>) {
        val component = AppComponent.create(context)
            .props(props)
            .dispatch(dispatch)
            .build()

        if (initialized.compareAndSet(false, true)) {
            lithoView = LithoView.create(context, component)
            setContentView(lithoView)
        } else {
            lithoView.setComponentAsync(component)
        }
    }
}
