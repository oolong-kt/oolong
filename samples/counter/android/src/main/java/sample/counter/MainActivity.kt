package sample.counter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import counter.Counter
import oolong.Oolong

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Oolong.runtime(
            Counter.init,
            Counter.update,
            Counter.view,
            { props, dispatch -> setContent { Counter(props, dispatch) } }
        )
    }

}
