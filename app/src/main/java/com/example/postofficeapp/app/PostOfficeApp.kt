package com.example.postofficeapp.app

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.postofficeapp.R
import com.example.postofficeapp.Screens.HomeScreen
import com.example.postofficeapp.Screens.LoginScreen
import com.example.postofficeapp.Screens.SignUpScreen
import kotlinx.coroutines.delay

@Composable
fun PostOfficeApp(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        Spashscreen()

        Crossfade(targetState = PostOfficeAppRouter.currentScreen, label = "") { currentState ->

            when(currentState.value){
               is  Screen.SignUpScreen -> {
                   SignUpScreen()
               }
                is Screen.loginScreen -> {
                    LoginScreen()
                }

                is Screen.homeScreen -> {
                    HomeScreen()
                }
            }

        }
    }
}

@Composable
private fun Spashscreen() {
    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 =  true , block = {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }

            )
        )
        delay(3000L)
        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
    }

    )

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue) , contentAlignment = Alignment.Center) {

        Image(painter = painterResource(id = R.drawable.ic_done_email), contentDescription = null)

    }
}





