(function (window) {
	'use strict';

	var Oolong = oolong.oolong.Oolong;
	var Todo = core.todo.Todo;
	var h = superfine.h;
	var patch = superfine.patch;

	var container = document.getElementById("container");
	var node;

	function render(props) {
		return h('div', {}, [
			renderInput(props.input),
			renderEntries(props.entries),
			renderControls(props.controls)
		]);
	}

	function renderInput(input) {
		return h('header', { class: 'header' }, [
			h('h1', {}, 'todos'),
			h('input', {
				id: 'toggle-all',
				class: 'new-todo',
				placeholder: 'What needs to be done?',
				autofocus: true,
				value: input.value,
				oninput: function (e) {
					input.onUpdateField(e.target.value);
				},
				onkeydown: function (e) {
					if (e.keyCode == 13) {
						input.onAdd();
					}
				}
			})
		]);
	}

	function renderEntries(entries) {
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
					entries.onCheckAll(!entries.allCompleted);
				}
			}, 'Mark all as complete'),
			h('ul', { class: 'todo-list' }, [
				entries.entries.toArray().map(renderEntry)
			])
		]);
	}

	function renderEntry(entry) {
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
						entry.onCheck(entry.id, !entry.completed);
					}
				}),
				h('label', {
					ondblclick: function () {
						entry.onEditingEntry(entry.id, true)
					}
				}, entry.description),
				h('button', {
					class: 'destroy',
					onclick: function () {
						entry.onDelete(entry.id);
					}
				})
			]),
			h('input', {
				class: 'edit',
				value: entry.description,
				oninput: function (e) {
					entry.onUpdateEntry(entry.id, e.target.value);
				},
				onblur: function () {
					entry.onEditingEntry(entry.id, false);
				},
				onkeydown: function (e) {
					if (e.keyCode == 13) {
						entry.onEditingEntry(entry.id, false);
					}
				}
			})
		]);
	}

	function renderControls(controls) {
		return h('footer',
			{
				class: 'footer',
				hidden: controls.hidden
			}, [
				renderControlsCount(controls.count),
				renderControlsFilters(controls.filters),
				renderControlsClear(controls.clear)
			]);
	}

	function renderControlsCount(count) {
		return h('span', { class: 'todo-count' }, [
			h('strong', {}, count.entriesLeft)
		], count.entriesLeft == 1 ? ' item left' : ' items left');
	}

	function renderControlsFilters(filters) {
		return h('ul', { class: 'filters' }, [
			visibilitySwap('#/', "All", filters.allVisibilitySwap),
			visibilitySwap('#/active', "Active", filters.activeVisibilitySwap),
			visibilitySwap('#/completed', "Completed", filters.completedVisibilitySwap)
		]);
	}

	function visibilitySwap(uri, text, visibilitySwap) {
		return h('li',
			{
				onclick: function () {
					visibilitySwap.onChangeVisibility(visibilitySwap.visibility)
				}
			}, [
				h('a', {
					href: uri,
					class: visibilitySwap.selected ? 'selected' : ''
				}, text)
			]);
	}

	function renderControlsClear(clear) {
		return h('button', {
			class: 'clear-completed',
			hidden: clear.hidden,
			onclick: function () { clear.onDeleteCompleted(); }
		}, 'Clear completed')
	}

	Oolong.runtime(
		Todo.init(null),
		Todo.update,
		Todo.view,
		function (props) {
			console.log(props)
			node = patch(node, render(props), container)
		}
	)

})(window);