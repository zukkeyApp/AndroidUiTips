package com.zukkeyapp.androiduitips.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val list = viewModel.uiState.cellDataList
    MainContentsComposable(list = list)
}

@Composable
private fun MainContentsComposable(list: List<MainUiState.MainCellData>) {
    if (list.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            list.map {
                MainCellComposable(number = it.id, title = it.name)
            }
        }
    }
}

@Preview(name = "スクリーン画面の一覧", showBackground = true)
@Composable
private fun MainScreenComposablePreview() {
    MainContentsComposable(list = createMainCellDataList())
}

private fun createMainCellDataList(): List<MainUiState.MainCellData> {
    return (0..10).map {
        MainUiState.MainCellData(
            id = it,
            name = "Sample$it"
        )
    }
}