package com.sukajee.parkingspotfinder.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sukajee.parkingspotfinder.data.ParkingSpotDatabase
import com.sukajee.parkingspotfinder.data.ParkingSpotRepositoryImpl
import com.sukajee.parkingspotfinder.domain.repository.ParkingSpotRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideParkingSpotDatabase(application: Application): ParkingSpotDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = ParkingSpotDatabase::class.java,
            name = "parking_spots.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideParkingSpotRepository(db: ParkingSpotDatabase): ParkingSpotRepository {
        return ParkingSpotRepositoryImpl(db.parkingSpotDao)
    }
}

