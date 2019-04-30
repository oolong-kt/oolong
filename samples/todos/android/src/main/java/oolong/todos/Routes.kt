package oolong.todos

import java.net.URI

object Routes {

    private const val SCHEME = "oolong.todos"
    private const val HOST = "oolong.todos"

    fun todos(): URI {
        return uri("todos")
    }

    fun todo(id: Long): URI {
        return uri("todos/$id")
    }

    private fun uri(path: String) =
        URI("$SCHEME://$HOST/$path")

}
