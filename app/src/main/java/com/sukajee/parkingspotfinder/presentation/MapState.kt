package com.sukajee.parkingspotfinder.presentation

import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.sukajee.parkingspotfinder.domain.model.ParkingSpot

data class MapState(
    val properties: MapProperties = MapProperties(
        isBuildingEnabled = true,
        isTrafficEnabled = true,
        isIndoorEnabled = true,
        //isMyLocationEnabled = true
    ),
    val parkingSpots: List<ParkingSpot> = emptyList(),
    val isFalloutMapEnabled: Boolean = false
)
