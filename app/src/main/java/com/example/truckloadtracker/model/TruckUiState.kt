package com.example.truckloadtracker.model

data class TruckUiState(
    // List of active, to complete, loads
    val activeTruckLoadList: MutableList<TruckLoad> = mutableListOf(),
    // List of already completed loads in archive
    val archivedTruckLoadList: MutableList<TruckLoad> = mutableListOf()
)
