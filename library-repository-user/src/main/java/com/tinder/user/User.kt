package com.tinder.user

data class User(
    val id: Long,
    val name: String,
    val imageResourceUri: String,
    val bio: String
)