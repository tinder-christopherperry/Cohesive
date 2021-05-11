package com.tinder.profile

import androidx.annotation.DrawableRes
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
    @DrawableRes val imageResourceId: Int,
    val name: String
)

class GetProfileOptionsComponent(private val userRepository: UserRepository = UserRepository()) {
    operator fun invoke(): ProfileOptionsComponent {
        val user = userRepository.getLoggedInUser()
        return ProfileOptionsComponent(
            id = user.id,
            imageResourceId = user.imageResourceId,
            name = user.name
        )
    }
}