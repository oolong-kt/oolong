package oolong.todos.oolong

import oolong.Dispatch
import oolong.Render

class RenderDelegate<Msg : Any, Props : Any> : Render<Msg, Props> {

    private lateinit var props: Props
    private lateinit var dispatch: Dispatch<Msg>

    private var delegate: Render<Msg, Props>? = null
    private var invoked = false

    override fun invoke(props: Props, dispatch: Dispatch<Msg>) {
        this.props = props
        this.dispatch = dispatch
        delegate?.invoke(this.props, this.dispatch)
        invoked = true
    }

    fun dispatch(msg: Msg) {
        dispatch.invoke(msg)
    }

    fun set(render: Render<Msg, Props>) {
        delegate = render
        if (invoked) {
            delegate?.invoke(props, dispatch)
        }
    }

    fun clear() {
        delegate = null
    }

}
