package com.m3chladon.earthquakeanalyst.di.provider

import com.m3chladon.earthquakeanalyst.di.module.EarthquakeFragmentModule
import com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.EarthquakeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class EarthquakeFragmentProvider {

    @ContributesAndroidInjector(modules = [EarthquakeFragmentModule::class])
    abstract fun providesEarthquakeFragment(): EarthquakeFragment
}