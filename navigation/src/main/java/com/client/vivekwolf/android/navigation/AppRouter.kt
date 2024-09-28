package com.client.vivekwolf.android.navigation

sealed class AppRouter(val route: String) {
    data object HomeScreen : AppRouter("HomeScreen")
    data object TabsScreen : AppRouter("TabsScreen")
}
