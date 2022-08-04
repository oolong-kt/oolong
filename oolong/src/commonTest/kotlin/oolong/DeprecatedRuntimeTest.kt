package oolong

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import oolong.next.next

@ExperimentalCoroutinesApi
class DeprecatedRuntimeTest {

    enum class Stage {
        INIT,
        NEXT,
        EFFECT,
        DONE,
    }

    data class Props(
        val stage: Stage,
    )

    @Test
    fun `runtime should call render initially`() = runTest {
        val initialState = 1
        runtime(
            { next(initialState) },
            { _: Unit, model: Int -> next(model) },
            { model: Int -> model },
            { props: Int, _: Dispatch<Unit> -> assertEquals(initialState, props) },
        )
    }

    @Test
    fun `runtime should call render after dispatch`() = runTest {
        var count = 0
        runtime(
            { next(Stage.INIT) },
            { msg: Stage, _: Stage -> next(msg) },
            { model: Stage -> Props(model) },
            { props: Props, dispatch: Dispatch<Stage> ->
                count++
                when (props.stage) {
                    Stage.INIT -> dispatch(Stage.NEXT)
                    Stage.NEXT -> dispatch(Stage.DONE)
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
            { model: Stage -> Props(model) },
            { props: Props, dispatch: Dispatch<Stage> ->
                states.add(props.stage)
                when (props.stage) {
                    Stage.INIT -> dispatch(Stage.NEXT)
                    Stage.NEXT -> {
                        // Wait for DONE
                    }
                    Stage.EFFECT -> dispatch(Stage.DONE)
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
                { stage: Stage -> stage },
                { stage, _ -> if (stage != Stage.INIT) fail() },
            )
        job.cancel()
    }

    private fun <Model, Msg, Props> TestScope.runtime(
        init: () -> Pair<Model, Effect<Msg>>,
        update: (Msg, Model) -> Pair<Model, Effect<Msg>>,
        view: (Model) -> Props,
        render: (Props, Dispatch<Msg>) -> Any?,
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
