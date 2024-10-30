package ru.netology

import org.junit.Test
import org.junit.Before

import org.junit.Assert.*
import ru.netology.data.*
import ru.netology.data.Comment
import ru.netology.service.PostNotFoundException
import ru.netology.service.WallService
import java.util.*

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {

        val likes = Likes(1)
        val comments = Comments(1)

        var post = Post(
            ownerId = 1,
            fromId = 1110,
            date = 1730028987,
            text = "Пост1",
            likes = likes,
            comments = comments
        )

        WallService.add(post)

        post = Post(
            ownerId = 1,
            fromId = 1110,
            date = 1730028988,
            text = "Пост2",
            likes = likes,
            comments = comments
        )

        WallService.add(post)

        post = Post(
            ownerId = 1,
            fromId = 1110,
            date = 1730028990,
            text = "Пост3",
            likes = likes,
            comments = comments
        )

        val result = WallService.add(post).id

        assertEquals(result, 3)
    }

    @Test
    fun updateTrue() {

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

        val updatedPost = post2.copy(
            date = (System.currentTimeMillis() / 1000).toInt(),
            text = "Обновленный пост 2"
        )

        val result = WallService.update(updatedPost)

        assertEquals(result, true)
    }

    @Test
    fun updateFalse() {

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

        WallService.add(post2)

        var post3 = Post(
            ownerId = 1,
            fromId = 1110,
            date = 1730028990,
            text = "Пост3",
            likes = likes,
            comments = comments
        )

        val result = WallService.update(post3)

        assertEquals(result, false)
    }

    @Test
    fun createComment() {

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

        WallService.add(post2)

        var post3 = Post(
            ownerId = 1,
            fromId = 1110,
            date = 1730028990,
            text = "Пост3",
            likes = likes,
            comments = comments
        )

        val newComment = Comment(1, 1, Date(), "Первый комментарий")

        val result = WallService.createComment(1, newComment)

        assertEquals(newComment, result)
    }

    @Test(expected = PostNotFoundException::class)
    fun createCommentWithException() {

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

        WallService.add(post2)

        var post3 = Post(
            ownerId = 1,
            fromId = 1110,
            date = 1730028990,
            text = "Пост3",
            likes = likes,
            comments = comments
        )

        WallService.add(post3)

        val newComment = Comment(1, 1, Date(), "Первый комментарий")

        WallService.createComment(4, newComment)

    }
}