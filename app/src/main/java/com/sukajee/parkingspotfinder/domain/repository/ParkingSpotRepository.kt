package com.sukajee.parkingspotfinder.domain.repository

import com.sukajee.parkingspotfinder.domain.model.ParkingSpot
import kotlinx.coroutines.flow.Flow

interface ParkingSpotRepository {

    suspend fun insertParkingSpot(parkingSpot: ParkingSpot)

    suspend fun deleteParkingSpot(parkingSpot: ParkingSpot)

    fun getParkingSpots(): Flow<List<ParkingSpot>>
}