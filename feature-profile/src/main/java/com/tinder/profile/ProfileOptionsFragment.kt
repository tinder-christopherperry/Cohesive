package com.tinder.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class ProfileOptionsFragment: Fragment() {

    private lateinit var profileOptionsViewModel: ProfileOptionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile_options, container, false)
        val pageTitle = root.findViewById<TextView>(R.id.page_title)
        profileOptionsViewModel = ViewModelProvider(this).get(ProfileOptionsViewModel::class.java)
        profileOptionsViewModel.text.observe(viewLifecycleOwner, {
            pageTitle.text = it
        })
        return root
    }
}