package com.example.loadingbutton.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loadingbutton.ui.element.loadingButton.LoadingButtonUiState
import com.example.loadingbutton.ui.element.loadingButton.LoadingEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingViewModel : ViewModel() {
    private val _loadingState = MutableLiveData<LoadingButtonUiState>(LoadingButtonUiState.Waiting)
    val loadingState: LiveData<LoadingButtonUiState>
        get() = _loadingState

    fun onEvent(event: LoadingEvent) {
        when (event) {
            LoadingEvent.OnLoadingClick -> onLoadingClick()
            is LoadingEvent.OnLoadingAnimationFinished -> onLoadingAnimationFinished(event.value)
        }
    }

    private fun onLoadingClick() {
        viewModelScope.launch {
            _loadingState.value = LoadingButtonUiState.Loading(0.5f)
            delay(1000)
            _loadingState.value = LoadingButtonUiState.Loading(0.7f)
            Log.d("loading", "0.7f")
            delay(1000)
            _loadingState.value = LoadingButtonUiState.Loading(1f)
            Log.d("loading", "1f")
        }
    }

    private fun onLoadingAnimationFinished(value: Float) {
        if (value == 1f) {
            _loadingState.value = LoadingButtonUiState.Finished
        }
    }
}