package com.example.oohclient.advertiseractivities

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.oohclient.R
import com.example.oohclient.databinding.ActivityAdvertiserPerticularSpaceBinding
import com.example.oohclient.model.SpaceDetailsModel

class AdvertiserPerticularSpaceActivity : AppCompatActivity() {

    private lateinit var data : SpaceDetailsModel

    private lateinit var binding: ActivityAdvertiserPerticularSpaceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdvertiserPerticularSpaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spaceImg = intent.getStringExtra("spaceImg")
        val spaceName = intent.getStringExtra("spaceName")
        val price = intent.getStringExtra("price",)
        val dimensions = intent.getStringExtra("dimensions",)
        val status = intent.getStringExtra("status",)
        val location = intent.getStringExtra("location",)

        binding.spaceName.text = spaceName.toString()
        binding.price.text = price.toString()
        binding.dimensions.text = dimensions.toString()
        binding.status.text = status.toString()
        binding.location.text = location.toString()
        Glide.with(this).load(spaceImg).into(binding.spaceImg)

        if(status=="available"){
            binding.bookSpace.visibility = View.VISIBLE
        }

    }
}