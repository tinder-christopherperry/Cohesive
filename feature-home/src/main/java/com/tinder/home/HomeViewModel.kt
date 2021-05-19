package com.tinder.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tinder.user.UserRepository

internal class HomeViewModel(private val getCardComponents: GetCardComponents = GetCardComponents()) : ViewModel() {

    private val _cardComponents = MutableLiveData<List<CardComponent>>().apply {
        value = getCardComponents()
    }

    val cardComponents: LiveData<List<CardComponent>> = _cardComponents
}

internal data class CardComponent(
    val id: Long,
    val imageResourceUri: String,
    val userName: String,
    val bio: String
)

internal class GetCardComponents(private val userRepository: UserRepository = UserRepository()) {
    operator fun invoke(): List<CardComponent> {
        return userRepository.getUsers().map {
            CardComponent(
                id = it.id,
                userName = it.name,
                imageResourceUri = it.imageResourceUri,
                bio = it.bio
            )
        }
    }
}