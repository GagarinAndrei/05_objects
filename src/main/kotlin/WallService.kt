object WallService {
    private var posts = emptyArray<Post>()
    private var commentsArray = emptyArray<Comment>()

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

    internal fun createComment(comment: Comment): Boolean {
        var postNumber: Int = -1
        for (i in 0 until posts.size) {
            if (comment.postId == posts[i].id) {
                postNumber = i
            }
        }
        if (postNumber != -1) {
            posts[postNumber].comments = posts[postNumber].comments?.plus(comment)
            return true
        } else throw PostNotFoundException("Post not found!")
    }
}