import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun `add$05_objects`() {
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

        // act
        WallService.add(originalPost)
        val (id) = originalPost
        val result = id != 0

        // assert
        assertEquals(true, result)
    }

//    @Test
//    fun `update$05_objects`() {
//    }
}