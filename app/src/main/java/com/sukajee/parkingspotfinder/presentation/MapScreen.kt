package com.sukajee.parkingspotfinder.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    viewModel: MapsViewModel = viewModel()
) {
    val state by viewModel.mapState.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(
                        MapsEvent.ToggleFalloutMap
                    )
                }
            ) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }
        }
    ) { paddingValues ->
        GoogleMap(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            properties = state.properties,
            uiSettings = MapUiSettings(zoomControlsEnabled = true, compassEnabled = true),
            onMapLongClick = {
                viewModel.onEvent(
                    MapsEvent.OnMapLongClick(it)
                )
            }
        ) {
            state.parkingSpots.forEachIndexed { index, parkingSpot ->
                Marker(
                    state = MarkerState(
                        position = LatLng(
                            parkingSpot.latitude,
                            parkingSpot.longitude
                        )
                    ),
                    title = "Parking Spot (${index + 1})",
                    snippet = "Long click to delete",
                    onInfoWindowLongClick = {
                        viewModel.onEvent(
                            MapsEvent.OnInfoWindowLongClick(parkingSpot)
                        )
                    },
                    onClick = {
                        it.showInfoWindow()
                        true
                    },
                    icon = BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_GREEN
                    )
                )
            }
        }
    }
}