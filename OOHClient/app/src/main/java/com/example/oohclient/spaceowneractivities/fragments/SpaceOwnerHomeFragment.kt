package com.example.oohclient.spaceowneractivities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.oohclient.R
import com.example.oohclient.databinding.FragmentAdvertiserHomeBinding
import com.example.oohclient.databinding.FragmentSpaceOwnerHomeBinding

class SpaceOwnerHomeFragment : Fragment(){

    private lateinit var binding: FragmentSpaceOwnerHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSpaceOwnerHomeBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
}