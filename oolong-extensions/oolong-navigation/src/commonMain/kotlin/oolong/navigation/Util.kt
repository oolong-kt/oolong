package oolong.navigation

import oolong.Dispatch
import oolong.dispatch.contramap

fun <A : Any, B : Any, Route : Any> contramap(
    dispatch: Dispatch<Router.Msg<A, Route>>,
    f: (B) -> A
): Dispatch<B> = contramap(dispatch, { msg -> Router.Msg.Route(f(msg)) })
