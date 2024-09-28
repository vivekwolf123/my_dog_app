package com.client.vivekwolf.android.mydogapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.client.vivekwolf.android.feature_home.HomeScreen
import com.client.vivekwolf.android.feature_tabs.TabsScreen
import com.client.vivekwolf.android.navigation.AppRouter

@Composable
fun AppNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = AppRouter.HomeScreen.route
    ) {
        composable(
            AppRouter.HomeScreen.route
        ) {
            HomeScreen(navHostController)
        }
        composable(
            AppRouter.TabsScreen.route
        ) {
            TabsScreen(navHostController)
        }
    }
}
