package com.base.mert.baseproject.di.provider

import com.m3chladon.earthquakeanalyst.di.module.HomeFragmentModule
import com.m3chladon.earthquakeanalyst.ui.fragment.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentProvider {

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun provideHomeFragment(): HomeFragment
}