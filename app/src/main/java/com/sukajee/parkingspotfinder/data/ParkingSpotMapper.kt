package com.sukajee.parkingspotfinder.data

import com.sukajee.parkingspotfinder.domain.model.ParkingSpot

fun ParkingSpotEntity.toParkingSpot() = ParkingSpot(
    id = id,
    latitude = latitude,
    longitude = longitude
)

fun ParkingSpot.toParkingSpotEntity() = ParkingSpotEntity(
    id = id,
    latitude = latitude,
    longitude = longitude
)