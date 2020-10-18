package com.m3chladon.earthquakeanalyst.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(event: Event)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(event: Event)

    @Query("select * from event where id LIKE :eventId")
    fun getEvent(eventId: Int): Event

    @Delete
    fun delete(event: Event)

    @Query("DELETE FROM event")
    fun deleteAllEvents()

    @Query("SELECT * FROM event ORDER BY date DESC")
    fun gelAllEvents(): List<Event>
}