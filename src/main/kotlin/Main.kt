fun main() {
    val originalPost = Post(
        id = generateId(),
        ownerId = 0,
        fromId = 0,
        createdBy = 0,
        date = 0,
        text = "Some text",
        replyOwnerId = 0,
        replyPostId = 0,
        friendsOnly = false,
        comments = Comments,
        copyright = Copyright,
        likes = Likes,
        reposts = Reposts,
        views = Views,
        postType = "Some type",
        signerId = 0,
        copyHistory = emptyArray<Reposts>(),
        canPin = true,
        canDelete = false,
        canEdit = true,
        isPinned = false,
        markedAsAds = false,
        isFavorite = false,
        donut = Donut,
        postponedId = 0
    )
    val newPost = Post(
        id = generateId(),
        ownerId = 0,
        fromId = 0,
        createdBy = 0,
        date = 0,
        text = "Another text",
        replyOwnerId = 0,
        replyPostId = 0,
        friendsOnly = false,
        comments = Comments,
        copyright = Copyright,
        likes = Likes,
        reposts = Reposts,
        views = Views,
        postType = "Another type",
        signerId = 0,
        copyHistory = emptyArray<Reposts>(),
        canPin = true,
        canDelete = false,
        canEdit = true,
        isPinned = false,
        markedAsAds = false,
        isFavorite = false,
        donut = Donut,
        postponedId = 0
    )

    WallService.add(originalPost)

    WallService.update(originalPost, newPost)
}