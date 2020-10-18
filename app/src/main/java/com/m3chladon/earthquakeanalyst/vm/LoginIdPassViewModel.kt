package com.m3chladon.earthquakeanalyst.vm

import android.app.Application
import com.m3chladon.earthquakeanalyst.base.BaseViewModel
import com.m3chladon.earthquakeanalyst.custom.ActionLiveData
import javax.inject.Inject

class LoginIdPassViewModel @Inject constructor(application: Application): BaseViewModel(application) {

    val clickItemActionLiveData = ActionLiveData<String>()

    fun onButtonClicked() {
        clickItemActionLiveData.sendAction("Run Bitch :)")
    }
}