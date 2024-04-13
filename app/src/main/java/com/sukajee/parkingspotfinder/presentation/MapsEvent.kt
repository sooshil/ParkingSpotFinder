package com.sukajee.parkingspotfinder.presentation

import com.google.android.gms.maps.model.LatLng
import com.sukajee.parkingspotfinder.domain.model.ParkingSpot

sealed class MapsEvent {
    data class OnMapLongClick(val latLong: LatLng): MapsEvent()
    data class OnInfoWindowLongClick(val spot: ParkingSpot): MapsEvent()
    data object ToggleFalloutMap: MapsEvent()
}