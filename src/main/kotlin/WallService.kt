object WallService {
    private var posts = emptyArray<Post>()

    internal fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    internal fun update(originalPost: Post, newPost: Post): Boolean {
        var result = false
        val (originalId) = originalPost
        val (id,
            ownerId,
            fromId,
            createdBy,
            date,
            text,
            replyOwnerId,
            replyPostId,
            friendsOnly,
            comments,
            copyright,
            likes,
            reposts,
            views,
            postType,
            attachment,
            signerId,
            copyHistory,
            canPin,
            canDelete,
            canEdit,
            isPinned,
            markedAsAds,
            isFavorite,
            donut,
            postponedId) = newPost

        posts.withIndex().forEach { (index, post) ->
            if (post.id == id) {
                posts[index] = post.copy(
                    id = originalId,
                    ownerId = ownerId,
                    fromId = fromId,
                    createdBy = createdBy,
                    date = date,
                    text = text,
                    replyOwnerId = replyOwnerId,
                    replyPostId = replyPostId,
                    friendsOnly = friendsOnly,
                    comments = comments,
                    copyright = copyright,
                    likes = likes,
                    reposts = reposts,
                    views = views,
                    postType = postType,
                    attachment = attachment,
                    signerId = signerId,
                    copyHistory = copyHistory,
                    canPin = canPin,
                    canDelete = canDelete,
                    canEdit = canEdit,
                    isPinned = isPinned,
                    markedAsAds = markedAsAds,
                    isFavorite = isFavorite,
                    donut = donut,
                    postponedId = postponedId
                )
                result = true
            }
        }
        return result
    }

    internal fun clearPosts() {
        posts = emptyArray<Post>()
    }

    internal fun addAttachment(type: String): Array<Attachment> {
        val array = emptyArray<Attachment>()
        val attachmentType: Attachment = when (type) {
            "video" -> VideoAttachment(Video(1, 1, 1, 1))
            "audio" -> AudioAttachment(Audio(2, 2, 2, 2))
            "photo" -> PhotoAttachment(Photo(3, 3, 3, 3))
            "link" -> LinkAttachment(Link(5, 5, 5, 5))
            else -> DocAttachment(Doc(4, 4, 4, 4))

        }
        array.plusElement(attachmentType)
            return array
    }
}