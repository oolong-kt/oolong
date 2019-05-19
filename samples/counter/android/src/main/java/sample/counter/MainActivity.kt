package sample.counter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import counter.Counter
import oolong.Oolong

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counterView = findViewById<CounterView>(R.id.counter_view)

        Oolong.runtime(
            Counter.init,
            Counter.update,
            Counter.view,
            counterView::render
        )
    }

}
