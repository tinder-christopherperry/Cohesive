package com.tinder.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tinder.user.UserRepository

class ProfileOptionsViewModel(
    private val getProfileOptionsComponent: GetProfileOptionsComponent = GetProfileOptionsComponent()
) : ViewModel() {
    private val _profileOptionsComponent = MutableLiveData<ProfileOptionsComponent>().apply {
        value = getProfileOptionsComponent()
    }
    val profileOptionsComponent: LiveData<ProfileOptionsComponent> = _profileOptionsComponent
}

data class ProfileOptionsComponent(
    val id: Long,
    val imageResourceUri: String,
    val name: String
)

class GetProfileOptionsComponent(private val userRepository: UserRepository = UserRepository()) {
    operator fun invoke(): ProfileOptionsComponent {
        val user = userRepository.getLoggedInUser()
        return ProfileOptionsComponent(
            id = user.id,
            imageResourceUri = user.imageResourceUri,
            name = user.name
        )
    }
}