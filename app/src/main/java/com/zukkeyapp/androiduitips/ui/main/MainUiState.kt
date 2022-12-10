package com.zukkeyapp.androiduitips.ui.main

data class MainUiState(
    val cellDataList: List<MainCellData> = listOf()
) {
    data class MainCellData(
        val id: Int,
        val name: String
    )
}
