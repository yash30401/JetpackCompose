package com.devyash.jetpackcompose.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CoroutineScopeCompose() {
    var counter = remember {
        mutableStateOf(0)
    }
    var scope = rememberCoroutineScope()

    var text = "Counter is running ${counter.value}"
    if (counter.value == 10) {
        text = "Counter Stoped"
    }

    Column() {
        Text(text = text)
        Button(onClick = {
            scope.launch {
                Log.d("CoroutineScopeCompose", "Started...")
                try {
                    for (i in 1..10) {
                        counter.value++
                        delay(1000)
                    }
                } catch (e: Exception) {
                    Log.d("CoroutineScopeCompose", "Exception:- ${e.message.toString()}")
                }
            }
        }) {
            Text(text = "Start")
        }
    }

    //Made Changes Some Changes In Testing 1
    //Another Changes
}