package com.devyash.jetpackcompose

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


    @Composable
    fun Greeting(name: String) {
        Text(
            text = "Hello $name",
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Serif,
            fontSize = 30.sp
        )
    }

    @Composable
    private fun ImageViewer() {
        Image(
            painter = painterResource(id = R.drawable.baseline_chat_24),
            contentDescription = "Testing Image",
            colorFilter = ColorFilter.tint(Color.DarkGray)
        )
    }

    @Composable
    private fun ButtonTesting() {
        Button(
            onClick = {

            },
            elevation = ButtonDefaults.buttonElevation(10.dp),
            modifier = Modifier
                .width(10.dp)
                .height(10.dp)
        ) {
            Text(text = "Testing Button")
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun textField(value: String) {
        val state = remember {
            mutableStateOf("")
        }
        TextField(
            value = "${state.value}",
            onValueChange = {
                state.value = it
            },
            label = { Text(text = "Type Text") }
        )
    }

    @Composable
    private fun columnsAndRows() {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Hello World!")
            Text(text = "Hello Yash!")
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Hello World!")
            Text(text = "Hello Yash!")
        }

        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.baseline_chat_24),
                contentDescription = "Chat Image",
                Modifier.size(100.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Chat Image",
                Modifier.size(50.dp)
            )
        }
    }

    @Composable
    private fun usersChat() {
        Row(Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.baseline_chat_24),
                contentDescription = "Chat Image",
                modifier = Modifier.size(50.dp)
            )

            Column(Modifier.padding(5.dp)) {
                Text(
                    text = "Yashveer Singh", fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Hi, Yash how are you? Hope you are good.",
                    color = Color.Gray
                )
            }
        }
    }

    @Composable
    private fun cardInCompose(img: Int, title: String, subtitle: String) {
        Card(modifier = Modifier.padding(8.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = img),
                    contentDescription = "Testing",
                    modifier = Modifier
                        .size(48.dp)
                        .padding(8.dp)
                        .weight(.2f)
                )
                Column(modifier = Modifier.weight(.8f)) {
                    Text(
                        text = "$title",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = "$subtitle",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Thin
                    )
                }
            }
        }
    }

    @Composable
    private fun lazyColumns() {
        LazyColumn(content = {
            items(getCategoryList()) { item ->
                cardInCompose(img = item.img, title = item.title, subtitle = item.subtitle)
            }
        })
    }

    @Composable
    private fun MessageBar(count: Int) {
        Card() {
            Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "",
                    Modifier.padding(4.dp)
                )
                Text(text = "Message sent so far -$count")
            }
        }
    }

    @Composable
    private fun NotificationCounter(count: Int, increment: () -> Unit) {

        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "You have sent ${count} Notifications")
            Button(onClick = { increment() }) {
                Text(text = "Send Notification")
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        /*  Greeting("Android")
          ImageViewer()*/


//    ButtonTesting()

//    textField("Hello")
//    columnsAndRows()
//    usersChat()

//    cardInCompose(
//        R.drawable.baseline_chat_24,
//        "Yashveer Singh",
//        "Hello, Yash how are you?"
//    )
//    lazyColumns()

//    NotificationCounter(count.value) { count.value++ }
    }
