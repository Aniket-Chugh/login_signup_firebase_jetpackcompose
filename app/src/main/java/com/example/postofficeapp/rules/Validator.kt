package com.example.postofficeapp.rules

object Validator {
fun validatefirstname(fname :  String) : ValidateResult{
return ValidateResult(
    (!fname.isNullOrEmpty() && fname.length >= 4)
)
}
    fun validatelastname(lname :  String) : ValidateResult{
        return ValidateResult((!lname.isNullOrEmpty() && lname.length >= 4))

    }
    fun validateemail(email :  String) : ValidateResult{
        return ValidateResult((!email.isNullOrEmpty()))

    }
    fun validatepassword(password :  String) : ValidateResult{
        return ValidateResult((!password.isNullOrEmpty() && password.length >= 6))

    }

}

data class ValidateResult(
    val status : Boolean = false
)

