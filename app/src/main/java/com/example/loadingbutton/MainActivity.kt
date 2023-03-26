package com.example.loadingbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loadingbutton.ui.LoadingViewModel
import com.example.loadingbutton.ui.element.loadingButton.LoadingButton
import com.example.loadingbutton.ui.element.loadingButton.LoadingButtonUiState
import com.example.loadingbutton.ui.element.loadingButton.LoadingEvent
import com.example.loadingbutton.ui.theme.LoadingButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoadingButtonTheme {
                val viewmodel: LoadingViewModel by viewModels()
                val state by viewmodel.loadingState.observeAsState(LoadingButtonUiState.Waiting)

                Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    LoadingButton(
                        state = state,
                        onClick = { viewmodel.onEvent(LoadingEvent.OnLoadingClick) },
                        loadingFinishedListener =  { viewmodel.onEvent(LoadingEvent.OnLoadingAnimationFinished(it)) },
                        modifier = Modifier.size(100.dp, 40.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoadingButtonTheme {
        Greeting("Android")
    }
}