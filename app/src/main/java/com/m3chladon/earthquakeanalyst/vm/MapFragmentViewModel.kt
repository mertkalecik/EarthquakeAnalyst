package com.m3chladon.earthquakeanalyst.vm

import android.app.Application
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.m3chladon.earthquakeanalyst.base.BaseViewModel
import com.m3chladon.earthquakeanalyst.data.Event
import javax.inject.Inject

class MapFragmentViewModel @Inject constructor(application: Application): BaseViewModel(application) {

    val map = hashMapOf<Marker, Event>()
}