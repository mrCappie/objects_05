package ru.netology

import ru.netology.data.*
import ru.netology.service.WallService

fun main() {

    val likes = Likes(1)
    val comments = Comments(1)

    var attachments: Array<Attachment> = emptyArray()
    attachments += PhotoAttachment(photo = Photo(1, 1, 1, 1, "аывфаыва", 23523523, 100, 100))
    attachments += StickerAttachment(sticker = Sticker(1.toString(), 1, 1, true))

    var post1 = Post(
        ownerId = 1,
        fromId = 1110,
        date = 1730028987,
        text = "Пост1",
        likes = likes,
        comments = comments,

    )

    WallService.add(post1)

    var post2 = Post(
        ownerId = 1,
        fromId = 1110,
        date = 1730028988,
        text = "Пост2",
        likes = likes,
        comments = comments
    )

    post2 = WallService.add(post2)

    var post3 = Post(
        ownerId = 1,
        fromId = 1110,
        date = 1730028990,
        text = "Пост3",
        likes = likes,
        comments = comments
    )

    WallService.add(post3)

    val updatedPost = post2.copy(date = (System.currentTimeMillis()/ 1000).toInt(),
        text = "Обновленный пост 2")

    val result = WallService.update(updatedPost)

}