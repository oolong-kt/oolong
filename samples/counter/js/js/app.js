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
				onclick: function () {
					dispatch(props.onIncrement())
				}
			}, '+1'),
			h('p', {}, props.count),
			h('button', {
				onclick: function () {
					dispatch(props.onDecrement())
				}
			}, '-1')
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
