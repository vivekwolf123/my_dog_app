package com.client.vivekwolf.android.feature_home

import androidx.lifecycle.viewModelScope
import com.client.vivekwolf.android.core_base.DataResult
import com.client.vivekwolf.android.core_base.ErrorType
import com.client.vivekwolf.android.core_dog_domain.usecase.GetDogInfoUseCase
import com.client.vivekwolf.android.feature_base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDogInfoUseCase: GetDogInfoUseCase
) : BaseViewModel<HomeViewState, HomeViewEffect>(HomeViewState()) {

    @OptIn(ExperimentalCoroutinesApi::class)
    val homeViewStateFlow: StateFlow<HomeViewState> = _viewState
        .flatMapLatest {
            getDogInfoUseCase.invoke()
                .map { result ->
                    when (result) {
                        is DataResult.Success -> {
                            sendEffect(HomeViewEffect.OnDogInfoListFetched)
                            _viewState.value.copy(dogInfoList = result.data, loading = false)
                        }

                        is DataResult.Error -> {
                            _viewState.value.copy(loading = false, errorType = result.error)
                        }
                    }
                }
                .onStart {
                    _viewState.value = _viewState.value.copy(loading = true)
                }
                .catch { _ ->
                    _viewState.value = _viewState.value.copy(
                        loading = false,
                        errorType = ErrorType.UNKNOWN_ERROR
                    )
                }
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, _viewState.value)
}
