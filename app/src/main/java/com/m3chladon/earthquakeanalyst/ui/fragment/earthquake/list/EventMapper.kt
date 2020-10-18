package com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.list

import com.m3chladon.earthquakeanalyst.R
import com.m3chladon.earthquakeanalyst.data.Event
import com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.data.EarthquakeViewEntity

fun List<Event>.toEventListEntity() = mutableListOf<EventListItem>().apply {
    this@toEventListEntity.forEach { event ->
        add(event.toEventListItem())
    }
}

fun Event.toEventListItem() = EventListItem(
    place = place,
    date = date,
    time = hour,
    mag = mag,
    felt = depth,
    latitude = latitude,
    longitute = longitude,
    iconRes = getDrawable(mag?.toDouble())
)

fun getDrawable(mag: Double?): Int? {
    mag?.let {
        return when(it) {
            in 0.0..3.0 -> R.drawable.low_risky_button
            in 3.1..5.5 -> R.drawable.risky_button
            else -> R.drawable.high_risky_button
        }
    }

    return null
}

fun MutableList<Event>.toEarthquakeViewEntity() =
    EarthquakeViewEntity(
        this
    )