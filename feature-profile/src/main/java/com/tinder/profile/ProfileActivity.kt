package com.tinder.profile

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity(R.layout.activity_profile) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ViewGroup>(R.id.root)

        val profileFragment = ProfileFragment()
        profileFragment.arguments = intent.extras

        supportFragmentManager.beginTransaction().add(
            R.id.root,
            profileFragment
        ).commit()
    }
}