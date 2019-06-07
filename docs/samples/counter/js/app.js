(function (window) {
	'use strict';

	var Oolong = oolong.oolong.Oolong;
	var Counter = core.counter.Counter;
	var h = superfine.h;
	var patch = superfine.patch;

	var node;

	function render(props, dispatch) {
		return h('div', {}, [
			h('button', {
				class: 'mdc-button mdc-button--raised mdc-button__label	',
				onclick: function () {
					dispatch(props.onIncrement())
				}
			}, h('span', { class: 'mdc-button__label' }, '+1')),
			h('p', {
				class: 'mdc-typography mdc-typography--body1'
			}, props.count),
			h('button', {
				class: 'mdc-button mdc-button--raised mdc-button__label	',
				onclick: function () {
					dispatch(props.onDecrement())
				}
			}, h('span', { class: 'mdc-button__label' }, '-1'))
		]);
	}

	Oolong.runtime(
		Counter.init,
		Counter.update,
		Counter.view,
		function (props, dispatch) {
			node = patch(node, render(props, dispatch), document.body);
		}
	)

})(window);
