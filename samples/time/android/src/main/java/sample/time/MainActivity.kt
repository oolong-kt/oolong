package sample.time

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import time.Time
import oolong.Android

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeView = findViewById<TimeView>(R.id.time_view)

        Android.runtime(
            Time.init,
            Time.update,
            Time.view,
            timeView::render
        )
    }

}
