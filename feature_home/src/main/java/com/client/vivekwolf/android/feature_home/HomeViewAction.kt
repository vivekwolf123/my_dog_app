package com.client.vivekwolf.android.feature_home

import androidx.compose.runtime.Immutable

@Immutable
sealed class HomeViewAction {
    data object GetDogInfo : HomeViewAction()
}
