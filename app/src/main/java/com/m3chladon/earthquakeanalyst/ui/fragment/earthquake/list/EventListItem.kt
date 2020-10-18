package com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.list

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventListItem(
    val place: String?,
    val date: String?,
    val time: String?,
    val mag: String?,
    val felt: String?,
    val latitude: String?,
    val longitute: String?,
    @DrawableRes val iconRes: Int?,
    var seperator: Boolean = false
) : Parcelable