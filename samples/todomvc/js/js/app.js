(function (window) {
	'use strict';

	var Oolong = oolong.oolong.Oolong;
	var Todo = core.todo.Todo;
	var h = superfine.h;
	var patch = superfine.patch;

	var container = document.getElementById("container");
	var node;

	function render(props, dispatch) {
		return h('div', {}, [
			renderInput(props.input, dispatch),
			renderEntries(props.entries, dispatch),
			renderControls(props.controls, dispatch)
		]);
	}

	function renderInput(input, dispatch) {
		return h('header', { class: 'header' }, [
			h('h1', {}, 'todos'),
			h('input', {
				id: 'toggle-all',
				class: 'new-todo',
				placeholder: 'What needs to be done?',
				autofocus: true,
				value: input.value,
				oninput: function (e) {
					dispatch(input.onUpdateField(e.target.value));
				},
				onkeydown: function (e) {
					if (e.keyCode == 13) {
						dispatch(input.onAdd());
					}
				}
			})
		]);
	}

	function renderEntries(entries, dispatch) {
		return h('section', { class: 'main' }, [
			h('input', {
				id: 'toggle-all',
				class: 'toggle-all',
				type: 'checkbox',
				checked: entries.allCompleted
			}),
			h('label', {
				for: 'toggle-all',
				onclick: function () {
					dispatch(entries.onCheckAll(!entries.allCompleted));
				}
			}, 'Mark all as complete'),
			h('ul', { class: 'todo-list' }, [
				entries.entries
					.toArray()
					.map((entry) => renderEntry(entry, dispatch))
			])
		]);
	}

	function renderEntry(entry, dispatch) {
		var classList = '';
		if (entry.completed) {
			classList += ' completed';
		}
		if (entry.editing) {
			classList += ' editing';
		}
		return h('li', { class: classList }, [
			h('div', { class: 'view' }, [
				h('input', {
					class: 'toggle',
					type: 'checkbox',
					checked: entry.completed,
					onclick: function () {
						dispatch(entry.onCheck(entry.id, !entry.completed));
					}
				}),
				h('label', {
					ondblclick: function () {
						dispatch(entry.onEditingEntry(entry.id, true));
					}
				}, entry.description),
				h('button', {
					class: 'destroy',
					onclick: function () {
						dispatch(entry.onDelete(entry.id));
					}
				})
			]),
			h('input', {
				class: 'edit',
				value: entry.description,
				oninput: function (e) {
					dispatch(entry.onUpdateEntry(entry.id, e.target.value));
				},
				onblur: function () {
					dispatch(entry.onEditingEntry(entry.id, false));
				},
				onkeydown: function (e) {
					if (e.keyCode == 13) {
						dispatch(entry.onEditingEntry(entry.id, false));
					}
				}
			})
		]);
	}

	function renderControls(controls, dispatch) {
		return h('footer',
			{
				class: 'footer',
				hidden: controls.hidden
			}, [
				renderControlsCount(controls.count, dispatch),
				renderControlsFilters(controls.filters, dispatch),
				renderControlsClear(controls.clear, dispatch)
			]);
	}

	function renderControlsCount(count) {
		return h('span', { class: 'todo-count' }, [
			h('strong', {}, count.entriesLeft)
		], count.entriesLeft == 1 ? ' item left' : ' items left');
	}

	function renderControlsFilters(filters, dispatch) {
		return h('ul', { class: 'filters' }, [
			visibilitySwap('#/', "All", filters.allVisibilitySwap, dispatch),
			visibilitySwap('#/active', "Active", filters.activeVisibilitySwap, dispatch),
			visibilitySwap('#/completed', "Completed", filters.completedVisibilitySwap, dispatch)
		]);
	}

	function visibilitySwap(uri, text, visibilitySwap, dispatch) {
		return h('li',
			{
				onclick: function () {
					dispatch(visibilitySwap.onChangeVisibility(visibilitySwap.visibility))
				}
			}, [
				h('a', {
					href: uri,
					class: visibilitySwap.selected ? 'selected' : ''
				}, text)
			]);
	}

	function renderControlsClear(clear, dispatch) {
		return h('button', {
			class: 'clear-completed',
			hidden: clear.hidden,
			onclick: function () {
				dispatch(clear.onDeleteCompleted());
			}
		}, 'Clear completed')
	}

	Oolong.runtime(
		Todo.init(null),
		Todo.update,
		Todo.view,
		function (props, dispatch) {
			node = patch(node, render(props, dispatch), container)
		}
	)

})(window);
