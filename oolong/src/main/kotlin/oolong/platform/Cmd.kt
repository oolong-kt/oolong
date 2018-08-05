package oolong.platform

import oolong.Dispatch

class Cmd<Msg>(private val block: (Dispatch<Msg>) -> Unit) {

    operator fun invoke(dispatch: Dispatch<Msg>) = block(dispatch)

    companion object {

        fun <Msg> none() = batch<Msg>(emptyList())

        fun <Msg> batch(vararg cmds: Cmd<Msg>) = batch(cmds.toList())

        fun <Msg> batch(cmds: Iterable<Cmd<Msg>>) = Cmd { dispatch: Dispatch<Msg> ->
            for (cmd in cmds) cmd(dispatch)
        }

    }

}