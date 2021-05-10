package com.tinder.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

internal class LikesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the Likes Fragment"
    }
    val text: LiveData<String> = _text
}