package random

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainLoopDispatcher
import oolong.Oolong
import oolong.Render

fun Random.runtime(render: Render<Random.Msg, Random.Props>) =
    Oolong.runtime(
        init,
        update,
        view,
        render,
        GlobalScope,
        MainLoopDispatcher,
        MainLoopDispatcher
    )
