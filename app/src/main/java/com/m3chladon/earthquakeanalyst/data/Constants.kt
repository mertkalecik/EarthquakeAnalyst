package com.m3chladon.earthquakeanalyst.data

import kotlinx.coroutines.Dispatchers

object Constants {
    //Dispatchers
    internal val UI = Dispatchers.Main
    internal val IO = Dispatchers.IO
    internal val DEFAULT = Dispatchers.Default

    //Base Zoom Parameters for Turkey
    internal val BASE_LATITUDE = 39.9255;
    internal val BASE_LONGITUDE = 32.8662;
    internal val BASE_ZOOM = 4F;
    internal val SINGLE_VIEW_ZOOM = 10F;

    internal val KEY_EVENT_DATA = "earthquake_event_bundle"
}