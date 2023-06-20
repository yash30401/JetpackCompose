package com.devyash.jetpackcompose

sealed class SCREEN(val route:String){
    object MainScreen:SCREEN("main_screen")
    object DetailScreen:SCREEN("detail_screen")

    fun withArgs(vararg args:String):String{
        return buildString {
            append(route)
            args.forEach { arg->
                append("/$arg")
            }
        }
    }
}
