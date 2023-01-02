package com.zukkeyapp.androiduitips.ui.learn_timer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LearnTimerScreen(learnTimerViewModel: LearnTimerViewModel) {
    val uiState = learnTimerViewModel.uiState
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(text = "現在時刻", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = uiState.currentTime, fontSize = 36.sp)
    }
}