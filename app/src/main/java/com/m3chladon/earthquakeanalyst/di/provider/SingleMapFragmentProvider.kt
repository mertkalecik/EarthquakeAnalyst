package com.m3chladon.earthquakeanalyst.di.provider

import com.m3chladon.earthquakeanalyst.di.module.SingleMapFragmentModule
import com.m3chladon.earthquakeanalyst.ui.fragment.singlemap.SingleMapFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SingleMapFragmentProvider {

    @ContributesAndroidInjector(modules = [SingleMapFragmentModule::class])
    abstract fun providePersonFragment(): SingleMapFragment
}