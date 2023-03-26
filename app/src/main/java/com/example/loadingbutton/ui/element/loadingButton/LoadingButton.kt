package com.example.loadingbutton.ui.element.loadingButton

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun LoadingButton(
    state: LoadingButtonUiState,
    onClick: () -> Unit,
    loadingFinishedListener: ((Float) -> Unit)?,
    modifier: Modifier = Modifier,
    colorLoading: Color = Color.Red,
    colorFinished: Color = Color(0xFF009900),
) {
    Box(
        modifier = modifier.clickable(
            onClick = onClick,
            enabled = state == LoadingButtonUiState.Waiting,
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        )
        when (state) {
            is LoadingButtonUiState.Loading -> {
                var progress by remember { mutableStateOf(0f) }
                val animatedProgress = animateFloatAsState(
                    targetValue = progress,
                    animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
                    finishedListener = loadingFinishedListener
                ).value

                ProgressIndicator(
                    progress = animatedProgress,
                    modifier = Modifier
                        .fillMaxSize(),
                    color = colorLoading,
                )

                LoadingContent(modifier = Modifier.fillMaxSize())

                LaunchedEffect(key1 = state, block = {
                    while (progress < state.progress) {
                        val addition = progress + state.progress / 10
                        progress = if (addition > 1f) {
                            1f
                        } else {
                            addition
                        }
                    }
                })
            }
            LoadingButtonUiState.Finished -> {
                var progress by remember { mutableStateOf(0f) }
                val animatedProgress = animateFloatAsState(
                    targetValue = progress,
                    animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
                ).value

                ProgressIndicator(
                    progress = animatedProgress,
                    modifier = Modifier
                        .fillMaxSize(),
                    color = colorFinished,
                    isLeftToRight = false,
                    backgroundColor = colorLoading,
                )

                Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
                    CheckMarker(
                        animatedProgress,
                        modifier = Modifier.fillMaxHeight().aspectRatio(1f),
                        color = Color.White,
                    )
                }

                LaunchedEffect(key1 = Unit, block = {
                    while (progress < 1f) {
                        val addition = progress + 1f / 10
                        progress = if (addition > 1f) {
                            1f
                        } else {
                            addition
                        }
                    }
                })

                LaunchedEffect(key1 = state, block = {
                    while (progress < 1f) {
                        val addition = progress + 1f / 10
                        progress = if (addition > 1f) {
                            1f
                        } else {
                            addition
                        }
                    }
                })
            }
            LoadingButtonUiState.Waiting -> {
                //WaitingContent()
            }
        }
    }
}

sealed class LoadingButtonUiState {
    class Loading(
        val progress: Float,
    ) : LoadingButtonUiState()

    object Waiting : LoadingButtonUiState()
    object Finished : LoadingButtonUiState()
}