package com.example.oohclient.rvadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.oohclient.databinding.AdvertiserBookedSpaceRvLayBinding
import com.example.oohclient.databinding.AdvertiserSpaceListingRvLayBinding
import com.example.oohclient.model.BookedSpaceDetailsModel
import com.example.oohclient.model.SpaceDetailsModel
import com.google.android.material.imageview.ShapeableImageView

class AdvertiserSpaceListingRVAdapter(private val context: Context?, private val spaceList : ArrayList<SpaceDetailsModel>) : RecyclerView.Adapter<AdvertiserSpaceListingRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewHolder(
            AdvertiserSpaceListingRvLayBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )

        return binding
    }

    override fun getItemCount(): Int {
        return spaceList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.spaceName.text = spaceList[position].spaceName
        holder.status.text = spaceList[position].status
        Glide.with(context!!).load(spaceList[position].spaceImg).into(holder.spaceImg)
    }

    class ViewHolder(advertiserSpaceListingRvLayBinding: AdvertiserSpaceListingRvLayBinding) :
        RecyclerView.ViewHolder(advertiserSpaceListingRvLayBinding.root) {
        val spaceName: TextView = advertiserSpaceListingRvLayBinding.spaceName
        val status: TextView = advertiserSpaceListingRvLayBinding.status
        val spaceImg: ShapeableImageView = advertiserSpaceListingRvLayBinding.spaceImg
    }
}
