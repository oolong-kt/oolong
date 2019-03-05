package sample.random

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import oolong.Oolong
import random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randomView = findViewById<RandomView>(R.id.random_view)

        Oolong.Main.runtime(
            Random.init,
            Random.update,
            Random.view,
            randomView::render
        )
    }

}
