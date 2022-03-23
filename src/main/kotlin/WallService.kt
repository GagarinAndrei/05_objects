object WallService {
    private var posts = emptyArray<Post>()

    internal fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    internal fun update(originalPost: Post, newPost: Post): Boolean {
        var result = false
        val (id) = originalPost
        val (_,
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

        for ((index, post) in posts.withIndex()) {
                if (post.id == id) {
                    posts[index] = post.copy(
                        id = id,
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
}