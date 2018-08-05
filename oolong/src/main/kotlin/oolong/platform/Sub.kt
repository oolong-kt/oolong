package oolong.platform

import oolong.Dispatch

class Sub<Msg>(private val block: (Dispatch<Msg>) -> Unit) {

    operator fun invoke(dispatch: Dispatch<Msg>) = block(dispatch)

    companion object {

        fun <Msg> none() = batch<Msg>(emptyList())

        fun <Msg> batch(vararg subs: Sub<Msg>) = batch(subs.toList())

        fun <Msg> batch(effs: Iterable<Sub<Msg>>) = Sub { dispatch: Dispatch<Msg> ->
            for (eff in effs) eff(dispatch)
        }

    }

}