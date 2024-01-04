package com.devyash.jetpackcompose.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devyash.jetpackcompose.ui.theme.JetpackComposeTheme

class LoginActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Scaffold {
                    LoginScreen(welcomeMessage = "Hi, Welcome Here")
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginScreen(welcomeMessage: String) {
        var username by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }

        // Use SideEffect to show the toast message
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = welcomeMessage, fontSize = 50.sp, modifier = Modifier.width(210.dp),
                fontFamily = FontFamily.Cursive
            )
            OutlinedTextField(value = username, onValueChange = {
                username = it
            }, label = { Text(text = "Username") },
                placeholder = {
                    Text(text = "Username")
                },
                leadingIcon = {
                    Icon(Icons.Filled.Person, contentDescription = "")
                }, modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = password, onValueChange = {
                password = it
            }, label = { Text(text = "Password") },
                leadingIcon = {
                    Icon(Icons.Filled.Lock, contentDescription = "")
                }, placeholder = {
                    Text(text = "Password")
                }, modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                username = ""
                password = ""
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Login")
            }
        }
    }


    @Preview(showSystemUi = true)
    @Composable
    fun forPreview() {
        LoginScreen(welcomeMessage = "Hi, Welcome Here")
    }
}