package com.example.oohclient.commonactivities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.oohclient.R
import com.example.oohclient.databinding.FragmentAdvertiserHomeBinding
import com.example.oohclient.databinding.FragmentUserInfoBinding
import com.example.oohclient.model.UserDetailsModel

class UserInfoFragment : Fragment() {

    private lateinit var binding: FragmentUserInfoBinding
    private lateinit var userDetailsModel: UserDetailsModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserInfoBinding.inflate(layoutInflater, container, false)

        userDetailsModel = UserDetailsModel(
            email = "user@gmail.com",
            name = "user name",
            id = "user id",
            companyAddress = "Ahmedabad",
            contactNo = "+919999999999",
            profileImg = "",
            companyName = "Odoo"
        )

        binding.userName.setText(userDetailsModel.name)
        binding.email.setText(userDetailsModel.email)
        binding.contactNo.setText(userDetailsModel.contactNo)
        binding.companyName.setText(userDetailsModel.companyName)
        binding.companyAddress.setText(userDetailsModel.companyAddress)


        return binding.root
    }


}