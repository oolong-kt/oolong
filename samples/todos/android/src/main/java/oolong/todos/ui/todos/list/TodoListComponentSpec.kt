package oolong.todos.ui.todos.list

import android.graphics.Color
import android.view.KeyEvent
import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.FromEvent
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.Prop
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.widget.RecyclerCollectionComponent
import com.facebook.litho.widget.Card
import com.facebook.litho.widget.EditText
import com.facebook.litho.widget.KeyUpEvent
import com.facebook.litho.widget.TextChangedEvent
import com.facebook.yoga.YogaEdge
import oolong.Dispatch
import oolong.todos.todo.list.Msg
import oolong.todos.todo.list.Props
import oolong.todos.todo.list.Props.Body
import oolong.todos.todo.list.Props.Header

@LayoutSpec
object TodoListComponentSpec {

    @OnCreateLayout
    fun onCreateLayout(
        context: ComponentContext,
        @Prop props: Props,
        @Prop dispatch: Dispatch<Msg>
    ): Component {
        return Column.create(context)
            .backgroundColor(Color.WHITE)
            .child(header(context, props.header, dispatch))
            .child(body(context, props.body, dispatch))
            .build()
    }

    private fun header(context: ComponentContext, header: Header, dispatch: Dispatch<Msg>): Component {
        return Card.create(context)
            .content(
                EditText.create(context)
                    .backgroundColor(Color.WHITE)
                    .isSingleLine(true)
                    .textChangedEventHandler(TodoListComponent.onHeaderTextChanged(context))
                    .keyUpEventHandler(TodoListComponent.onHeaderKeyUp(context))
                    .textSizeSp(14F)
                    .hint("Add a todo")
                    .text(header.field)
                    .build()
            )
            .backgroundColor(Color.WHITE)
            .marginDip(YogaEdge.ALL, 16F)
            .paddingDip(YogaEdge.HORIZONTAL, 8F)
            .build()
    }

    private fun body(context: ComponentContext, body: Body, dispatch: Dispatch<Msg>): Component {
        return rows(context, body.rows, dispatch)
    }

    private fun rows(context: ComponentContext, rows: List<Body.Row>, dispatch: Dispatch<Msg>): Component {
        return RecyclerCollectionComponent.create(context)
            .section(
                TodoListSection.create(SectionContext(context))
                    .rows(rows)
                    .dispatch(dispatch)
                    .build()
            )
            .flexGrow(1F)
            .build()
    }

    @OnEvent(TextChangedEvent::class)
    fun onHeaderTextChanged(
        context: ComponentContext,
        @FromEvent text: String,
        @Prop dispatch: Dispatch<Msg>
    ) {
        dispatch(Msg.UpdateField(text))
    }

    @OnEvent(KeyUpEvent::class)
    fun onHeaderKeyUp(
        context: ComponentContext,
        @FromEvent keyCode: Int,
        @Prop dispatch: Dispatch<Msg>
    ): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            dispatch(Msg.AddTodo)
            return true
        }
        return false
    }

}
