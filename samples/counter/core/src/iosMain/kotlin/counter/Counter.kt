package counter

import counter.Counter.Msg
import counter.Counter.Props
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import oolong.Oolong
import oolong.Render

fun Counter.runtime(render: Render<Msg, Props>) =
    Oolong.runtime(
        init,
        update,
        view,
        render,
        GlobalScope,
        Dispatchers.Default,
        MainLoopDispatcher
    )

