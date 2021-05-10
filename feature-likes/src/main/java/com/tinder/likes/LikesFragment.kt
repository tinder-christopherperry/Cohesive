package com.tinder.likes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class LikesFragment : Fragment() {

    private lateinit var likesViewModel: LikesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        likesViewModel =
                ViewModelProvider(this).get(LikesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_likes, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        likesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}