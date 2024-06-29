package com.example.oohclient.model

data class BookedSpaceDetailsModel(
    val spaceId: String?,
    val spaceName: String?,
    val price: String?,
    val dimensions: String,
    val status: String?,
    val adId: String?,
    val adName: String?,
    val startDate: String?,
    val endDate: String?,
    val days: String?
)
