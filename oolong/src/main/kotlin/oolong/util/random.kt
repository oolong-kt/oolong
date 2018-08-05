package oolong.util

import oolong.platform.Cmd
import java.util.Random

fun <Msg> Random.nextBoolean(msg: (Boolean) -> Msg) = Cmd<Msg> { dispatch ->
    dispatch(msg(nextBoolean()))
}

fun <Msg> Random.nextDouble(msg: (Double) -> Msg) = Cmd<Msg> { dispatch ->
    dispatch(msg(nextDouble()))
}

fun <Msg> Random.nextFloat(msg: (Float) -> Msg) = Cmd<Msg> { dispatch ->
    dispatch(msg(nextFloat()))
}

fun <Msg> Random.nextGaussian(msg: (Double) -> Msg) = Cmd<Msg> { dispatch ->
    dispatch(msg(nextGaussian()))
}

fun <Msg> Random.nextInt(bound: Int, msg: (Int) -> Msg) = Cmd<Msg> { dispatch ->
    dispatch(msg(nextInt(bound)))
}

fun <Msg> Random.nextInt(msg: (Int) -> Msg) = Cmd<Msg> { dispatch ->
    dispatch(msg(nextInt()))
}

fun <Msg> Random.nextLong(msg: (Long) -> Msg) = Cmd<Msg> { dispatch ->
    dispatch(msg(nextLong()))
}
