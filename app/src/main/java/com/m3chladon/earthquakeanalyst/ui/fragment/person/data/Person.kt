package com.m3chladon.earthquakeanalyst.ui.fragment.person.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "User")
@Parcelize
data class Person(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    val Id: Int,
    @ColumnInfo(name = "name")
    val Name: String,
    @ColumnInfo(name = "surname")
    val Surname: String,
    @ColumnInfo(name = "place")
    val Place: String,
    @ColumnInfo(name = "relation")
    val Relation: String,
    @ColumnInfo(name = "gender")
    val Gender: String
) : Parcelable