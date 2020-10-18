package com.m3chladon.earthquakeanalyst.di.builder

import com.base.mert.baseproject.di.provider.HomeFragmentProvider
import com.base.mert.baseproject.di.provider.LoginIdPassFragmentProvider
import com.base.mert.baseproject.di.provider.MapFragmentProvider
import com.base.mert.baseproject.di.provider.PersonFragmentProvider
import com.m3chladon.earthquakeanalyst.di.provider.EarthquakeFragmentProvider
import com.m3chladon.earthquakeanalyst.di.provider.EventDetailsFragmentProvider
import com.m3chladon.earthquakeanalyst.di.provider.SingleMapFragmentProvider
import com.m3chladon.earthquakeanalyst.ui.activity.LoginActivity
import com.m3chladon.earthquakeanalyst.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            LoginIdPassFragmentProvider::class
        ]
    )
    abstract fun provideLoginActivity(): LoginActivity

    @ContributesAndroidInjector(
        modules = [
            HomeFragmentProvider::class,
            MapFragmentProvider::class,
            SingleMapFragmentProvider::class,
            EarthquakeFragmentProvider::class,
            EventDetailsFragmentProvider::class,
            PersonFragmentProvider::class
        ]
    )
    abstract fun provideMainActivity(): MainActivity
}