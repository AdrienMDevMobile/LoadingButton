package com.example.loadingbutton.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.loadingbutton.ui.element.loadingButton.LoadingButton
import com.example.loadingbutton.ui.element.loadingButton.LoadingButtonUiState
import com.example.loadingbutton.ui.element.loadingButton.LoadingEvent
import com.example.loadingbutton.ui.element.loadingButton.LoadingViewModel

@Composable
fun LoadingButtonPresentation(viewModel: LoadingViewModel){
    val state by viewModel.loadingState.observeAsState(LoadingButtonUiState.Waiting)

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        LoadingButton(
            state = state,
            onClick = { viewModel.onEvent(LoadingEvent.OnLoadingClick) },
            loadingFinishedListener =  { viewModel.onEvent(LoadingEvent.OnLoadingAnimationFinished(it)) },
            modifier = Modifier.size(100.dp, 40.dp)
        )
    }
}