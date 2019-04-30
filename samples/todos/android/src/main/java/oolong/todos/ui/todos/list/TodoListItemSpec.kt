package oolong.todos.ui.todos.list

import com.facebook.litho.ClickEvent
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.Row
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaEdge
import oolong.Dispatch
import oolong.todos.App
import oolong.todos.Routes
import oolong.todos.todo.list.Msg
import oolong.todos.todo.list.Props

@LayoutSpec
object TodoListItemSpec {

    @OnCreateLayout
    internal fun onCreateLayout(
        context: ComponentContext,
        @Prop row: Props.Body.Row,
        @Prop dispatch: Dispatch<Msg>
    ): Component {
        return Row.create(context)
            .child(
                Text.create(context)
                    .flex(1F)
                    .paddingDip(YogaEdge.ALL, 16F)
                    .text(row.title)
                    .textSizeSp(16F)
                    .clickHandler(TodoListItem.onClick(context))
                    .build()
            )
            .build()
    }

    @OnEvent(ClickEvent::class)
    fun onClick(
        context: ComponentContext,
        @Prop row: Props.Body.Row
    ) {
        App.pushRoute(Routes.todo(row.id))
    }

}
