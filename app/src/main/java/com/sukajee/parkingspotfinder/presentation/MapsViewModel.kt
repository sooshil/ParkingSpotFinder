package com.sukajee.parkingspotfinder.presentation

import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MapsViewModel : ViewModel() {

    private val _mapState = MutableStateFlow(MapState())
    val mapState = _mapState.asStateFlow()

    fun onEvent(event: MapsEvent) {
        when (event) {
            is MapsEvent.OnMapLongClick -> {

            }

            is MapsEvent.ToggleFalloutMap -> {
                _mapState.update { currentState ->
                    currentState.copy(
                        properties = MapProperties(
                            mapStyleOptions = if (currentState.isFalloutMapEnabled) null
                            else MapStyleOptions(MapStyle.style)
                        ),
                        isFalloutMapEnabled = currentState.isFalloutMapEnabled.not()
                    )
                }
            }
        }
    }
}