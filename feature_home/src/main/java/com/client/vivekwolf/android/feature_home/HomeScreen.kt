package com.client.vivekwolf.android.feature_home

import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.client.vivekwolf.android.navigation.AppRouter

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val viewState = viewModel.homeViewStateFlow.collectAsStateWithLifecycle().value
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is HomeViewEffect.OnDogInfoListFetched -> {
                    snackbarHostState.showSnackbar("Dog info list fetched successfully!")
                }
            }
        }
    }

    if (viewState.loading) {
        LinearProgressIndicator()
    }
    if (viewState.dogInfoList.isNotEmpty()) {

    } else {
        navHostController.navigate(AppRouter.TabsScreen.route)
    }
}
