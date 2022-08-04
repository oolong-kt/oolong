package oolong

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import oolong.next.next

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
class RuntimeTest {

    enum class Stage {
        INIT,
        NEXT,
        EFFECT,
        DONE,
    }

    data class Props(
        val stage: Stage,
        val dispatch: Dispatch<Stage>,
    )

    @Test
    fun `runtime should call render initially`() = runTest {
        val initialState = 1
        runtime(
            { next(initialState) },
            { _: Unit, model: Int -> next(model) },
            { model: Int, _: Dispatch<Unit> -> model },
            { props: Int -> assertEquals(initialState, props) },
        )
    }

    @Test
    fun `runtime should call render after dispatch`() = runTest {
        var count = 0
        runtime(
            { next(Stage.INIT) },
            { msg: Stage, _: Stage -> next(msg) },
            { model: Stage, dispatch: Dispatch<Stage> -> Props(model, dispatch) },
            { props: Props ->
                count++
                when (props.stage) {
                    Stage.INIT -> props.dispatch(Stage.NEXT)
                    Stage.NEXT -> props.dispatch(Stage.DONE)
                    else -> assertEquals(count, 3)
                }
            },
        )
    }

    @Test
    fun `effects do not block runtime`() = runTest {
        val states = mutableListOf<Stage>()
        val initEffect = effect { dispatch ->
            delay(100)
            dispatch(Stage.EFFECT)
        }
        runtime(
            { next(Stage.INIT, initEffect) },
            { msg: Stage, _: Stage -> next(msg) },
            { model: Stage, dispatch: Dispatch<Stage> -> Props(model, dispatch) },
            { props: Props ->
                states.add(props.stage)
                when (props.stage) {
                    Stage.INIT -> props.dispatch(Stage.NEXT)
                    Stage.NEXT -> {
                        // Wait for DONE
                    }
                    Stage.EFFECT -> props.dispatch(Stage.DONE)
                    Stage.DONE ->
                        assertEquals(
                            listOf(
                                Stage.INIT,
                                Stage.NEXT,
                                Stage.EFFECT,
                                Stage.DONE,
                            ),
                            states
                        )
                }
            },
        )
    }

    @Test
    fun `runtime should not call update view render if cancelled`() = runTest {
        val initEffect = effect { dispatch ->
            delay(100)
            dispatch(Stage.EFFECT)
        }
        val job =
            runtime(
                { next(Stage.INIT, initEffect) },
                { msg: Stage, _: Stage -> next(msg) },
                { stage: Stage, _: Dispatch<Stage> -> stage },
                { stage -> if (stage != Stage.INIT) fail() },
            )
        job.cancel()
    }

    private fun <Model, Msg, Props> TestScope.runtime(
        init: () -> Pair<Model, Effect<Msg>>,
        update: (Msg, Model) -> Pair<Model, Effect<Msg>>,
        view: (Model, Dispatch<Msg>) -> Props,
        render: (Props) -> Any?,
    ): Job =
        runtime(
            init,
            update,
            view,
            render,
            testScheduler,
            testScheduler,
            testScheduler,
        )
}
