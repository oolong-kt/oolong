package oolong

fun <Model, Msg> runtime(program: Program<Model, Msg>): () -> Unit {
    val mainThread = Thread.currentThread()
    val update = program.update
    val view = program.view
    val subscriptions = program.subscriptions
    var running = true
    fun reduce(update: Update<Model, Msg>) {
        if (!running) return
        val dispatch = { msg: Msg ->
            if (Thread.currentThread() != mainThread) {
                throw IllegalThreadStateException("Dispatch function must be called from the main thread.")
            }
            reduce(update(msg, update.model))
        }
        update.cmd(dispatch)
        subscriptions(update.model)(dispatch)
        view(update.model, dispatch)
    }
    reduce(program.init())
    return { running = false }
}
