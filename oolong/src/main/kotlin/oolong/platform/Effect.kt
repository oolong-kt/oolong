package oolong.platform

import oolong.Dispatch

class Effect<Msg>(private val block: (Dispatch<Msg>) -> Unit) {

    operator fun invoke(dispatch: Dispatch<Msg>) =
        block(dispatch)

    companion object {

        fun <Msg> none() = batch<Msg>(emptyList())

        fun <Msg> batch(vararg effects: Effect<Msg>) = batch(effects.toList())

        fun <Msg> batch(effects: Iterable<Effect<Msg>>) = Effect { dispatch: Dispatch<Msg> ->
            for (effect in effects) effect(dispatch)
        }

    }

}