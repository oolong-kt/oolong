package sample.time

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import oolong.Oolong
import time.Time

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Oolong.runtime(
            Time.init,
            Time.update,
            Time.view,
            { props, dispatch -> setContent { Time(props, dispatch) } }
        )
    }

}
