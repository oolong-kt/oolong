package todo

import oolong.Dispatch
import oolong.Dispose
import oolong.Init
import oolong.Next
import oolong.Oolong
import oolong.Render
import oolong.Update
import oolong.View
import oolong.util.effect.noEffect

object Todo {

    // MODEL

    /**
     * The full application state of our todo app.
     */
    data class Model(
        val entries: List<Entry>,
        val field: String,
        val uid: Int,
        val visibility: Visibility
    )

    data class Entry(
        val description: String,
        val completed: Boolean,
        val editing: Boolean,
        val id: Int
    )

    enum class Visibility {
        ALL, ACTIVE, COMPLETED
    }

    val emptyModel: () -> Model = {
        Model(
            entries = emptyList(),
            visibility = Todo.Visibility.ALL,
            field = "",
            uid = 0
        )
    }

    val newEntry: (String, Int) -> Entry = { desc, id ->
        Entry(
            description = desc,
            completed = false,
            editing = false,
            id = id
        )
    }

    val init: (Model?) -> Init<Model, Msg> = { model ->
        {
            (model ?: emptyModel()) to { _ -> }
        }
    }

    // UPDATE

    /**
     * Users of our app can trigger messages by clicking and typing. These messages are fed into the `update` function
     * as they occur, letting us react to them.
     */
    sealed class Msg {

        object NoOp : Msg()

        data class UpdateField(
            val str: String
        ) : Msg()

        data class EditingEntry(
            val entryId: Int,
            val editing: Boolean
        ) : Msg()

        data class UpdateEntry(
            val entryId: Int,
            val description: String
        ) : Msg()

        object Add : Msg()

        data class Delete(
            val entryId: Int
        ) : Msg()

        object DeleteComplete : Msg()

        data class Check(
            val entryId: Int,
            val completed: Boolean
        ) : Msg()

        data class CheckAll(
            val completed: Boolean
        ) : Msg()

        data class ChangeVisibility(
            val visibility: Visibility
        ) : Msg()

    }

    val update: Update<Model, Msg> = { msg, model ->
        when (msg) {
            Msg.NoOp -> {
                model to noEffect()
            }
            Msg.Add -> {
                model.copy(
                    uid = model.uid + 1,
                    field = "",
                    entries = if (model.field.isBlank()) {
                        model.entries
                    } else {
                        model.entries + newEntry(model.field, model.uid)
                    }
                ) to noEffect()
            }
            is Msg.UpdateField -> {
                model.copy(field = msg.str) to noEffect()
            }
            is Msg.EditingEntry -> {
                val updateEntry = { entry: Entry ->
                    if (entry.id == msg.entryId) {
                        entry.copy(editing = msg.editing)
                    } else {
                        entry
                    }
                }
                // TODO: return effect to attempt focus of entry
                model.copy(entries = model.entries.map(updateEntry)) to noEffect()
            }
            is Msg.UpdateEntry -> {
                val updateEntry = { entry: Entry ->
                    if (entry.id == msg.entryId) {
                        entry.copy(description = msg.description)
                    } else {
                        entry
                    }
                }
                model.copy(entries = model.entries.map(updateEntry)) to noEffect()
            }
            is Msg.Delete -> {
                model.copy(entries = model.entries.filter { entry -> entry.id != msg.entryId }) to noEffect()
            }
            Msg.DeleteComplete -> {
                model.copy(entries = model.entries.filter { entry -> !entry.completed }) to noEffect()
            }
            is Msg.Check -> {
                val updateEntry = { entry: Entry ->
                    if (entry.id == msg.entryId) {
                        entry.copy(completed = msg.completed)
                    } else {
                        entry
                    }
                }
                model.copy(entries = model.entries.map(updateEntry)) to noEffect()
            }
            is Msg.CheckAll -> {
                val updateEntry = { entry: Entry ->
                    entry.copy(completed = msg.completed)
                }
                model.copy(entries = model.entries.map(updateEntry)) to noEffect()
            }
            is Msg.ChangeVisibility -> {
                model.copy(visibility = msg.visibility) to noEffect()
            }
        }
    }

    // VIEW

