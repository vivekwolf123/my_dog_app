package com.client.vivekwolf.android.feature_tabs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.client.vivekwolf.android.feature_dog_activity.DogActivityScreen
import com.client.vivekwolf.android.feature_dog_facts.DogFactsScreen
import com.client.vivekwolf.android.feature_dog_info.DogInfoScreen
import com.client.vivekwolf.android.navigation.BottomNavigationTabRouter

@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavigationTabRouter.DogInfoScreen.route
    ) {
        composable(
            BottomNavigationTabRouter.DogInfoScreen.route
        ) {
            DogInfoScreen(navHostController)
        }
        composable(
            BottomNavigationTabRouter.DogActivityScreen.route
        ) {
            DogActivityScreen(navHostController)
        }
        composable(
            BottomNavigationTabRouter.DogFactsScreen.route
        ) {
            DogFactsScreen(navHostController)
        }
    }
}
