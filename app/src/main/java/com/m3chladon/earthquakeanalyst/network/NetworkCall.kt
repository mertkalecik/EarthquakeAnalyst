package com.m3chladon.earthquakeanalyst.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.m3chladon.earthquakeanalyst.data.Constants.UI
import com.m3chladon.earthquakeanalyst.data.Event
import kotlinx.coroutines.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.net.MalformedURLException
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList
import kotlin.coroutines.CoroutineContext


open class NetworkCall<T> {

    private val KOERI_REQUEST_URL = "http://www.koeri.boun.edu.tr/scripts/lst0.asp"

    private val parentJob = Job()
    val liveData = MutableLiveData<ArrayList<T>>();

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    fun makeCall(): ArrayList<T>? {
        val response = makeCall2()

        val cleanData = extractFeatureFromString(response)

        val list = getEarthquakeData(cleanData)

        if (list.isNullOrEmpty())
            return null

        return getEarthquakeData(cleanData);
    }

    fun makeCall2(): String = runBlocking {
        call(createUrl(KOERI_REQUEST_URL).toString()).await()!!
    }

    suspend fun call(url: String): Deferred<String?> = scope.async {
        val document: Document? = Jsoup.connect(url).get()

        document?.let {
            val elements = it.select("pre")
            return@async elements.text()
        }
        //liveData.postValue(getEarthquakeData(cleanData))
    }

    private fun extractFeatureFromString(response: String): String {
        if (response.isEmpty())
            return ""

        return getCleanData(response)
    }

    fun getCleanData(data: String): String {
        val result =
            data.split("---------- --------  --------  -------   ----------    ------------    --------------                                  --------------")
        return result[1]
    }

    private fun getEarthquakeData(response: String): ArrayList<T> {
        val arrayList: ArrayList<T> = arrayListOf()
        val numEarthquakes = 250
        val minMag = 2.0
        val minDepth = 20.0

        val scanner = Scanner(response)
        scanner.nextLine()
        var i = 0
        var currentMag = 0.0
        var currentDepth = 0.0

        while (i < numEarthquakes) {
            val record = scanner.nextLine()
            val mag = record.substring(60, 63)
            currentMag = mag.toDouble()
            if (currentMag >= minMag) {
                val depth = record.substring(46, 49)
                currentDepth = depth.toDouble()
                if (currentDepth <= minDepth) {
                    val place = getPlace(record.substring(71, record.length))
                    val date = record.substring(0, 10)
                    val hour = record.substring(11, 19)
                    val latitude = record.substring(21, 28)
                    val longitude = record.substring(31, 38)

                    var hDepth = 0
                    var hMag = 0
                    if (depth.toDouble() <= 10.0) {
                        hDepth = 1
                    }
                    if (mag.toDouble() >= 3.7) {
                        hMag = 1
                    }

                    val event = Event(
                        i + 1,
                        place,
                        date,
                        hour,
                        mag,
                        depth,
                        latitude,
                        longitude,
                        hDepth,
                        hMag
                    ) as T
                    arrayList.add(event)
                    i++
                }
            }
            i++
        }
        scanner.close()
        return arrayList
    }

    private fun getPlace(place: String): String {
        var count = 0
        var lastIndex = 0
        for (i in 0..place.length) {
            if (count == 3) {
                lastIndex = i
                break
            } else if (place[i] == ' ') {
                count++
            }
        }

        var index = 0
        var result = place.substring(0, lastIndex)
        while (index < lastIndex) {
            if (place[index] == '(')
                result = place.substring(0, index - 1) + "\n" + place.substring(index, lastIndex)
            if (place[index] == '-')
                result =
                    place.substring(0, index - 1) + "\n" + place.substring(index + 1, lastIndex)

            index++
        }

        return result
    }

    private fun createUrl(stringUrl: String): URL? {
        var url: URL? = null
        try {
            url = URL(stringUrl)
        } catch (e: MalformedURLException) {
            Log.e("mert", "Error with creating URL ", e)
        }

        return url
    }
}