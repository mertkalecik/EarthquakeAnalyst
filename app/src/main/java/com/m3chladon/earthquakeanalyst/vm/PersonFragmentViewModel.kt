package com.m3chladon.earthquakeanalyst.vm

import android.app.Application
import com.m3chladon.earthquakeanalyst.base.BaseViewModel
import com.m3chladon.earthquakeanalyst.ui.fragment.person.data.Person
import javax.inject.Inject

class PersonFragmentViewModel @Inject constructor(application: Application): BaseViewModel(application) {

    val personList = mutableListOf<Person>()

    init {
        personList.apply {
            add(
                Person(
                1,
                "mert",
                "kalecik",
                "manisa",
                "kardeş",
                "male"
            )
            )
            add(Person(
                1,
                "osman",
                "kalecik",
                "manisa",
                "kardeş",
                "male"
            ))
            add(Person(
                1,
                "enes",
                "kalecik",
                "manisa",
                "kardeş",
                "male"
            ))
        }
    }
}