package com.example.postofficeapp.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.postofficeapp.app.PostOfficeAppRouter
import com.example.postofficeapp.app.Screen
import com.google.firebase.auth.FirebaseAuth

class LoginViewModal : ViewModel() {


private val TAG = LoginViewModal::class.simpleName

    var loginUiState  = mutableStateOf(LoginUiState())


    var loginInProgress = mutableStateOf(false)

fun onEvent(
    event: LoginUiEvent
){
    when(event){
        is LoginUiEvent.EmailChanged -> {
            loginUiState.value = loginUiState.value.copy(
                email = event.email
            )
        }
        is LoginUiEvent.PasswordChanged -> {
            loginUiState.value = loginUiState.value.copy(
                password = event.password
            )
        }

        is LoginUiEvent.LoginButtonClicked ->{
login()
        } else -> {}
    }
}

     private fun login() {
        Log.d(TAG, "login_inside")
        val email = loginUiState.value.email
        val password = loginUiState.value.password
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email , password)
            .addOnCompleteListener{
Log.d(TAG, "login_success")

                if (it.isSuccessful){
                    PostOfficeAppRouter.navigateTo(Screen.homeScreen)
                }


            }.addOnFailureListener {
                Log.d(TAG, "loginnot_success")

            }

    }

}