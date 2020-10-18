package com.base.mert.baseproject.di.provider

import com.m3chladon.earthquakeanalyst.di.module.PersonFragmentModule
import com.m3chladon.earthquakeanalyst.ui.fragment.person.PersonFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PersonFragmentProvider {

    @ContributesAndroidInjector(modules = [PersonFragmentModule::class])
    abstract fun providePersonFragment(): PersonFragment
}