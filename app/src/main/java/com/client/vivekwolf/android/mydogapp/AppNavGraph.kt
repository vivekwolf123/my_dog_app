package com.client.vivekwolf.android.mydogapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.client.vivekwolf.android.navigation.BottomNavigationTabRouter

@Composable
fun AppNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavigationTabRouter.DogInfoScreen
    ) {

    }
}
