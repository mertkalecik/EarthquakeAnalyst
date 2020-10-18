package com.m3chladon.earthquakeanalyst.di.module

import android.app.Application
import androidx.room.Room
import com.m3chladon.earthquakeanalyst.data.AppDatabase
import com.m3chladon.earthquakeanalyst.data.EventDao
import com.m3chladon.earthquakeanalyst.data.repo.EarthquakeDataRepository
import com.m3chladon.earthquakeanalyst.data.repo.EventRepository
import com.m3chladon.earthquakeanalyst.ui.application.EarthquakeApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(application: EarthquakeApplication): Application {
        return application
    }

    @Singleton
    @Provides
    fun providesRoomDatabase(application: EarthquakeApplication): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            "earthquake"
        ).build()
    }

    @Singleton
    @Provides
    fun providesEventDao(demoDatabase: AppDatabase): EventDao {
        return demoDatabase.eventDao()
    }

    @Singleton
    @Provides
    fun eventRepository(eventDao: EventDao): EventRepository =
        EarthquakeDataRepository(eventDao)
}