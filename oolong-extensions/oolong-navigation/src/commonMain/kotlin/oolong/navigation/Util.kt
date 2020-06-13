package oolong.navigation

import oolong.Dispatch
import oolong.dispatch.contramap
import oolong.navigation.NavComponent.NavMsg

fun <A : Any, B : Any, Route : Any> contramap(
    dispatch: Dispatch<NavMsg<A, Route>>,
    f: (B) -> A
): Dispatch<B> = contramap(dispatch, { msg -> NavMsg.Screen(f(msg)) })
