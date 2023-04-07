package com.example.loadingbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.loadingbutton.ui.DoubleColorButtonPresentation
import com.example.loadingbutton.ui.LoadingButtonPresentation
import com.example.loadingbutton.ui.element.loadingButton.*
import com.example.loadingbutton.ui.theme.LoadingButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoadingButtonTheme {
                val viewmodel: LoadingViewModel by viewModels()

                Column() {
                    LoadingButtonPresentation(viewModel = viewmodel)

                    DoubleColorButtonPresentation()
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