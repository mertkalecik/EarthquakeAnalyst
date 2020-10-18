package com.base.mert.baseproject.di.provider

import com.m3chladon.earthquakeanalyst.di.module.MapFragmentModule
import com.m3chladon.earthquakeanalyst.ui.fragment.MapFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MapFragmentProvider {

    @ContributesAndroidInjector(modules = [MapFragmentModule::class])
    abstract fun provideMapFragment(): MapFragment
}