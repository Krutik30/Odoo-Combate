package com.example.oohclient.advertiseractivities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.oohclient.R
import com.example.oohclient.databinding.FragmentAdvertiserAddAdsBinding
import com.example.oohclient.databinding.FragmentAdvertiserHomeBinding

class AdvertiserAddAdsFragment : Fragment() {

    private lateinit var binding: FragmentAdvertiserAddAdsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAdvertiserAddAdsBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
}