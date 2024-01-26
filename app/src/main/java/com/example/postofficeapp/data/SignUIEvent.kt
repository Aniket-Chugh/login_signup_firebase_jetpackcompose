package com.example.postofficeapp.data

sealed class SignUIEvent{
    data class FirstNameChanged(val firstname : String) : SignUIEvent()
    data class LastNameChanged(val lastname : String) : SignUIEvent()
    data class EmailChanged(val email : String) : SignUIEvent()
    data class PasswordChanged(val password : String) : SignUIEvent()

    object RegisterButtonClicked : SignUIEvent()

}
