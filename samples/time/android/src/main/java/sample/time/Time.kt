package sample.time

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.layout.Center
import androidx.ui.layout.Column
import androidx.ui.material.MaterialTheme
import time.Time
import oolong.Dispatch
import java.text.DateFormat
import java.util.*

private val formatter = DateFormat.getTimeInstance()

@Composable
fun Time(props: Time.Props, dispatch: Dispatch<Time.Msg>) {
    MaterialTheme {
        Center {
            Text(text = formatter.format(Date()))
        }
    }
}
