package com.m3chladon.earthquakeanalyst.vm

import android.app.Application
import androidx.databinding.Bindable
import com.m3chladon.earthquakeanalyst.BR
import com.m3chladon.earthquakeanalyst.base.BaseViewModel
import com.m3chladon.earthquakeanalyst.data.Event
import javax.inject.Inject
import kotlin.properties.Delegates

class HomeFragmentViewModel @Inject constructor(
    application: Application
): BaseViewModel(application) {

    var eventList = mutableListOf<Event>()

    @Bindable
    var progEarth: Float = 0.0F
        set(value) {
            field = value
            notifyPropertyChanged(BR.progEarth)
        }
    @Bindable
    var resultText: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.resultText)
        }

    @Bindable
    var numEarthquake = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.numEarthquake)
        }

    @Bindable
    var numHazardous = "-"
        set(value) {
            field = value
            notifyPropertyChanged(BR.numHazardous)
        }

    @Bindable
    var numPerson = "-"
        set(value) {
            field = value
            notifyPropertyChanged(BR.numPerson)
        }

}