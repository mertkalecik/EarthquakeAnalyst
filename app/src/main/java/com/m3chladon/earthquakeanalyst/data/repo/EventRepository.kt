package com.m3chladon.earthquakeanalyst.data.repo

import com.m3chladon.earthquakeanalyst.data.Event
import kotlinx.coroutines.Job

interface EventRepository {

    fun insertEvent(event: Event): Job?

    suspend fun getAllEvents(): List<Event>?
}