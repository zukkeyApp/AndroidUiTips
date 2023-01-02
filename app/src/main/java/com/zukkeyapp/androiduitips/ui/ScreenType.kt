package com.zukkeyapp.androiduitips.ui

enum class ScreenType(val routeName: String) {
    MAIN("main"), LEAN_TIMER("learn_timer");
    companion object {
        fun getType(route: String) = values().firstOrNull { it.routeName == route } ?: MAIN
    }
}