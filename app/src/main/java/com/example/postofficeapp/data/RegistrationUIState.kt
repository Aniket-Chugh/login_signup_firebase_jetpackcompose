package com.example.postofficeapp.data

data class RegistrationUIState(
    val firstname : String = "",
    val lastname : String = "",
    val email : String = "",
    val password : String = "",

    var firstNameError : Boolean = false,
    var lastNameError : Boolean = false,
    var emailerror : Boolean = false ,
    var passworderror : Boolean = false



)

