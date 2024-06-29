package com.example.oohclient.advertiseractivities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oohclient.databinding.FragmentAdvertiserSpaceListingBinding
import com.example.oohclient.model.SpaceDetailsModel
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
        

        val spaceListingRVAdapter = AdvertiserSpaceListingRVAdapter(context, getSpaceDetailsList())
        binding.rv.adapter = spaceListingRVAdapter
        binding.rv.layoutManager = LinearLayoutManager(context)


        return binding.root
    }

    fun getSpaceDetailsList(): ArrayList<SpaceDetailsModel> {
        return arrayListOf(
            SpaceDetailsModel(
                spaceId = "space1",
                spaceName = "Mumbai Ad Space",
                price = "₹13895",
                dimensions = "44x40",
                status = "available",
                location = "Mumbai, India",
                spaceImg = "https://picsum.photos/200"
            ),
            SpaceDetailsModel(
                spaceId = "space2",
                spaceName = "Delhi Ad Space",
                price = "₹15891",
                dimensions = "34x50",
                status = "booked",
                location = "Delhi, India",
                spaceImg = "https://picsum.photos/200"
            ),
            SpaceDetailsModel(
                spaceId = "space3",
                spaceName = "Bangalore Ad Space",
                price = "₹16846",
                dimensions = "31x38",
                status = "available",
                location = "Bangalore, India",
                spaceImg = "https://picsum.photos/200"
            ),
            SpaceDetailsModel(
                spaceId = "space4",
                spaceName = "Chennai Ad Space",
                price = "₹12245",
                dimensions = "41x45",
                status = "booked",
                location = "Chennai, India",
                spaceImg = "https://picsum.photos/200"
            ),
            SpaceDetailsModel(
                spaceId = "space5",
                spaceName = "Hyderabad Ad Space",
                price = "₹12874",
                dimensions = "39x53",
                status = "available",
                location = "Hyderabad, India",
                spaceImg = "https://picsum.photos/200"
            ),
            SpaceDetailsModel(
                spaceId = "space6",
                spaceName = "Kolkata Ad Space",
                price = "₹19293",
                dimensions = "46x45",
                status = "booked",
                location = "Kolkata, India",
                spaceImg = "https://picsum.photos/200"
            ),
            SpaceDetailsModel(
                spaceId = "space7",
                spaceName = "Pune Ad Space",
                price = "₹18332",
                dimensions = "63x47",
                status = "available",
                location = "Pune, India",
                spaceImg = "https://picsum.photos/200"
            ),
            SpaceDetailsModel(
                spaceId = "space8",
                spaceName = "Ahmedabad Ad Space",
                price = "₹15828",
                dimensions = "64x70",
                status = "booked",
                location = "Ahmedabad, India",
                spaceImg = "https://picsum.photos/200"
            ),
            SpaceDetailsModel(
                spaceId = "space9",
                spaceName = "Jaipur Ad Space",
                price = "₹14423",
                dimensions = "35x53",
                status = "available",
                location = "Jaipur, India",
                spaceImg = "https://picsum.photos/200"
            ),
            SpaceDetailsModel(
                spaceId = "space10",
                spaceName = "Goa Ad Space",
                price = "₹12633",
                dimensions = "38x36",
                status = "booked",
                location = "Goa, India",
                spaceImg = "https://picsum.photos/200"
            )
        )
    }
}