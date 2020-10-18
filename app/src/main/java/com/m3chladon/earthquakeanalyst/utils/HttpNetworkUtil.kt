package com.m3chladon.earthquakeanalyst.utils

import androidx.lifecycle.MutableLiveData
import com.m3chladon.earthquakeanalyst.R
import com.m3chladon.earthquakeanalyst.data.Event
import com.m3chladon.earthquakeanalyst.network.NetworkCall
import kotlin.collections.ArrayList

object HttpNetworkUtil {


    fun fetchEarthquakeData(
        success: (T: ArrayList<Event>) -> Unit,
        failure: (error: Int) -> Unit
    ) {
        val networkCall = NetworkCall<Event>()

        networkCall.makeCall()?.let {
            success.invoke(it)
        } ?: kotlin.run {
            failure.invoke(R.string.network_error)
        }
    }
}

