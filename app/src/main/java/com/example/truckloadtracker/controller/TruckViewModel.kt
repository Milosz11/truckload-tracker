package com.example.truckloadtracker.controller

import androidx.lifecycle.ViewModel
import com.example.truckloadtracker.data.DataSource
import com.example.truckloadtracker.model.TruckLoad
import com.example.truckloadtracker.model.TruckUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TruckViewModel: ViewModel() {
    private val _uiState: MutableStateFlow<TruckUiState> = MutableStateFlow(
        TruckUiState(
            activeTruckLoadList = DataSource.truckLoadList.toMutableList(),
            archivedTruckLoad = DataSource.truckLoadList.toMutableList()
        )
    )
    val uiState: StateFlow<TruckUiState> = _uiState.asStateFlow()

    fun addTruckLoad(truckLoad: TruckLoad) {
        /* TODO */
    }

    fun removeTruckLoad(truckLoad: TruckLoad) {
        /* TODO */
    }
}
