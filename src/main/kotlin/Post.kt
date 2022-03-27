import kotlin.random.Random

internal data class Post (
    internal val id: Int = generateId(),
    internal val ownerId: Int,
    internal val fromId: Int,
    internal val createdBy: Int,
    internal val date: Int,
    internal val text: String,
    internal val replyOwnerId: Int,
    internal val replyPostId: Int,
    internal val friendsOnly: Boolean,
    internal val comments: Comments?,
    internal val copyright: Copyright?,
    internal val likes: Likes?,
    internal val reposts: Reposts?,
    internal val views: Views?,
    internal val postType: String,
    internal val attachment: Array<Attachment>?,
    internal val signerId: Int,
    internal val copyHistory: Array<Reposts>?,
    internal val canPin: Boolean,
    internal val canDelete: Boolean,
    internal val canEdit: Boolean,
    internal val isPinned: Boolean,
    internal val markedAsAds: Boolean,
    internal val isFavorite: Boolean,
    internal val donut: Donut?,
    internal val postponedId: Int
)

internal fun generateId(): Int {
    return Random(Int.MAX_VALUE).hashCode()
}

internal fun addAttachment(type: String): Array<Attachment> {
    var array = emptyArray<Attachment>()
    val attachmentType = when (type) {
        is "video" -> VideoAttachment(Video(1, 1, 1, 1))
        is "audio" -> AudioAttachment(Audio(2, 2, 2, 2))
        is "photo" -> PhotoAttachment(Photo(3, 3, 3, 3))
        is "doc" -> DocAttachment(Doc(4, 4, 4, 4))
        is "link" -> LinkAttachment(Link(5, 5, 5, 5))
        else -> {null}
    }
    array += attachmentType
    return array
}