package com.sukajee.parkingspotfinder.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ParkingSpotEntity(
    val latitude: Double,
    val longitude: Double,
    @PrimaryKey val id: Int? = null
)
