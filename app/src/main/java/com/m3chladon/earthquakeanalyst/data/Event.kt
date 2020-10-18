package com.m3chladon.earthquakeanalyst.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "event")
@Parcelize
data class Event(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val place: String?,
    val date: String?,
    val hour: String?,
    val mag: String?,
    val depth: String?,
    val latitude: String?,
    val longitude: String?,
    val hDepth: Int,
    val hMag: Int) : Parcelable