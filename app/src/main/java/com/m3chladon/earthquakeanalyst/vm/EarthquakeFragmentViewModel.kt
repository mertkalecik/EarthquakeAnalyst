package com.m3chladon.earthquakeanalyst.vm

import android.app.Application
import android.util.EventLog
import com.base.mert.baseproject.core.base.BaseFragment
import com.m3chladon.earthquakeanalyst.base.BaseViewModel
import com.m3chladon.earthquakeanalyst.data.Event
import com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.list.EventListItem
import javax.inject.Inject

class EarthquakeFragmentViewModel @Inject constructor(application: Application): BaseViewModel(application) {

    val eventList = mutableListOf<EventListItem>()
}