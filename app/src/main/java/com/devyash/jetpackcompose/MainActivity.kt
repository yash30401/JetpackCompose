package com.devyash.jetpackcompose

import android.os.Bundle
import android.text.Editable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.Navigation
import com.devyash.jetpackcompose.screens.QuoteDetail
import com.devyash.jetpackcompose.screens.QuoteListScreen
import com.devyash.jetpackcompose.screens.navigation
import com.devyash.jetpackcompose.ui.HomeScreen


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Greeting("Android")
//            cardInCompose(
//                R.drawable.baseline_chat_24,
//                "Yashveer Singh",
//                "Hello, Yash how are you?"
//            )
//            lazyColumns()
//            var count = rememberSaveable { mutableStateOf(0) }
//            Column(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.fillMaxSize(1f)
//            ) {
//                NotificationCounter(count.value,{ count.value++ })
//                MessageBar(count.value)
//            }
//            DataManager.loadAssetsFromFile(this)
//            App()

//            hasSideEffects()
//            AnimateInCompose()

//            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
//                CircularProgressBar(.8f, 100, 28.sp, 50.dp, Color.Green, 8.dp, 1000, 100)
//            }


//            HomeScreen()


//        navigation()

//        greeting(name = "Yash")
            greeting(name = "Yash")
        }


    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun greeting(name: String) {
    var name by remember {
        mutableStateOf("")
    }
    var names by remember {
        mutableStateOf(listOf<String>())
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(modifier = Modifier.width(250.dp),value = name, onValueChange = {
                name = it
            })
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                if(name.isNotBlank()){
                    names = names + name
                    name = ""
                }
            }) {
                Text(text = "Add")
            }
        }

        LazyColumn(Modifier.padding(15.dp)){
            items(names){
                Text(text = it, fontSize = 25.sp)
                Divider(thickness = 1.dp)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }

//    var count by remember {
//        mutableStateOf(0)
//    }
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//
//        Text(text = count.toString(), fontSize = 30.sp)
//        Button(onClick = {
//            count++
//        }) {
//            Text(text = "Increase")
//        }

//        Text(
//            text = "Hi, $name",
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.Green)
//                .padding(10.dp)
//                .background(Color.Blue),
//            fontSize = 30.sp,
//            color = Color.Red,
//            fontStyle = FontStyle.Italic,
//            fontWeight = FontWeight.ExtraBold,
//            fontFamily = FontFamily.Serif,
//            textDecoration = TextDecoration.Underline,
//            textAlign = TextAlign.Center
//        )
//
//        Text(
//            modifier = Modifier.fillMaxWidth(),
//            text = "Hi, How are u doing",
//            fontSize = 30.sp,
//            color = Color.Red,
//            fontStyle = FontStyle.Italic,
//            fontWeight = FontWeight.ExtraBold,
//            fontFamily = FontFamily.Serif,
//            textDecoration = TextDecoration.Underline,
//            textAlign = TextAlign.Center
//        )
//
//        Box(
//            modifier = Modifier
//                .background(Color.Red)
//                .width(50.dp)
//                .height(50.dp),
//            contentAlignment = Alignment.Center
//        ) {
//
//            Image(
//                painter = painterResource(id = R.drawable.baseline_casino_24),
//                contentDescription = ""
//            )
//        }
//        Button(onClick = { }) {
//            Text(text = "Hi!")
//        }

    }




@Preview(showSystemUi = true)
@Composable
private fun forPreview() {
    greeting(name = "Yash")

}


// Old---------------------------------------------------

var counter = 0

@Composable
private fun hasSideEffects() {
    counter++
    Text(text = "Yash")
}

@Composable
private fun listComposables() {
    val categoryState = remember { mutableStateOf(emptyList<String>()) }

    /*It will launch only First Time when the composable call.
    * It is good in scenarios when you want to do a network call and want to do One time Activity.
    * If fetching takes time it will automaically call it on the background thread.
    * It will launch new coroutine and dispose the older one on configuration changes to get rid from memory leaks.
    *
    * PROBLEMS WITH LaunchEffect:-
    * 1. It's a composable so it can only run inside a composable. For ex:- We can't use it inside a button's onClick() function.
    * */
    LaunchedEffect(key1 = Unit) {
        categoryState.value = fetchCategories()
    }

    LazyColumn(content = {
        items(categoryState.value) {
            Text(text = it)
        }
    })
}

