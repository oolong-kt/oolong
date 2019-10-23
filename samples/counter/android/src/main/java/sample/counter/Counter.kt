package sample.counter

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.layout.Center
import androidx.ui.layout.Column
import androidx.ui.layout.Spacing
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import counter.Counter
import oolong.Dispatch

@Composable
fun Counter(props: Counter.Props, dispatch: Dispatch<Counter.Msg>) {
    MaterialTheme {
        Center {
            Column {
                Center {
                    Button(onClick = { dispatch(props.onDecrement()) }) {
                        Text("-")
                    }
                }
                Center {
                    Text(
                        text = "${props.count}",
                        modifier = Spacing(16.dp)
                    )
                }
                Center {
                    Button(onClick = { dispatch(props.onIncrement()) }) {
                        Text("+")
                    }
                }
            }
        }
    }
}
