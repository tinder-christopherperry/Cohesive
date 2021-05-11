package com.tinder.user

import androidx.annotation.DrawableRes

data class User(
    val id: Long,
    val name: String,
    @DrawableRes val imageResourceId: Int,
    val bio: String
)