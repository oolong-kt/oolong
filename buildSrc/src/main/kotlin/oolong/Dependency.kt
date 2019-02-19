package oolong

class Dependency(
    private val group: Group,
    private val artifact: Artifact
) : WithCharSequence {

    constructor(
        group: Group,
        artifactId: String,
        version: String = group.id
    ) : this(group, Artifact(artifactId, version))


    abstract class Group(
        val id: String,
        val version: String? = null
    ) : WithCharSequence {

        constructor(parent: Group) : this(parent.id, parent.version)

        open val DEFAULT: Artifact? = null

        final override fun toString(): String {
            return DEFAULT?.let { Dependency(this, it).toString() } ?: id
        }

    }

    class Artifact(
        val id: String,
        val version: String? = null
    ) : WithCharSequence

    override fun toString(): String {
        val version = group.version
            ?: artifact.version
            ?: throw IllegalArgumentException("Version must be provided by Group or Artifact.")
        return "${group.id}:${artifact.id}:$version"
    }

}