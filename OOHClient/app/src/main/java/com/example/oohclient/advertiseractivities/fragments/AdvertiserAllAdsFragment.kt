package com.example.oohclient.advertiseractivities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oohclient.R
import com.example.oohclient.databinding.FragmentAdvertiserAllAdsBinding
import com.example.oohclient.databinding.FragmentAdvertiserHomeBinding
import com.example.oohclient.model.AdDetailsModel
import com.example.oohclient.model.SpaceDetailsModel
import com.example.oohclient.rvadapter.AdvertiserAdsRVAdapter
import com.example.oohclient.rvadapter.AdvertiserSpaceListingRVAdapter

class AdvertiserAllAdsFragment : Fragment() {

    private lateinit var binding: FragmentAdvertiserAllAdsBinding
    private lateinit var adDetailsModel: AdDetailsModel
    private var list = arrayListOf<AdDetailsModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAdvertiserAllAdsBinding.inflate(layoutInflater, container, false)

        adDetailsModel = AdDetailsModel(
            adId = "ad Id",
            adName = "ad Name",
            startDate = "start Date",
            endDate = "end Date",
            status = "Placed",
            placedLocation = "there"
        )

        for (i in 1..10){
            list.add(adDetailsModel)
        }

        val spaceListingRVAdapter = AdvertiserAdsRVAdapter(context, list)
        binding.rv.adapter = spaceListingRVAdapter
        binding.rv.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

}