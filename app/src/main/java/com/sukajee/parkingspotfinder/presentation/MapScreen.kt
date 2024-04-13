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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings

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
        )
    }
}