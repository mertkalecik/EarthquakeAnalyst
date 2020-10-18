package com.m3chladon.earthquakeanalyst.data.repo

import android.util.Log
import com.m3chladon.earthquakeanalyst.data.Event
import com.m3chladon.earthquakeanalyst.data.EventDao
import com.m3chladon.earthquakeanalyst.utils.HttpNetworkUtil
import kotlinx.coroutines.*
import javax.inject.Inject

class EarthquakeDataRepository @Inject constructor(
    private val dao: EventDao
) : EventRepository {

    override fun insertEvent(event: Event): Job =
        GlobalScope.launch {
            dao.insert(event)
        }

    override suspend fun getAllEvents(): List<Event>? {
        return if (getAllEarthquakes().isNullOrEmpty()) {
            val list = fetchFromRemote()
            insertToDatabase(list)
            list
        } else {
            getAllEarthquakes()
        }
    }

    private suspend fun getAllEarthquakes(): List<Event> =
        GlobalScope.async {
            dao.gelAllEvents()
        }.await()

    private fun insertToDatabase(list: MutableList<Event>): Job =
        GlobalScope.launch {
            list.forEach { event ->
                dao.insert(event)
            }
        }

    private fun fetchFromRemote(): MutableList<Event> {
        val list = mutableListOf<Event>()
        HttpNetworkUtil.fetchEarthquakeData(
            success = {
                Log.i("mert", "success ${it.size}")
                list.addAll(it)
            },
            failure = {
                Log.i("mert", "fail with $it}")
            }
        )
        return list
    }
}