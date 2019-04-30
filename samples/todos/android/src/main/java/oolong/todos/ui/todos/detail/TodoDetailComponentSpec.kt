package oolong.todos.ui.todos.detail

import android.graphics.Color
import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaEdge
import oolong.Dispatch
import oolong.todos.todo.detail.Msg
import oolong.todos.todo.detail.Props
import oolong.todos.ui.app.AppComponentSpec

@LayoutSpec
object TodoDetailComponentSpec {

    @OnCreateLayout
    fun onCreateLayout(
        context: ComponentContext,
        @Prop props: Props,
        @Prop dispatch: Dispatch<Msg>
    ): Component {
        return Column.create(context)
            .backgroundColor(Color.WHITE)
            .child(body(context, props.title, dispatch))
            .build()
    }

    private fun body(context: ComponentContext, title: String, dispatch: Dispatch<Msg>): Component {
        return Text.create(context)
            .paddingDip(YogaEdge.ALL, 16F)
            .textSizeSp(18F)
            .text(title)
            .build()
    }
}
