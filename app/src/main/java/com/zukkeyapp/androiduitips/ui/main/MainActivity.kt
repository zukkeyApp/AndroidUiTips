package com.zukkeyapp.androiduitips.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zukkeyapp.androiduitips.ui.ScreenType
import com.zukkeyapp.androiduitips.ui.learn_timer.LearnTimerScreen
import com.zukkeyapp.androiduitips.ui.learn_timer.LearnTimerViewModel
import com.zukkeyapp.androiduitips.ui.theme.AndroidUiTipsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    private val learnTimerViewModel by viewModels<LearnTimerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidUiTipsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = ScreenType.MAIN.routeName) {
                        composable(ScreenType.MAIN.routeName) {
                            MainScreen(viewModel, navController)
                        }
                        composable(ScreenType.LEAN_TIMER.routeName) {
                            LearnTimerScreen(learnTimerViewModel)
                        }
                    }
                }
            }
        }
    }
}