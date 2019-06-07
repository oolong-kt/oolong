(function (window) {
	'use strict';

	var Oolong = oolong.oolong.Oolong;
	var Random = core.random.Random;
	var h = superfine.h;
	var patch = superfine.patch;

	var node;

	function render(props, dispatch) {
		return h('div', {}, [
			h('p', {
				class: 'mdc-typography mdc-typography--body1'
			}, props.dieFace),
			h('button', {
				class: 'mdc-button mdc-button--raised mdc-button__label	',
				onclick: function () {
					dispatch(props.onRoll())
				}
			}, 'Roll')
		]);
	}

	Oolong.runtime(
		Random.init,
		Random.update,
		Random.view,
		function (props, dispatch) {
			node = patch(node, render(props, dispatch), document.body);
		}
	)

})(window);
