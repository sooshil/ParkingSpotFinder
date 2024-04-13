package com.sukajee.parkingspotfinder.presentation

import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType

data class MapState(
    val properties: MapProperties = MapProperties(
        isBuildingEnabled = true,
        isTrafficEnabled = true,
        isIndoorEnabled = true,
        //isMyLocationEnabled = true
    ),
    val isFalloutMapEnabled: Boolean = false
)
