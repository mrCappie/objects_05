package ru.netology.service

import ru.netology.data.Post
import ru.netology.data.Comment

class PostNotFoundException(message:String): RuntimeException(message)

object WallService {

    private var count = 0;
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun add(post: Post): Post {
        count ++
        posts += post.copy(id = count)
        return posts.last()
    }

    fun update(post: Post): Boolean {

        var founded = false

        for ((index, currentPost) in posts.withIndex()) {
            if (currentPost.id == post.id) {
                posts[index] = post
                founded = true
            }
        }

        return founded
    }

    fun createComment(postId: Int, comment: Comment): Comment? {

        var founded = false

        for ((index, currentPost) in posts.withIndex()) {
            if (currentPost.id == postId) {
                comments += comment
                founded = true
            }
        }

        if (!founded)
        {
            throw PostNotFoundException("Post not found");
        }

        return comment
    }

    fun clear() {
        posts = emptyArray()
        count = 0
    }
}