package todo

import oolong.Init
import oolong.Update
import oolong.View
import oolong.effect.none

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
                model to none()
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
                ) to none()
            }
            is Msg.UpdateField -> {
                model.copy(field = msg.str) to none()
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
                model.copy(entries = model.entries.map(updateEntry)) to none()
            }
            is Msg.UpdateEntry -> {
                val updateEntry = { entry: Entry ->
                    if (entry.id == msg.entryId) {
                        entry.copy(description = msg.description)
                    } else {
                        entry
                    }
                }
                model.copy(entries = model.entries.map(updateEntry)) to none()
            }
            is Msg.Delete -> {
                model.copy(entries = model.entries.filter { entry -> entry.id != msg.entryId }) to none()
            }
            Msg.DeleteComplete -> {
                model.copy(entries = model.entries.filter { entry -> !entry.completed }) to none()
            }
            is Msg.Check -> {
                val updateEntry = { entry: Entry ->
                    if (entry.id == msg.entryId) {
                        entry.copy(completed = msg.completed)
                    } else {
                        entry
                    }
                }
                model.copy(entries = model.entries.map(updateEntry)) to none()
            }
            is Msg.CheckAll -> {
                val updateEntry = { entry: Entry ->
                    entry.copy(completed = msg.completed)
                }
                model.copy(entries = model.entries.map(updateEntry)) to none()
            }
            is Msg.ChangeVisibility -> {
                model.copy(visibility = msg.visibility) to none()
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
            val onUpdateField: (String) -> Msg,
            val onAdd: () -> Msg
        )

        data class Entries(
            val visible: Boolean,
            val allCompleted: Boolean,
            val onCheckAll: () -> Msg,
            val entries: List<Entry>
        ) {

            data class Entry(
                val id: Int,
                val completed: Boolean,
                val editing: Boolean,
                val description: String,
                val onCheck: (Int, Boolean) -> Msg,
                val onUpdateEntry: (Int, String) -> Msg,
                val onEditingEntry: (Int, Boolean) -> Msg,
                val onDelete: (Int) -> Msg
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
                    val onChangeVisibility: (Visibility) -> Msg
                )

            }

            data class Clear(
                val hidden: Boolean,
                val entriesCompleted: Int,
                val onDeleteCompleted: () -> Msg
            )
        }

    }

    val view: View<Model, Props> = { model ->
        Props(
            viewInput(model.field),
            viewEntries(model.visibility, model.entries),
            viewControls(model.visibility, model.entries)
        )
    }

    val viewInput = { task: String ->
        val onUpdateField = { value: String -> Msg.UpdateField(value) }
        val onAdd = { Msg.Add }
        Props.Input(
            task,
            onUpdateField,
            onAdd
        )
    }

    // VIEW ALL ENTRIES


    val viewEntries = { visibility: Visibility, entries: List<Entry> ->
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
            { Msg.CheckAll(!allCompleted) },
            entries.filter(isVisible).map { entry -> viewEntry(entry) }
        )
    }

    // VIEW INDIVIDUAL ENTRIES

    val viewEntry = { todo: Entry ->
        Props.Entries.Entry(
            todo.id,
            todo.completed,
            todo.editing,
            todo.description,
            { id: Int, completed: Boolean -> Msg.Check(id, completed) },
            { id: Int, description: String -> Msg.UpdateEntry(id, description) },
            { id: Int, completed: Boolean -> Msg.EditingEntry(id, completed) },
            { id: Int -> Msg.Delete(id) }
        )
    }

    // VIEW CONTROLS AND FOOTER

    val viewControls = { visibility: Visibility, entries: List<Entry> ->
        val entriesCompleted = entries.filter(Entry::completed).size
        val entriesLeft = entries.size - entriesCompleted
        Props.Controls(
            entries.isEmpty(),
            viewControlsCount(entriesLeft),
            viewControlsFilters(visibility),
            viewControlsClear(entriesCompleted)
        )
    }

    val viewControlsCount = { entriesLeft: Int ->
        Props.Controls.Count(
            entriesLeft
        )
    }

    val viewControlsFilters = { visibility: Visibility ->
        Props.Controls.Filters(
            visibilitySwap(Visibility.ALL, visibility),
            visibilitySwap(Visibility.ACTIVE, visibility),
            visibilitySwap(Visibility.COMPLETED, visibility)
        )
    }

    val visibilitySwap = { visibility: Visibility, actualVisibility: Visibility ->
        Props.Controls.Filters.VisibilitySwap(
            visibility == actualVisibility,
            visibility,
            { Msg.ChangeVisibility(visibility) }
        )
    }

    val viewControlsClear = { entriesCompleted: Int ->
        Props.Controls.Clear(
            entriesCompleted == 0,
            entriesCompleted,
            { Msg.DeleteComplete }
        )
    }

}
