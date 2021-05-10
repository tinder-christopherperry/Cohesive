package com.tinder.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity: AppCompatActivity(R.layout.activity_profile) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.findFragmentById(R.id.fragment_profile)?.arguments = intent.extras
    }
}