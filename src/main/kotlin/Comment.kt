class Comment(
    internal val id: Int = generateId(),
    internal val postId: Int,
    internal val fromId: Int,
    internal val date: Int,
    internal val text: String,
    internal val donut: Donut,
    internal val isDon: Boolean,
    internal val replyToUser: Int,
    internal val replyToComment: Int,
    internal val attachments: Array<Attachment>
) {

}