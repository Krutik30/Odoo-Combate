package com.example.oohclient.rvadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.oohclient.databinding.AdvertiserBookedSpaceRvLayBinding
import com.example.oohclient.model.BookedSpaceDetailsModel
import com.google.android.material.imageview.ShapeableImageView

class AdvertiserBookedSpaceRVAdapter(private val context: Context?, private val bookedSpaceList : ArrayList<BookedSpaceDetailsModel>) : RecyclerView.Adapter<AdvertiserBookedSpaceRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewHolder(AdvertiserBookedSpaceRvLayBinding.inflate(LayoutInflater.from(context), parent, false))

        return binding
    }

    override fun getItemCount(): Int {
        return bookedSpaceList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.days.text = bookedSpaceList[position].days
        holder.spaceName.text = bookedSpaceList[position].spaceName
        holder.adName.text = bookedSpaceList[position].adName
        Glide.with(context!!).load(bookedSpaceList[position].adImg).into(holder.adImg)
    }

    class ViewHolder(advertiserBookedSpaceRvLayBinding: AdvertiserBookedSpaceRvLayBinding): RecyclerView.ViewHolder(advertiserBookedSpaceRvLayBinding.root) {
        val lay: ConstraintLayout = advertiserBookedSpaceRvLayBinding.lay
        val adImg : ShapeableImageView = advertiserBookedSpaceRvLayBinding.adImg
        val spaceName : TextView = advertiserBookedSpaceRvLayBinding.spaceName
        val adName : TextView = advertiserBookedSpaceRvLayBinding.adName
        val days : TextView = advertiserBookedSpaceRvLayBinding.days
    }
}