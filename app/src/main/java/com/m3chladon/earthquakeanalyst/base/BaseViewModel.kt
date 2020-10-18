package com.m3chladon.earthquakeanalyst.base

import android.app.Application
import androidx.databinding.BaseObservable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.util.*

abstract class BaseViewModel(application: Application): AndroidViewModel(application), LifecycleObserver, Observable {

    @Transient
    private var mCallbacks: PropertyChangeRegistry? = null

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        if(mCallbacks == null)
            mCallbacks = PropertyChangeRegistry()
        mCallbacks!!.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        if(mCallbacks == null)
            mCallbacks = PropertyChangeRegistry()

        mCallbacks!!.add(callback)
    }

    fun notifyChange() {
        synchronized(this) {
            if (mCallbacks == null)
                return
        }
        mCallbacks!!.notifyCallbacks(this, 0, null)
    }

    fun notifyPropertyChanged(fieldId: Int) {
        synchronized(this) {
            if (mCallbacks == null)
                return
        }
        mCallbacks!!.notifyCallbacks(this, fieldId, null)
    }
}