private fun fetchCategories(): List<String> {
    return listOf("One", "Two", "Three")
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value == Pages.LISTING) {
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        } else {
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }
    } else {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f)) {
            Text(text = "Loading....", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

enum class Pages {
    LISTING,
    DETAIL
}

data class Category(val img: Int, val title: String, val subtitle: String)

fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.baseline_chat_24, "Yashveer Singh", "Hellow, yash how are you?"))
    list.add(Category(R.drawable.baseline_build_24, "Mohit", "Hellow, Mohit how are you?"))
    list.add(Category(R.drawable.baseline_call_to_action_24, "Rajat", "Hellow, Rajat how are you?"))
    list.add(
        Category(
            R.drawable.baseline_camera_rear_24,
            "Himanshu",
            "Hellow, Himanshu how are you?"
        )
    )
    list.add(Category(R.drawable.baseline_casino_24, "Mahan", "Hellow, Mahan how are you?"))
    list.add(
        Category(
            R.drawable.baseline_center_focus_strong_24,
            "Bhavik",
            "Hellow, Bhavik how are you?"
        )
    )
    list.add(Category(R.drawable.baseline_chat_24, "Yashveer Singh", "Hellow, yash how are you?"))
    list.add(Category(R.drawable.baseline_build_24, "Mohit", "Hellow, Mohit how are you?"))
    list.add(Category(R.drawable.baseline_call_to_action_24, "Rajat", "Hellow, Rajat how are you?"))
    list.add(
        Category(
            R.drawable.baseline_camera_rear_24,
            "Himanshu",
            "Hellow, Himanshu how are you?"
        )
    )
    list.add(Category(R.drawable.baseline_casino_24, "Mahan", "Hellow, Mahan how are you?"))
    list.add(
        Category(
            R.drawable.baseline_center_focus_strong_24,
            "Bhavik",
            "Hellow, Bhavik how are you?"
        )
    )
    list.add(Category(R.drawable.baseline_chat_24, "Yashveer Singh", "Hellow, yash how are you?"))
    list.add(Category(R.drawable.baseline_build_24, "Mohit", "Hellow, Mohit how are you?"))
    list.add(Category(R.drawable.baseline_call_to_action_24, "Rajat", "Hellow, Rajat how are you?"))
    list.add(
        Category(
            R.drawable.baseline_camera_rear_24,
            "Himanshu",
            "Hellow, Himanshu how are you?"
        )
    )
    list.add(Category(R.drawable.baseline_casino_24, "Mahan", "Hellow, Mahan how are you?"))
    list.add(
        Category(
            R.drawable.baseline_center_focus_strong_24,
            "Bhavik",
            "Hellow, Bhavik how are you?"
        )
    )

    return list
}


@Composable
private fun AnimateInCompose() {
    var sizeSate by remember {
        mutableStateOf(200.dp)
    }
    val size by animateDpAsState(
        targetValue = sizeSate,
//        animationSpec = tween(durationMillis = 3000, delayMillis = 400, easing = LinearOutSlowInEasing)
        animationSpec = spring(Spring.DampingRatioHighBouncy)
    )
    var infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            tween(2000),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(
        modifier = Modifier
            .size(size)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            sizeSate += 50.dp
        }) {
            Text(text = "Increase Size")
        }

    }
}


@Composable
private fun CircularProgressBar(
    percentage: Float = 0f,
    number: Int = 0,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 50.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {

    var animationPlayed by remember {
        mutableStateOf(false)
    }

    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(durationMillis = animDuration, delayMillis = animDelay)
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f)
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * curPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (curPercentage.value * number).toInt().toString(),
            color = Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
    }

}


