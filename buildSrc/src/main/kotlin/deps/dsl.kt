package deps

abstract class Group(val groupId: String, val version: String) {

    fun artifact(artifactId: String, version: String = this.version) =
        dependency(groupId, artifactId, version)
}

fun dependency(groupId: String, artifactId: String, version: String) =
    "$groupId:$artifactId:$version"
