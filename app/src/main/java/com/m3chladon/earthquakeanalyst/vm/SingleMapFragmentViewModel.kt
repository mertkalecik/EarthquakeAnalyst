package com.m3chladon.earthquakeanalyst.vm

import android.app.Application
import com.m3chladon.earthquakeanalyst.base.BaseViewModel
import com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.list.EventListItem
import javax.inject.Inject

class SingleMapFragmentViewModel @Inject constructor(application: Application): BaseViewModel(application) {

    var eventListItem: EventListItem? = null
}