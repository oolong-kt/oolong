package oolong.util

import oolong.Dispatch
import oolong.platform.Sub
import java.util.Date
import java.util.Timer
import java.util.TimerTask

fun <Msg> Timer.schedule(time: Date, msg: (Long) -> Msg) = Sub<Msg> { dispatch ->
    schedule(timerTask(dispatch, msg), time)
}

fun <Msg> Timer.schedule(firstTime: Date, period: Long, msg: (Long) -> Msg) = Sub<Msg> { dispatch ->
    schedule(timerTask(dispatch, msg), firstTime, period)
}

fun <Msg> Timer.schedule(delay: Long, msg: (Long) -> Msg) = Sub<Msg> { dispatch ->
    schedule(timerTask(dispatch, msg), delay)
}

fun <Msg> Timer.schedule(delay: Long, period: Long, msg: (Long) -> Msg) = Sub<Msg> { dispatch ->
    schedule(timerTask(dispatch, msg), delay, period)
}

fun <Msg> Timer.scheduleAtFixedRate(firstTime: Date, period: Long, msg: (Long) -> Msg) =
    Sub<Msg> { dispatch ->
        scheduleAtFixedRate(timerTask(dispatch, msg), firstTime, period)
    }

fun <Msg> Timer.scheduleAtFixedRate(delay: Long, period: Long, msg: (Long) -> Msg) =
    Sub<Msg> { dispatch ->
        scheduleAtFixedRate(timerTask(dispatch, msg), delay, period)
    }

private fun <Msg> timerTask(dispatch: Dispatch<Msg>, msg: (Long) -> Msg): TimerTask {
    return object : TimerTask() {
        override fun run() {
            dispatch(msg(System.currentTimeMillis()))
        }
    }
}
