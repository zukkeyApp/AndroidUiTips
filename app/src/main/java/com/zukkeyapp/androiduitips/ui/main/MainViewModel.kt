package com.zukkeyapp.androiduitips.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    var uiState by mutableStateOf(MainUiState())

    init {
        makeUiData()
    }

    private fun makeUiData() {
        uiState = uiState.copy(cellDataList = listOf(
            MainUiState.MainCellData(id = 0, name = "Sample001"),
            MainUiState.MainCellData(id = 1, name = "Sample002"),
            MainUiState.MainCellData(id = 2, name = "Sample003")
        ))
    }
}