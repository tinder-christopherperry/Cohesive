package com.tinder.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _cardTexts = MutableLiveData<List<String>>().apply {
        value = (0 until 20).map { it.toString() }
    }
    val cardTexts: LiveData<List<String>> = _cardTexts
}