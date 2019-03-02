package sample.random

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import random.Random
import oolong.Android

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randomView = findViewById<RandomView>(R.id.random_view)

        Android.runtime(
            Random.init,
            Random.update,
            Random.view,
            randomView::render
        )
    }

}
