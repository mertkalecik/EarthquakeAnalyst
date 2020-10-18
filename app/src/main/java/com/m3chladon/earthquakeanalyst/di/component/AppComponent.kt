package com.base.mert.baseproject.di.component

import com.m3chladon.earthquakeanalyst.di.builder.ActivityBuilder
import com.m3chladon.earthquakeanalyst.di.builder.ViewModelBuilder
import com.m3chladon.earthquakeanalyst.di.module.AppModule
import com.m3chladon.earthquakeanalyst.ui.application.EarthquakeApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ViewModelBuilder::class,
        ActivityBuilder::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: EarthquakeApplication): Builder

        fun build(): AppComponent
    }

    fun inject(baseProjectApplication: EarthquakeApplication)

}