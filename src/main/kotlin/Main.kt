package ru.netology

import ru.netology.data.Comments
import ru.netology.data.Likes
import ru.netology.data.Post
import ru.netology.service.WallService

fun main() {

    val likes = Likes(1)
    val comments = Comments(1)

    var post1 = Post(
        ownerId = 1,
        fromId = 1110,
        date = 1730028987,
        text = "Пост1",
        likes = likes,
        comments = comments
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