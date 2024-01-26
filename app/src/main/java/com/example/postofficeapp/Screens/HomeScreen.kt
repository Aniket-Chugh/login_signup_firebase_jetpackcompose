package com.example.postofficeapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.postofficeapp.components.ButtonComponent
import com.example.postofficeapp.data.SignUpViewModel

@Composable
fun HomeScreen(signUpViewModel: SignUpViewModel = viewModel()) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(21.dp)
        ){
            Column(modifier = Modifier.fillMaxSize()) {
Text(text = "home Screen")
                
                
                ButtonComponent(value = "Logout", onButtonClicked =  {
                    signUpViewModel.logOut()
                }  ,
                isEnabled = true
                )
            }
    }}}