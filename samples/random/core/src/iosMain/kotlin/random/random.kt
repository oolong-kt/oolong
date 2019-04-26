package random

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
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
