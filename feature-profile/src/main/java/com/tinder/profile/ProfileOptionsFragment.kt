package com.tinder.profile

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tinder.navigation.Activities
import com.tinder.navigation.Navigation
import com.tinder.ui.core.TinderCircleImageView

class ProfileOptionsFragment: Fragment() {

    private lateinit var profileOptionsViewModel: ProfileOptionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile_options, container, false)
        val name = root.findViewById<TextView>(R.id.name)
        val image = root.findViewById<TinderCircleImageView>(R.id.image)
        profileOptionsViewModel = ViewModelProvider(this).get(ProfileOptionsViewModel::class.java)
        profileOptionsViewModel.profileOptionsComponent.observe(viewLifecycleOwner, { component ->
            name.text = component.name
            image.setImageResource(component.imageResourceId)
            image.setOnClickListener {
                val intent = Activities.intentForProfile(requireContext(), component.id)
                startActivity(intent)
            }
        })

        return root
    }
}