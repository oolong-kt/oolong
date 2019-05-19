package counter

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainLoopDispatcher
import oolong.Oolong
import oolong.Render

fun Counter.runtime(render: Render<Counter.Msg, Counter.Props>) =
    Oolong.runtime(
        init,
        update,
        view,
        render,
        GlobalScope,
        MainLoopDispatcher,
        MainLoopDispatcher
    )

