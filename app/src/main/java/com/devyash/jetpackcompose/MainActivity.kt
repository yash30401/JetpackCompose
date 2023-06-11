package com.devyash.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.runtime.LaunchedEffect
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
import com.devyash.jetpackcompose.screens.QuoteDetail
import com.devyash.jetpackcompose.screens.QuoteListScreen

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
            
            hasSideEffects()

        }


    }
    
}

var counter = 0
@Composable
private fun hasSideEffects() {
    counter++
    Text(text = "Yash")
}

@Composable
private fun listComposables(){
    val categoryState = remember { mutableStateOf(emptyList<String>()) }

   /* It will launch only First Time when the composable call
   * It is good in scenarios when you want to do a network call and want to do One time Activity
   * Key tells that how many time LaunchedEffect should execute */
    LaunchedEffect(key1 = Unit){
        categoryState.value = fetchCategories()
    }
    
    LazyColumn(content = {
        items(categoryState.value) {
            Text(text = it)
        }
    })
}

private fun fetchCategories():List<String>{
    return listOf("One","Two","Three")
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
    }else{
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
