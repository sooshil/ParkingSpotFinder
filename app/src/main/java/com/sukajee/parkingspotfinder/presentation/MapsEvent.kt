package com.sukajee.parkingspotfinder.presentation

import com.google.android.gms.maps.model.LatLng

sealed class MapsEvent {
    data class OnMapLongClick(val latLong: LatLng): MapsEvent()
    object ToggleFalloutMap: MapsEvent()
}