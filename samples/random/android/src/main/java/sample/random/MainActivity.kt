package sample.random

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import oolong.Oolong
import random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Oolong.runtime(
            Random.init,
            Random.update,
            Random.view,
            { props, dispatch -> setContent { Random(props, dispatch) } }
        )
    }

}
