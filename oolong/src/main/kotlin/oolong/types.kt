package oolong

import java.util.ArrayList

// Dispatch

typealias Dispatch<Msg> = (Msg) -> Unit

// Effects

typealias Eff<Msg> = (Dispatch<Msg>) -> Unit

fun <Msg> batchEff(effs: Iterable<Eff<Msg>>): Eff<Msg> = { dispatch: Dispatch<Msg> ->
    for (eff in effs) eff(dispatch)
}

// Commands

typealias Cmd<Msg> = Eff<Msg>

fun <Msg> noneCmd(): Cmd<Msg> = batchCmd(ArrayList(0))

fun <Msg> batchCmd(cmds: Iterable<Cmd<Msg>>): Cmd<Msg> = batchEff(cmds)

// Subscriptions

typealias Sub<Msg> = Eff<Msg>

fun <Msg> noneSub(): Sub<Msg> = batchSub(ArrayList(0))

fun <Msg> batchSub(subs: Iterable<Sub<Msg>>): Sub<Msg> = batchEff(subs)

// Updates

data class Update<Model, Msg>(
    val model: Model,
    val cmd: Cmd<Msg> = noneCmd()
)

// Program

data class Program<Model, Msg>(
    val init: () -> Update<Model, Msg>,
    val update: (Msg, Model) -> Update<Model, Msg>,
    val view: (Model, Dispatch<Msg>) -> Unit,
    val subscriptions: (Model) -> Sub<Msg> = { noneSub() }
)

