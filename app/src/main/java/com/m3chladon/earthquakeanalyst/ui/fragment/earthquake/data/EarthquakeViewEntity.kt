package com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.data

import android.os.Parcelable
import com.m3chladon.earthquakeanalyst.data.Event
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EarthquakeViewEntity(
    val mutableList: MutableList<Event>
) : Parcelable