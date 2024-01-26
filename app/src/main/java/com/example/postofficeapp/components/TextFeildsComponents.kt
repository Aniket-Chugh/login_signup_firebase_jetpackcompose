package com.example.postofficeapp.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.postofficeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NormalTextField(value: String, painterResource : Painter , onTextChanged : (String) -> Unit ) {
    var inputext by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = inputext , onValueChange = {
        inputext = it
        onTextChanged(it)
    } ,
        label = {
            Text(text = value)
        },
        leadingIcon = {
            Icon(painter = painterResource , contentDescription = null )

        }
        ,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = Color.Black
        ),
        singleLine = true,
        maxLines = 1
        ,
        placeholder = {
            Text(text = value)
        },
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()

        )
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(value: String ,   painterResource : Painter , onTextChanged: (String) -> Unit){
    var passwordinput = remember {
        mutableStateOf("")
    }

    var PasswordVisbility = remember {
        mutableStateOf(false)
    }

    val localFocusManager = LocalFocusManager.current

       OutlinedTextField(value = passwordinput.value , onValueChange = {
           passwordinput.value = it
           onTextChanged(it)
       },
           label = {
               Text(text = value)
           },
           leadingIcon = {
               Icon(painter = painterResource , contentDescription = null )
           },
           keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password , imeAction = ImeAction.Done),
           colors = TextFieldDefaults.textFieldColors(
               textColor = Color.Black,
               focusedIndicatorColor = Color.Transparent,
               unfocusedIndicatorColor = Color.Transparent,
               focusedLabelColor = Color.Black
           ),
           singleLine = true,
           maxLines = 1
           ,

           keyboardActions = KeyboardActions{
               localFocusManager.clearFocus()
           }
           ,
           placeholder = {
               Text(text = value)
           },
           modifier = Modifier
               .padding(12.dp)
               .fillMaxWidth(),

           trailingIcon = {
               var imageIcon = if(PasswordVisbility.value){
                   Icons.Default.Visibility
               } else{
                   Icons.Default.VisibilityOff
               }

               var description = if(PasswordVisbility.value){
                   "Hide Password"
               } else {
                   "Show Password"
               }


               IconButton(onClick = { PasswordVisbility.value = !PasswordVisbility.value }) {
Icon(imageVector = imageIcon, contentDescription = description )
               }


           },
           visualTransformation = if(PasswordVisbility.value) VisualTransformation.None else PasswordVisualTransformation()


       )
}

@Composable
fun CheckBoxPlace(){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        var checked = remember {
            mutableStateOf(false)
        }

        Checkbox(checked = checked.value , onCheckedChange ={
            checked.value = it
        } )

        clickableText()
    }
}