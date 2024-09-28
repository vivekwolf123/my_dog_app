package com.client.vivekwolf.android.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationTabRouter(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    data object DogInfoScreen :
        BottomNavigationTabRouter("Info", Icons.Filled.AccountCircle, "DogInfoScreen")

    data object DogActivityScreen :
        BottomNavigationTabRouter("Activity", Icons.Filled.Create, "DogActivityScreen")

    data object DogFactsScreen :
        BottomNavigationTabRouter("Facts", Icons.Filled.Info, "DogFactsScreen")
}
