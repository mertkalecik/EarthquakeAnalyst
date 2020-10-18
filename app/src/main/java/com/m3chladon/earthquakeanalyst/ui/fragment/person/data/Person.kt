package com.m3chladon.earthquakeanalyst.ui.fragment.person.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "user")
@Parcelize
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String,
    val surname: String,
    val place: String,
    val relation: String,
    val gender: String
) : Parcelable