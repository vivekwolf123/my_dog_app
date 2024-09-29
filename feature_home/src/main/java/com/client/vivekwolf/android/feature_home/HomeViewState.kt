package com.client.vivekwolf.android.feature_home

import androidx.compose.runtime.Immutable
import com.client.vivekwolf.android.core_base.ErrorType
import com.client.vivekwolf.android.core_dog_domain.model.DogInfoModel

@Immutable
data class HomeViewState(
    val loading: Boolean = false,
    val dogInfoList: List<DogInfoModel> = emptyList(),
    val errorType: ErrorType? = null
)
