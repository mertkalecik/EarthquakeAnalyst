package com.m3chladon.earthquakeanalyst.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Event")
@Parcelize
data class Event(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    val Id: Int,
    @ColumnInfo(name = "place")
    val Place: String?,
    @ColumnInfo(name = "date")
    val Date: String?,
    @ColumnInfo(name = "hour")
    val Hour: String?,
    @ColumnInfo(name = "mag")
    val Mag: String?,
    @ColumnInfo(name = "depth")
    val Depth: String?,
    @ColumnInfo(name = "latitude")
    val Latitude: String?,
    @ColumnInfo(name = "longitude")
    val Longitude: String?,
    @ColumnInfo(name = "hDepth")
    val HDepth: Int,
    @ColumnInfo(name = "hMag")
    val HMag: Int) : Parcelable