package com.m3chladon.earthquakeanalyst.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.m3chladon.earthquakeanalyst.ui.fragment.person.data.Person

@Database(entities = [Event::class, Person::class], version = 3, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun eventDao(): EventDao
    abstract fun personDao(): PersonDao
}