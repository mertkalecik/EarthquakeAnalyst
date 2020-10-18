package com.m3chladon.earthquakeanalyst.di.provider

import com.m3chladon.earthquakeanalyst.di.module.EventDetailsFragmentModule
import com.m3chladon.earthquakeanalyst.ui.fragment.eventdetails.EventDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class EventDetailsFragmentProvider {

    @ContributesAndroidInjector(modules = [EventDetailsFragmentModule::class])
    abstract fun provideHomeFragment(): EventDetailsFragment
}