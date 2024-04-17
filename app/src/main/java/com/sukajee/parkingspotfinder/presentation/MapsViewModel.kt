package com.sukajee.parkingspotfinder.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import com.sukajee.parkingspotfinder.domain.model.ParkingSpot
import com.sukajee.parkingspotfinder.domain.repository.ParkingSpotRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val repository: ParkingSpotRepository
) : ViewModel() {

    private val _mapState = MutableStateFlow(MapState())
    val mapState = _mapState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getParkingSpots().collectLatest { parkingSpots ->
                _mapState.update { currentState ->
                    currentState.copy(
                        parkingSpots = parkingSpots
                    )
                }
            }
        }
    }

    fun onEvent(event: MapsEvent) {
        when (event) {
            is MapsEvent.OnMapLongClick -> {
                viewModelScope.launch {
                    repository.insertParkingSpot(
                        ParkingSpot(event.latLong.latitude, event.latLong.longitude)
                    )
                }
            }

            is MapsEvent.ToggleFalloutMap -> {
                _mapState.update { currentState ->
                    currentState.copy(
                        properties = MapProperties(
                            mapStyleOptions = if (currentState.isFalloutMapEnabled) null
                            else MapStyleOptions(MapStyle.STYLE)
                        ),
                        isFalloutMapEnabled = currentState.isFalloutMapEnabled.not()
                    )
                }
            }

            is MapsEvent.OnInfoWindowLongClick -> {
                viewModelScope.launch {
                    repository.deleteParkingSpot(event.spot)
                }
            }
        }
    }
}