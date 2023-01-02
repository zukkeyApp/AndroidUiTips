package com.zukkeyapp.androiduitips.ui.learn_timer

data class LearnTimerUiState(
    val currentTime: String = "00:00:00",
    val limitSeconds: Int = 1080,
    val countTime: String = "00:03:00"
)
