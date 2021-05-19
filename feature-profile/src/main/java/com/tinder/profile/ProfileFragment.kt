package com.tinder.profile

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class ProfileFragment: Fragment() {
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        val userId = arguments?.getLong("userId")!!

        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        profileViewModel.profileComponent(userId).observe(this) {
//            view.findViewById<ImageView>(R.id.image).setImageResource(it.imageResourceId)
            view.findViewById<ImageView>(R.id.image).setImageURI(Uri.parse(it.imageResourceUri))
            view.findViewById<TextView>(R.id.username).text = it.name
            view.findViewById<TextView>(R.id.about).text = it.bio
        }

        return view
    }
}