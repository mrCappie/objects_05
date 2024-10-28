package ru.netology.data

data class Post(
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val friendsOnly: Boolean = false,
    val likes: Likes,
    val comments: Comments,
    val postType: String = "post",
    val canPin: Boolean = true,
    val repost: Post? = null,
    val donut: Donut? = null
)
