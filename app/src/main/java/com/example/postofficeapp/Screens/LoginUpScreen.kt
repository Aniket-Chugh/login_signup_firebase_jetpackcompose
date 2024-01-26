package com.example.postofficeapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.postofficeapp.R
import com.example.postofficeapp.components.AfterButtonComponent
import com.example.postofficeapp.components.ButtonComponent
import com.example.postofficeapp.components.CheckBoxPlace
import com.example.postofficeapp.components.Forgetpasswordtext
import com.example.postofficeapp.components.HeadingTextComponent
import com.example.postofficeapp.components.NormalTextComponent
import com.example.postofficeapp.components.NormalTextField
import com.example.postofficeapp.components.NotloginText
import com.example.postofficeapp.components.PasswordTextField
import com.example.postofficeapp.data.LoginUiEvent
import com.example.postofficeapp.data.LoginViewModal

@Composable
fun LoginScreen(loginViewModal: LoginViewModal = viewModel()){


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(21.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                NormalTextComponent(value = stringResource(id = R.string.startingText))
                HeadingTextComponent(value = stringResource(id = R.string.login))
                Spacer(modifier = Modifier.padding(10.dp))
                NormalTextField(
                    value = stringResource(id = R.string.email),
                    painterResource(id = R.drawable.ic_done_email),
                    onTextChanged = {
                        loginViewModal.onEvent(LoginUiEvent.EmailChanged(it))
                    }
                )
                PasswordTextField(value = stringResource(id = R.string.password), painterResource = painterResource(
                    id = R.drawable.ic_password
                ) ,
                    onTextChanged = {
                        loginViewModal.onEvent(LoginUiEvent.PasswordChanged(it))

                    })
                Forgetpasswordtext(value = stringResource(id = R.string.forget_password))
                CheckBoxPlace()

                ButtonComponent(value = stringResource(id = R.string.login) , onButtonClicked =  {
                    loginViewModal.onEvent(LoginUiEvent.LoginButtonClicked)
                })
                AfterButtonComponent()
                NotloginText()
            }
        }
    }
}


