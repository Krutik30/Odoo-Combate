package com.example.oohclient.advertiseractivities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oohclient.R
import com.example.oohclient.databinding.AdvertiserBookedSpaceRvLayBinding
import com.example.oohclient.databinding.FragmentAdvertiserHomeBinding
import com.example.oohclient.model.AdDetailsModel
import com.example.oohclient.model.BookedSpaceDetailsModel
import com.example.oohclient.model.SpaceDetailsModel
import com.example.oohclient.rvadapter.AdvertiserBookedSpaceRVAdapter

class AdvertiserHomeFragment : Fragment() {

    private lateinit var binding: FragmentAdvertiserHomeBinding
    private lateinit var bookedSpaceDetailsModel: BookedSpaceDetailsModel
    private var list = arrayListOf<BookedSpaceDetailsModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAdvertiserHomeBinding.inflate(layoutInflater, container, false)

        bookedSpaceDetailsModel = BookedSpaceDetailsModel(
            spaceName = "space 1",
            spaceId = "space id",
            price = "1000",
            adId = "add id",
            startDate = "start date",
            endDate = "end date",
            dimensions = "15 x 15",
            status = "Booked",
            days = "70",
            adName = "Ad Name"
        )
        for (i in 1..10){
            list.add(bookedSpaceDetailsModel)
        }

        val bookedSpaceRVAdapter = AdvertiserBookedSpaceRVAdapter(context, list)
        binding.rv.adapter = bookedSpaceRVAdapter
        binding.rv.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

}