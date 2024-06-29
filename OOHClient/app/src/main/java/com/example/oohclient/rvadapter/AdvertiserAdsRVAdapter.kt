package com.example.oohclient.rvadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.oohclient.databinding.AdvertiserAdsRvLayBinding
import com.example.oohclient.databinding.AdvertiserBookedSpaceRvLayBinding
import com.example.oohclient.model.AdDetailsModel
import com.example.oohclient.model.BookedSpaceDetailsModel
import com.google.android.material.imageview.ShapeableImageView

class AdvertiserAdsRVAdapter(private val context: Context?, private val adsList : ArrayList<AdDetailsModel>) : RecyclerView.Adapter<AdvertiserAdsRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewHolder(AdvertiserAdsRvLayBinding.inflate(LayoutInflater.from(context), parent, false))

        return binding
    }

    override fun getItemCount(): Int {
        return adsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.status.text = adsList[position].status
        holder.adName.text = adsList[position].adName
    }

    class ViewHolder(advertiserAdsRvLayBinding: AdvertiserAdsRvLayBinding): RecyclerView.ViewHolder(advertiserAdsRvLayBinding.root) {
        val adName : TextView = advertiserAdsRvLayBinding.adName
        val status : TextView = advertiserAdsRvLayBinding.status
    }
}
