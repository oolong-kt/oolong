package oolong.todos.ui.todos.list

import com.facebook.litho.annotations.Prop
import com.facebook.litho.sections.Children
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.common.SingleComponentSection
import oolong.Dispatch
import oolong.todos.todo.list.Msg
import oolong.todos.todo.list.Props

@GroupSectionSpec
object TodoListSectionSpec {

    @OnCreateChildren
    internal fun onCreateChildren(
        context: SectionContext,
        @Prop rows: List<Props.Body.Row>,
        @Prop dispatch: Dispatch<Msg>
    ): Children {
        val builder = Children.create()
        for (row in rows) {
            builder.child(
                SingleComponentSection.create(context)
                    .key("${row.id}")
                    .component(
                        TodoListItem.create(context)
                            .row(row)
                            .dispatch(dispatch)
                            .build()
                    )
            )
        }
        return builder.build()
    }

}
