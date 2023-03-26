package com.example.loadingbutton.ui.element.loadingButton

sealed class LoadingEvent {
    object OnLoadingClick: LoadingEvent()
    class OnLoadingAnimationFinished(val value: Float): LoadingEvent()
}