package sample.random

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.layout.Center
import androidx.ui.layout.Column
import androidx.ui.layout.Spacing
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import random.Random
import oolong.Dispatch

@Composable
fun Random(props: Random.Props, dispatch: Dispatch<Random.Msg>) {
    MaterialTheme {
        Center {
            Column {
                Center {
                    Text(
                        text = "${props.dieFace}",
                        modifier = Spacing(16.dp)
                    )
                }
                Center {
                    Button(onClick = { dispatch(props.onRoll()) }) {
                        Text("Roll")
                    }
                }
            }
        }
    }
}