    data class Props(
        val input: Input,
        val entries: Entries,
        val controls: Controls
    ) {

        data class Input(
            val value: String,
            val onUpdateField: (String) -> Unit,
            val onAdd: () -> Unit
        )

        data class Entries(
            val visible: Boolean,
            val allCompleted: Boolean,
            val onCheckAll: () -> Unit,
            val entries: List<Entry>
        ) {

            data class Entry(
                val id: Int,
                val completed: Boolean,
                val editing: Boolean,
                val description: String,
                val onCheck: (Int, Boolean) -> Unit,
                val onUpdateEntry: (Int, String) -> Unit,
                val onEditingEntry: (Int, Boolean) -> Unit,
                val onDelete: (Int) -> Unit
            )
        }

        data class Controls(
            val hidden: Boolean,
            val count: Count,
            val filters: Filters,
            val clear: Clear
        ) {

            data class Count(
                val entriesLeft: Int
            )

            data class Filters(
                val allVisibilitySwap: VisibilitySwap,
                val activeVisibilitySwap: VisibilitySwap,
                val completedVisibilitySwap: VisibilitySwap
            ) {

                data class VisibilitySwap(
                    val selected: Boolean,
                    val visibility: Visibility,
                    val onChangeVisibility: (Visibility) -> Unit
                )

            }

            data class Clear(
                val hidden: Boolean,
                val entriesCompleted: Int,
                val onDeleteCompleted: () -> Unit
            )
        }

    }

    val view: View<Model, Msg, Props> = { model, dispatch ->
        Props(
            viewInput(model.field, dispatch),
            viewEntries(model.visibility, model.entries, dispatch),
            viewControls(model.visibility, model.entries, dispatch)
        )
    }

    val viewInput = { task: String, dispatch: Dispatch<Msg> ->
        val onUpdateField = { value: String -> dispatch(Msg.UpdateField(value)) }
        val onAdd = { dispatch(Msg.Add) }
        Props.Input(
            task,
            onUpdateField,
            onAdd
        )
    }

    // VIEW ALL ENTRIES


    val viewEntries = { visibility: Visibility, entries: List<Entry>, dispatch: Dispatch<Msg> ->
        val isVisible = { todo: Entry ->
            when (visibility) {
                Visibility.COMPLETED -> todo.completed
                Visibility.ACTIVE -> !todo.completed
                Visibility.ALL -> true
            }
        }
        val allCompleted = entries.all(Entry::completed)
        val visible = entries.isNotEmpty()
        Props.Entries(
            visible,
            allCompleted,
            { dispatch(Msg.CheckAll(!allCompleted)) },
            entries.filter(isVisible).map { entry -> viewEntry(entry, dispatch) }
        )
    }

    // VIEW INDIVIDUAL ENTRIES

    val viewEntry = { todo: Entry, dispatch: Dispatch<Msg> ->
        Props.Entries.Entry(
            todo.id,
            todo.completed,
            todo.editing,
            todo.description,
            { id: Int, completed: Boolean -> dispatch(Msg.Check(id, completed)) },
            { id: Int, description: String -> dispatch(Msg.UpdateEntry(id, description)) },
            { id: Int, completed: Boolean -> dispatch(Msg.EditingEntry(id, completed)) },
            { id: Int -> dispatch(Msg.Delete(id)) }
        )
    }

    // VIEW CONTROLS AND FOOTER

    val viewControls = { visibility: Visibility, entries: List<Entry>, dispatch: Dispatch<Msg> ->
        val entriesCompleted = entries.filter(Entry::completed).size
        val entriesLeft = entries.size - entriesCompleted
        Props.Controls(
            entries.isEmpty(),
            viewControlsCount(entriesLeft),
            viewControlsFilters(visibility, dispatch),
            viewControlsClear(entriesCompleted, dispatch)
        )
    }

    val viewControlsCount = { entriesLeft: Int ->
        Props.Controls.Count(
            entriesLeft
        )
    }

    val viewControlsFilters = { visibility: Visibility, dispatch: Dispatch<Msg> ->
        Props.Controls.Filters(
            visibilitySwap(Visibility.ALL, visibility, dispatch),
            visibilitySwap(Visibility.ACTIVE, visibility, dispatch),
            visibilitySwap(Visibility.COMPLETED, visibility, dispatch)
        )
    }

    val visibilitySwap = { visibility: Visibility, actualVisibility: Visibility, dispatch: Dispatch<Msg> ->
        Props.Controls.Filters.VisibilitySwap(
            visibility == actualVisibility,
            visibility,
            { dispatch(Msg.ChangeVisibility(visibility)) }
        )
    }

    val viewControlsClear = { entriesCompleted: Int, dispatch: Dispatch<Msg> ->
        Props.Controls.Clear(
            entriesCompleted == 0,
            entriesCompleted,
            { dispatch(Msg.DeleteComplete) }
        )
    }

}
