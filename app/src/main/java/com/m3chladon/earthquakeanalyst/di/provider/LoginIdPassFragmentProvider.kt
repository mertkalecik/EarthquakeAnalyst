package com.base.mert.baseproject.di.provider

import com.m3chladon.earthquakeanalyst.di.module.LoginIdPassFragmentModule
import com.m3chladon.earthquakeanalyst.ui.fragment.LoginIdPassFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginIdPassFragmentProvider {

    @ContributesAndroidInjector(modules = [LoginIdPassFragmentModule::class])
    abstract fun provideLoginIdPassFragment(): LoginIdPassFragment
}