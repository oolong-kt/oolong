package oolong

fun <Model, Msg> runtime(program: Program<Model, Msg>): () -> Unit {
    val mainThread = Thread.currentThread()
    val update = program.update
    val view = program.view
    val subscriptions = program.subscriptions
    var state: Model
    var running = true
    fun reduce(update: Update<Model, Msg>) {
        if (!running) return
        state = update.model
        val dispatch = { msg: Msg ->
            if (Thread.currentThread() != mainThread) {
                throw IllegalThreadStateException("Dispatching must be done on the main thread.")
            }
            reduce(update(msg, state))
        }
        val effDispatch = { msg: Msg ->
            if (Thread.currentThread() == mainThread) {
                throw IllegalThreadStateException("Cannot run side effects on the main thread.")
            }
            reduce(update(msg, state))
        }
        update.cmd(dispatch)
        subscriptions(state)(effDispatch)
        view(state, dispatch)
    }
    reduce(program.init())
    return { running = false }
}
