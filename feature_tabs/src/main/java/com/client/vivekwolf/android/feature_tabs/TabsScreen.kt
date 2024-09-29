package com.client.vivekwolf.android.feature_tabs

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.client.vivekwolf.android.navigation.BottomNavigationTabRouter

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TabsScreen(navHostController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            AppBottomNavigation(navHostController)
        }
    ) { paddingValues ->

    }
}

@Composable
private fun AppBottomNavigation(navHostController: NavHostController) {
    val items = listOf(
        BottomNavigationTabRouter.DogInfoScreen,
        BottomNavigationTabRouter.DogActivityScreen,
        BottomNavigationTabRouter.DogFactsScreen
    )
    val currentRoute = currentRoute(navHostController)
    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.title) },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    navHostController.navigate(screen.route) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
private fun currentRoute(navHostController: NavHostController): String? {
    return navHostController.currentBackStackEntryAsState().value?.destination?.route
}
