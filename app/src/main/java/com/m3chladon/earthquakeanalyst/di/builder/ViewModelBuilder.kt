package com.m3chladon.earthquakeanalyst.di.builder


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.m3chladon.earthquakeanalyst.annotations.ViewModelKey
import com.base.mert.baseproject.di.factory.ViewModelFactory
import com.m3chladon.earthquakeanalyst.vm.*
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun provideLoginViewModel(loginViewModel: LoginViewModel): ViewModel

        @Binds
        @IntoMap
        @ViewModelKey(LoginIdPassViewModel::class)
        abstract fun provideLoginIdPassViewModel(loginIdPassViewModel: LoginIdPassViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun provideMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

        @Binds
        @IntoMap
        @ViewModelKey(HomeFragmentViewModel::class)
        abstract fun provideHomeFragmentViewModel(homeFragmentViewModel: HomeFragmentViewModel): ViewModel

        @Binds
        @IntoMap
        @ViewModelKey(MapFragmentViewModel::class)
        abstract fun provideMapFragmentViewModel(mapFragmentViewModel: MapFragmentViewModel): ViewModel

        @Binds
        @IntoMap
        @ViewModelKey(SingleMapFragmentViewModel::class)
        abstract fun provideSingleMapFragmentViewModel(singleMapFragmentViewModel: SingleMapFragmentViewModel): ViewModel

        @Binds
        @IntoMap
        @ViewModelKey(PersonFragmentViewModel::class)
        abstract fun providePersonFragmentViewModel(personFragmentViewModel: PersonFragmentViewModel): ViewModel

        @Binds
        @IntoMap
        @ViewModelKey(EarthquakeFragmentViewModel::class)
        abstract fun provideEarthquakeFragmentViewModel(earthquakeFragmentViewModel: EarthquakeFragmentViewModel): ViewModel

            @Binds
            @IntoMap
            @ViewModelKey(EventDetailsFragmentViewModel::class)
            abstract fun provideEventDetailViewModel(eventDetailsFragmentViewModel: EventDetailsFragmentViewModel): ViewModel
}