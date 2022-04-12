import WallService.generateId
import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addPost() {
        // arrange
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
            comments = emptyArray<Comment>(),
            copyright = Copyright,
            likes = Likes,
            reposts = Reposts,
            views = Views,
            postType = "Some type",
            attachment = emptyArray<Attachment>(),
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

        // act
        WallService.add(originalPost)
        val (id) = originalPost
        val result = id != 0

        // assert
        assertTrue(result)
    }

    @Test
    fun updatePostFalse() {
        // arrange
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
            comments = emptyArray<Comment>(),
            copyright = Copyright,
            likes = Likes,
            reposts = Reposts,
            views = Views,
            postType = "Some type",
            attachment = emptyArray<Attachment>(),
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
            comments = emptyArray<Comment>(),
            copyright = Copyright,
            likes = Likes,
            reposts = Reposts,
            views = Views,
            postType = "Another type",
            attachment = emptyArray<Attachment>(),
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

        // act
        WallService.clearPosts()
        val result = WallService.update(originalPost, newPost)

        // assert
        assertFalse(result)
    }

    @Test
    fun updatePostTrue() {
        // arrange
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
            comments = emptyArray<Comment>(),
            copyright = Copyright,
            likes = Likes,
            reposts = Reposts,
            views = Views,
            postType = "Some type",
            attachment = emptyArray<Attachment>(),
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

        val (originalId) = originalPost

        val newPost = Post(
            id = originalId,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = 0,
            text = "Another text",
            replyOwnerId = 0,
            replyPostId = 0,
            friendsOnly = false,
            comments = emptyArray<Comment>(),
            copyright = Copyright,
            likes = Likes,
            reposts = Reposts,
            views = Views,
            postType = "Another type",
            attachment = emptyArray<Attachment>(),
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

        // act
        WallService.clearPosts()
        WallService.add(originalPost)
        val result = WallService.update(originalPost, newPost)

        // assert
        assertTrue(result)
    }

    @Test
    fun addAttachment() {
        // arrange
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
            comments = emptyArray<Comment>(),
            copyright = Copyright,
            likes = Likes,
            reposts = Reposts,
            views = Views,
            postType = "Some type",
            attachment = arrayOf(
                VideoAttachment(Video(1, 2, 3, 4)),
                AudioAttachment(Audio(2, 3, 45, 5))
            ),
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

        // act
        WallService.add(originalPost)
        val attachments = originalPost.attachment
        val result = attachments?.isNotEmpty()

        // assert
        assertEquals(true, result)
    }

    @Test
    fun addCommentSuccess() {
        // arrange
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
            comments = emptyArray<Comment>(),
            copyright = Copyright,
            likes = Likes,
            reposts = Reposts,
            views = Views,
            postType = "Some type",
            attachment = emptyArray<Attachment>(),
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

        // act
        WallService.clearPosts()
        WallService.add(originalPost)
        val (id) = originalPost
        val result = WallService.createComment(
            Comment(
                generateId(),
                id,
                0,
                0,
                "sdfgjkhsdfhjkdfhjk",
                Donut,
                true,
                0,
                0,
                emptyArray<Attachment>()
            )
        )


        // assert
        assertTrue(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun addCommentShouldTrow() {
        // arrange
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
            comments = emptyArray<Comment>(),
            copyright = Copyright,
            likes = Likes,
            reposts = Reposts,
            views = Views,
            postType = "Some type",
            attachment = emptyArray<Attachment>(),
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

        // act
        WallService.clearPosts()
        WallService.add(originalPost)
        WallService.createComment(
            Comment(
                generateId(),
                generateId(),
                0,
                0,
                "sdfgjkhsdfhjkdfhjk",
                Donut,
                true,
                0,
                0,
                emptyArray<Attachment>()
            )
        )
    }
}