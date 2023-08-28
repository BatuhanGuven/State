package com.example.livedata

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class MyViewModel:ViewModel() {
    val state = mutableStateOf<List<String>>(emptyList())
    fun createFlow(): Flow<String> {
        val myFlow = flow {
            for (i in 1..100) {
                emit(i.toString())
                delay(100)
            }
        }
        return myFlow
    }


    fun showFlow(flow: Flow<String>) {
        viewModelScope.launch {
            flow.collect { value ->
                state.value = state.value + listOf(value)
            }
        }
    }
}