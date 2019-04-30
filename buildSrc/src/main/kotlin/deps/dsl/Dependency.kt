package deps.dsl

class Dependency(
    private val group: Group,
    private val artifact: Artifact
) : WithCharSequence {

    constructor(
        group: Group,
        artifactId: String,
        version: String? = group.version
    ) : this(group, Artifact(artifactId, version))

    constructor(
        groupId: String,
        artifactId: String,
        version: String
    ) : this(Group(groupId, version), artifactId, version)

    open class Group(
        val id: String,
        val version: String? = null
    ) : WithCharSequence {

        constructor(
            parent: Group,
            version: String? = parent.version
        ) : this(parent.id, version)

        open val default: Dependency? = null

        final override fun toString(): String {
            return default?.toString() ?: id
        }
    }

    class Artifact(
        val id: String,
        val version: String? = null
    ) : WithCharSequence

    override fun toString(): String {
        val version = group.version
            ?: artifact.version
            ?: throw IllegalArgumentException("Version not provided for ${group.id}:${artifact.id}")
        return "${group.id}:${artifact.id}:$version"
    }
}
