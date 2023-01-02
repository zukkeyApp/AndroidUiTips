package com.zukkeyapp.androiduitips.ui.learn_timer

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@SuppressLint("SimpleDateFormat")
@HiltViewModel
class LearnTimerViewModel @Inject constructor(): ViewModel() {
    var uiState by mutableStateOf(LearnTimerUiState())
    private var currentTimerJob: Job? = null
    private var countTimerJob: Job? = null
    init {
        makeUiData()
    }
    private fun makeUiData() {
        currentTimerJob = interval().onEach {
            uiState = uiState.copy(currentTime = SimpleDateFormat("HH:mm:ss").format(Date()))
        }.launchIn(viewModelScope).apply { start() }
    }

    fun startTime() {
        countTimerJob = interval().onEach {
            uiState = uiState.copy(currentTime = SimpleDateFormat("HH:mm:ss").format(Date()))
        }.launchIn(viewModelScope).apply { start() }
    }

    fun stopTimer() {
        countTimerJob?.cancel()
        countTimerJob = null
    }

    private fun interval() = flow {
        var counter: Long = 0
        while (true) {
            delay(1.seconds.inWholeMilliseconds)
            emit(counter++)
        }
    }

    override fun onCleared() {
        super.onCleared()
        currentTimerJob?.cancel()
        currentTimerJob = null
    }
}