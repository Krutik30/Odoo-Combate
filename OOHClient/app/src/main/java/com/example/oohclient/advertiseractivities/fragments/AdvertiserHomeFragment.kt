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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAdvertiserHomeBinding.inflate(layoutInflater, container, false)

        val bookedSpaceRVAdapter = AdvertiserBookedSpaceRVAdapter(context, getBookedSpaceDetailsList())
        binding.rv.adapter = bookedSpaceRVAdapter
        binding.rv.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    fun getBookedSpaceDetailsList(): ArrayList<BookedSpaceDetailsModel> {
        return arrayListOf(
            BookedSpaceDetailsModel(
                spaceId = "space1",
                spaceName = "Mumbai Ad Space",
                price = "₹13895",
                dimensions = "44x40",
                status = "booked",
                adId = "ad1",
                adName = "Summer Sale Campaign",
                startDate = "2024-06-01",
                endDate = "2024-06-30",
                days = "30",
                adImg = "https://picsum.photos/200"
            ),
            BookedSpaceDetailsModel(
                spaceId = "space2",
                spaceName = "Delhi Ad Space",
                price = "₹15891",
                dimensions = "34x50",
                status = "booked",
                adId = "ad2",
                adName = "New Product Launch",
                startDate = "2024-07-01",
                endDate = "2024-07-15",
                days = "15",
                adImg = "https://picsum.photos/200"
            ),
            BookedSpaceDetailsModel(
                spaceId = "space4",
                spaceName = "Chennai Ad Space",
                price = "₹12245",
                dimensions = "41x45",
                status = "booked",
                adId = "ad4",
                adName = "Back to School Offers",
                startDate = "2024-06-20",
                endDate = "2024-07-05",
                days = "15",
                adImg = "https://picsum.photos/200"
            ),
            BookedSpaceDetailsModel(
                spaceId = "space6",
                spaceName = "Kolkata Ad Space",
                price = "₹19293",
                dimensions = "46x45",
                status = "booked",
                adId = "ad6",
                adName = "Diwali Festive Offers",
                startDate = "2024-10-01",
                endDate = "2024-10-31",
                days = "30",
                adImg = "https://picsum.photos/200"
            ),
            BookedSpaceDetailsModel(
                spaceId = "space8",
                spaceName = "Ahmedabad Ad Space",
                price = "₹15828",
                dimensions = "64x70",
                status = "booked",
                adId = "ad8",
                adName = "Valentine's Special",
                startDate = "2025-02-01",
                endDate = "2025-02-14",
                days = "14",
                adImg = "https://picsum.photos/200"
            ),
            BookedSpaceDetailsModel(
                spaceId = "space10",
                spaceName = "Goa Ad Space",
                price = "₹12633",
                dimensions = "38x36",
                status = "booked",
                adId = "ad10",
                adName = "Goa Carnival Promo",
                startDate = "2025-02-20",
                endDate = "2025-03-05",
                days = "14",
                adImg = "https://picsum.photos/200"
            )
        )
    }

}