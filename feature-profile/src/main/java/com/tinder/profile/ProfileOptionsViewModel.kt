package com.tinder.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileOptionsViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is the signed in user's profile options page"
    }
    val text: LiveData<String> = _text
}