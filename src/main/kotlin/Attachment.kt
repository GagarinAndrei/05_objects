abstract class Attachment(val type: String) {
    var attachments: Array<Attachment> = emptyArray()
}

class VideoAttachment(val video: Video) : Attachment("video") {

}

class AudioAttachment(val audio: Audio) : Attachment("audio") {

}

class PhotoAttachment(val photo: Photo) : Attachment("photo") {

}

class DocAttachment(val doc: Doc) : Attachment("doc") {

}

class LinkAttachment(val link: Link) : Attachment("link") {

}

class Video(val id: Int, val albumId: Int, val ownerInt: Int, val userId: Int)
class Audio(val id: Int, val albumId: Int, val ownerInt: Int, val userId: Int)
class Photo(val id: Int, val albumId: Int, val ownerInt: Int, val userId: Int)
class Doc(val id: Int, val albumId: Int, val ownerInt: Int, val userId: Int)
class Link(val id: Int, val albumId: Int, val ownerInt: Int, val userId: Int)
