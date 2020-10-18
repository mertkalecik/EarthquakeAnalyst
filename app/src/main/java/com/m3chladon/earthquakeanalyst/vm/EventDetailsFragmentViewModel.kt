package com.m3chladon.earthquakeanalyst.vm

import android.app.Application
import com.m3chladon.earthquakeanalyst.R
import com.m3chladon.earthquakeanalyst.base.BaseViewModel
import com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.list.EventListItem
import com.m3chladon.earthquakeanalyst.ui.fragment.eventdetails.list.EventHeaderItem
import com.m3chladon.earthquakeanalyst.ui.fragment.eventdetails.list.EventItem
import com.m3chladon.earthquakeanalyst.ui.fragment.eventdetails.list.IEventDetails
import javax.inject.Inject

class EventDetailsFragmentViewModel @Inject constructor(
    application: Application
) : BaseViewModel(application) {

    val dataList = mutableListOf<IEventDetails>()
    lateinit var eventItem : EventListItem

    private fun getApp() = getApplication<Application>()

    /**
     * Bind Data
     */
    fun bindData(data: EventListItem) {
        dataList.clear()
        eventItem = data
        dataList.addAll(generateData(data))
    }

    /**
     * GeneratesAdapterData
     */
    private fun generateData(data: EventListItem) =
        mutableListOf<IEventDetails>().apply {
            add(
                EventHeaderItem(
                    headerText = getApp().getString(R.string.mag)
                )
            )
            add(
                EventItem(
                    text = "${data.mag} M"
                )
            )
            add(
                EventHeaderItem(
                    headerText = getApp().getString(R.string.lbl_depth)
                )
            )
            add(
                EventItem(
                    text = "${data.felt} km"
                )
            )
            add(
                EventHeaderItem(
                    headerText = getApp().getString(R.string.date)
                )
            )
            add(
                EventItem(
                    text = data.date
                )
            )
            add(
                EventHeaderItem(
                    headerText = getApp().getString(R.string.hour)
                )
            )
            add(
                EventItem(
                    text = data.time
                )
            )
            add(
                EventHeaderItem(
                    headerText = getApp().getString(R.string.latitude)
                )
            )
            add(
                EventItem(
                    text = "${data.latitude} °"
                )
            )
            add(
                EventHeaderItem(
                    headerText = getApp().getString(R.string.longitude)
                )
            )
            add(
                EventItem(
                    text = "${data.longitute} °"
                )
            )

        }
}