object WallService {
    private var posts = emptyArray<Post>()
    private var commentsArray = emptyArray<Comment>()

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun update(originalPost: Post, newPost: Post): Boolean {
        var result = false
        val (originalId, originalOwner, _, _, originalDate) = originalPost
        val (id,
            _,
            fromId,
            createdBy,
            _,
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
                    ownerId = originalOwner,
                    fromId = fromId,
                    createdBy = createdBy,
                    date = originalDate,
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

    fun clearPosts() {
        posts = emptyArray<Post>()
    }

    fun createComment(comment: Comment): Boolean {
        var postNumber: Int = -1
        for (i in posts.indices) {
            if (comment.postId == posts[i].id) {
                postNumber = i
            }
        }
        if (postNumber != -1) {
            posts[postNumber].comments = posts[postNumber].comments?.plus(comment)
            return true
        } else throw PostNotFoundException("Post not found!")
    }

    fun generateId(): Int {
        return if (posts.isEmpty()) 1 else posts.last().id + 1
    }
}