package com.tinder.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tinder.user.UserRepository

class ProfileViewModel(private val getProfileComponent: GetProfileComponent = GetProfileComponent()): ViewModel() {
    private val _profileComponent = MutableLiveData<ProfileComponent>()

    fun profileComponent(userId: Long): LiveData<ProfileComponent> {
        _profileComponent.value = getProfileComponent(userId)
        return _profileComponent
    }
}

data class ProfileComponent(
    val imageResourceUri: String,
    val name: String,
    val bio: String
)

class GetProfileComponent(private val userRepository: UserRepository = UserRepository()) {
    operator fun invoke(userId: Long): ProfileComponent {
        val user = userRepository.getUser(userId)!!
        return ProfileComponent(
            imageResourceUri = user.imageResourceUri,
            name = user.name,
            bio = user.bio
        )
    }
}