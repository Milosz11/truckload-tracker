package com.example.truckloadtracker.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.truckloadtracker.controller.TruckViewModel
import com.example.truckloadtracker.model.TruckUiState
import com.example.truckloadtracker.ui.theme.TruckloadTrackerTheme

@Composable
fun TruckloadApp(
    viewModel: TruckViewModel = viewModel()
) { }

@Preview
@Composable
fun TruckloadAppPreview() {
    TruckloadTrackerTheme {
        TruckloadApp()
    }
}
