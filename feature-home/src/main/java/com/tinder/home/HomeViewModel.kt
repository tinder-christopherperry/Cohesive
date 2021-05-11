package com.tinder.home

import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

internal class HomeViewModel : ViewModel() {

    private val _cardComponents = MutableLiveData<List<CardComponent>>().apply {
        value = listOf(
            CardComponent(
                id = 1,
                imageResourceId = R.drawable.capnamerica,
                userName = "Steve"
            ),
            CardComponent(
                id = 2,
                imageResourceId = R.drawable.blackpanther,
                userName = "T'Challa"
            ),
            CardComponent(
                id = 3,
                imageResourceId = R.drawable.ironman,
                userName = "Tony"
            ),
            CardComponent(
                id = 4,
                imageResourceId = R.drawable.hulk,
                userName = "Bruce"
            ),
            CardComponent(
                id = 5,
                imageResourceId = R.drawable.thor,
                userName = "Thor"
            ),
            CardComponent(
                id = 6,
                imageResourceId = R.drawable.spidey,
                userName = "Peter"
            ),
            CardComponent(
                id = 7,
                imageResourceId = R.drawable.capnmarvel,
                userName = "Carol"
            )
        )
    }
    val cardComponents: LiveData<List<CardComponent>> = _cardComponents
}

internal data class CardComponent(
    val id: Int,
    @DrawableRes val imageResourceId: Int,
    val userName: String
)