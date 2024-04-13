package com.sukajee.parkingspotfinder.domain.model

data class ParkingSpot(
    val latitude: Double,
    val longitude: Double,
    val id: Int? = null
)