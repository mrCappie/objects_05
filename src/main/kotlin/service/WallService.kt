package ru.netology.service

import ru.netology.data.Post

object WallService {

    private var count = 0;
    private var posts = emptyArray<Post>()

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

    fun clear() {
        posts = emptyArray()
        count = 0
    }
}