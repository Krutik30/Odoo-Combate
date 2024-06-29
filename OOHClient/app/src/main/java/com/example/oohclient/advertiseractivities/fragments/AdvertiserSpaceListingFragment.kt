package com.example.oohclient.advertiseractivities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oohclient.R
import com.example.oohclient.databinding.FragmentAdvertiserHomeBinding
import com.example.oohclient.databinding.FragmentAdvertiserSpaceListingBinding
import com.example.oohclient.model.BookedSpaceDetailsModel
import com.example.oohclient.model.SpaceDetailsModel
import com.example.oohclient.rvadapter.AdvertiserBookedSpaceRVAdapter
import com.example.oohclient.rvadapter.AdvertiserSpaceListingRVAdapter

class AdvertiserSpaceListingFragment : Fragment() {

    private lateinit var binding: FragmentAdvertiserSpaceListingBinding
    private lateinit var spaceDetailsModel: SpaceDetailsModel
    private var list = arrayListOf<SpaceDetailsModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAdvertiserSpaceListingBinding.inflate(layoutInflater, container, false)

        spaceDetailsModel = SpaceDetailsModel(
            spaceName = "space 1",
            spaceId = "space id",
            price = "1000",
            dimensions = "15 x 15",
            status = "Booked",
            location = "Location"
        )
        for (i in 1..10){
            list.add(spaceDetailsModel)
        }

        val spaceListingRVAdapter = AdvertiserSpaceListingRVAdapter(context, list)
        binding.rv.adapter = spaceListingRVAdapter
        binding.rv.layoutManager = LinearLayoutManager(context)


        return binding.root
    }
}