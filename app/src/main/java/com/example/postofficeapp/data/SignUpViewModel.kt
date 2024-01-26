package com.example.postofficeapp.data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.postofficeapp.app.PostOfficeAppRouter
import com.example.postofficeapp.app.Screen
import com.example.postofficeapp.rules.Validator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener

class SignUpViewModel : ViewModel() {
var registrationUIState = mutableStateOf(RegistrationUIState())

    var signUpInProgress = mutableStateOf(false)

fun OnEvent(event: SignUIEvent){
    when(event){
        is SignUIEvent.FirstNameChanged -> {
          registrationUIState.value = registrationUIState.value.copy(
              firstname = event.firstname
          )
        }

        is SignUIEvent.LastNameChanged -> {
            registrationUIState.value = registrationUIState.value.copy(
                lastname = event.lastname
            )
        }

        is SignUIEvent.EmailChanged -> {
            registrationUIState.value = registrationUIState.value.copy(
                email = event.email
            )
        }

        is SignUIEvent.PasswordChanged -> {
            registrationUIState.value = registrationUIState.value.copy(
                password = event.password
            )
        }

        is SignUIEvent.RegisterButtonClicked ->{
            signUp()
        }


        else -> {}
    }
}

    private fun signUp() {
        Log.d(TAG, "signup_inside")
        valideDataWithRules()
        createUserInFireBase(
            email = registrationUIState.value.email,
            password = registrationUIState.value.password
        )
    }

    private fun valideDataWithRules() {
        val fnameResult = Validator.validatefirstname(registrationUIState.value.firstname)
        val lnameResult = Validator.validatelastname(registrationUIState.value.lastname)
        val emailResult = Validator.validateemail(registrationUIState.value.email)
        val passwordResult = Validator.validatefirstname(registrationUIState.value.password)

        Log.d(TAG, "datawithvalideDataWithRules")

    }


    private fun createUserInFireBase(
        email : String,
        password : String
    ){

        signUpInProgress.value = true


FirebaseAuth.getInstance()
    .createUserWithEmailAndPassword(email , password)
    .addOnCompleteListener{
        signUpInProgress.value = true

        if(it.isSuccessful){
            PostOfficeAppRouter.navigateTo(Screen.homeScreen)

        }

    }
    .addOnFailureListener{
        Log.d(TAG, "OnFailure_listener")

    }
}

    fun logOut(){
        val firebaseAuth = FirebaseAuth.getInstance()

        firebaseAuth.signOut()

        val authStateListener = AuthStateListener{
            if (it.currentUser == null){
Log.d(TAG, "signOut_listener")

                PostOfficeAppRouter.navigateTo(Screen.loginScreen)

            } else{
                Log.d(TAG, " no_signOut_listener")

            }
        }

        firebaseAuth.addAuthStateListener(authStateListener)
    }


    }

