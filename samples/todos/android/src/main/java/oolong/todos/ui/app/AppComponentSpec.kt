package oolong.todos.ui.app

import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.Transition
import com.facebook.litho.animation.AnimatedProperties
import com.facebook.litho.animation.DimensionValue.widthPercentageOffset
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnCreateTransition
import com.facebook.litho.annotations.Prop
import oolong.Dispatch
import oolong.dispatch.contramap
import oolong.todos.app.Model.Direction
import oolong.todos.app.Msg
import oolong.todos.app.Props
import oolong.todos.ui.todos.detail.TodoDetailComponent
import oolong.todos.ui.todos.list.TodoListComponent

@LayoutSpec
object AppComponentSpec {

    // private val TRANSITION_ANIMATOR = Transition.timing(200, AccelerateDecelerateInterpolator())

    @OnCreateLayout
    fun onCreateLayout(
        context: ComponentContext,
        @Prop props: Props,
        @Prop dispatch: Dispatch<Msg>
    ): Component {
        val screen = when (props) {
            is Props.TodoList -> {
                TodoListComponent.create(context)
                    .props(props.props)
                    .dispatch(contramap(dispatch, Msg::TodoList))
            }
            is Props.TodoDetail -> {
                TodoDetailComponent.create(context)
                    .props(props.props)
                    .dispatch(contramap(dispatch, Msg::TodoDetail))
            }
        }

        return screen
            .transitionKey(javaClass.name)
            .build()
    }

    @OnCreateTransition
    fun onCreateTransition(
        context: ComponentContext,
        @Prop props: Props
    ): Transition? {
        return Transition.create(javaClass.name)
            // .animator(TRANSITION_ANIMATOR)
            .let { transition ->
                when (props.direction) {
                    Direction.FORWARD -> {
                        transition
                            .animate(AnimatedProperties.X)
                            .appearFrom(widthPercentageOffset(100F))
                            .disappearTo(widthPercentageOffset(-100F))
                    }
                    Direction.BACKWARD -> {
                        transition
                            .animate(AnimatedProperties.X)
                            .appearFrom(widthPercentageOffset(-100F))
                            .disappearTo(widthPercentageOffset(100F))
                    }
                    Direction.REPLACE -> null
                }
            }
    }

}
