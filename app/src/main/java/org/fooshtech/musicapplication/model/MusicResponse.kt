package org.fooshtech.musicapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MusicResponse(
    val resultCount: Int,
    val results: List<ResultLItem>
) : Parcelable

@Parcelize
data class ResultLItem(
    val collectionName: String,
    val artistName: String,
    val artworkUrl100: String,
    val previewUrl : String,
    val trackPrice: Double
) : Parcelable