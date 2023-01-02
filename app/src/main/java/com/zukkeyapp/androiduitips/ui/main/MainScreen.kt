package com.zukkeyapp.androiduitips.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.zukkeyapp.androiduitips.ui.ScreenType

@Composable
fun MainScreen(viewModel: MainViewModel, navController: NavController) {
    val list = viewModel.uiState.cellDataList
    MainContentsComposable(list = list, onCellClick = {
        when(it) {
            0 -> {
                navController.navigate(ScreenType.LEAN_TIMER.routeName)
            }
            else -> {
                // Do Nothing
            }
        }
    })
}

@Composable
private fun MainContentsComposable(list: List<MainUiState.MainCellData>, onCellClick: (number: Int) -> Unit) {
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
                MainCellComposable(number = it.id, title = it.name, onCellClick = onCellClick)
            }
        }
    }
}

@Preview(name = "スクリーン画面の一覧", showBackground = true)
@Composable
private fun MainScreenComposablePreview() {
    MainContentsComposable(list = createMainCellDataList()) {
        // Do Nothing
    }
}

private fun createMainCellDataList(): List<MainUiState.MainCellData> {
    return (0..10).map {
        MainUiState.MainCellData(
            id = it,
            name = "Sample$it"
        )
    }
}