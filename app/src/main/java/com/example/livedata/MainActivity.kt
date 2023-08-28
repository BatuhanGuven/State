package com.example.livedata

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.livedata.ui.theme.LiveDataTheme
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlin.math.log

class MainActivity : ComponentActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = MyViewModel()


        setContent { MainScreen(viewModel = viewModel) }
    }
}

@Composable
fun MainScreen(viewModel: MyViewModel) {
    val state = viewModel.state
    val isFirstTime = remember{ mutableStateOf(true)}
    LaunchedEffect(isFirstTime ){
        viewModel.showFlow(viewModel.createFlow())
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        state.value.forEach { item ->
            Text(text = "lajjjjjjjjjjjjjjjjjjfjjjjjjajsdjjfajsdfjaasdjfjjasfjmaısfkaaıföasfaksöfıksö")
        }
    }
}
