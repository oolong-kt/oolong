(function (window) {
	'use strict';

	var Oolong = oolong.oolong.Oolong;
	var Time = core.time.Time;
	var h = superfine.h;
	var patch = superfine.patch;

	var node;

	function render(props, dispatch) {
		return h('div', {}, [
			h('p', {
				class: 'mdc-typography mdc-typography--body1'
			}, new Date().toTimeString())
		]);
	}

	Oolong.runtime(
		Time.init,
		Time.update,
		Time.view,
		function (props, dispatch) {
			node = patch(node, render(props, dispatch), document.body);
		}
	)

})(window);
