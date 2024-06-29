package com.example.oohclient.advertiseractivities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.oohclient.R
import com.example.oohclient.advertiseractivities.fragments.AdvertiserAddAdsFragment
import com.example.oohclient.advertiseractivities.fragments.AdvertiserAllAdsFragment
import com.example.oohclient.advertiseractivities.fragments.AdvertiserHomeFragment
import com.example.oohclient.advertiseractivities.fragments.AdvertiserSpaceListingFragment
import com.example.oohclient.commonactivities.UserInfoFragment
import com.example.oohclient.databinding.ActivityAdvertiserMainBinding

class AdvertiserMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdvertiserMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdvertiserMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(AdvertiserHomeFragment())

        binding.btmnav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    loadFragment(AdvertiserHomeFragment())
                    true
                }
                R.id.availableSpace -> {
                    loadFragment(AdvertiserSpaceListingFragment())
                    true
                }
                R.id.addAds -> {
                    loadFragment(AdvertiserAddAdsFragment())
                    true
                }
                R.id.allAds -> {
                    loadFragment(AdvertiserAllAdsFragment())
                    true
                }
                R.id.userProfile -> {
                    loadFragment(UserInfoFragment())
                    true
                }
                else -> {
                    loadFragment(AdvertiserHomeFragment())
                    true
                }
            }
        }

    }

    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }
}