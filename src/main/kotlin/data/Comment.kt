package ru.netology.data

import java.util.Date

data class Comment(
    val id: Int,
    val fromId: Int,
    val date: Date,
    val text: String,
    val donut: Donut? = null,
    val isDon: Boolean = false,
    val placeholder: String = "",
    val replyToUser: Int = 0
)
