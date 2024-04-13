package com.sukajee.parkingspotfinder.presentation

import com.google.maps.android.compose.MapProperties

data class MapState(
    val properties: MapProperties = MapProperties(),
    val isFalloutMapEnabled: Boolean = false
)
