package com.example.postofficeapp.app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen()  {

    object SignUpScreen  : Screen()
object loginScreen : Screen()
    object homeScreen : Screen()
}

object PostOfficeAppRouter {
     val currentScreen : MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)

    fun navigateTo(destination : Screen){
        currentScreen.value = destination
    }


}