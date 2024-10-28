package ru.netology.data

import java.util.Date

abstract class Attachment(
    open val type: String,
)

class PhotoAttachment(type: String = "photo", photo: Photo): Attachment(type)
{

}

class AudioAttachment(type: String = "audio", audio: Audio): Attachment(type)
{

}

class VideoAttachment(type: String = "video", video: Video): Attachment(type)
{

}

class DocAttachment(type: String = "doc", doc: Doc): Attachment(type)
{

}

class StickerAttachment(type: String = "sticker", sticker: Sticker): Attachment(type)
{

}

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val width: Int,
    val height: Int
)

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val lyricsId: Date,
    val albumId: Int,
    val genreId: Int,
    val date: Date,
    val noSearch: Boolean,
    val isHQ: Boolean
)

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: Int,
    val duration: Int,
    val date: Date,
    val addingDate: Date,
    val views: Int,
    val comments: Int,
    val canAdd: Boolean,
)

data class Doc(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Date
)

data class Sticker(
    val innerType: String = "base_sticker_new",
    val stickerId: Int,
    val productId: Int,
    val isAllowed: Boolean
)