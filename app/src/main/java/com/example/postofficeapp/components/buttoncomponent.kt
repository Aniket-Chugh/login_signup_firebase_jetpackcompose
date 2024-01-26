package com.example.postofficeapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.GTranslate
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.postofficeapp.app.PostOfficeAppRouter
import com.example.postofficeapp.app.Screen

@Composable
fun ButtonComponent(value : String , onButtonClicked : () -> Unit ,
                    isEnabled : Boolean = false
                    ){

    Button(onClick = {
onButtonClicked.invoke()
    },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent),


        contentPadding = PaddingValues()



        ) {
        Box(modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color.Blue, Color.Red),

                    ),
                shape = RoundedCornerShape(50.dp)
            )
            .fillMaxWidth()
            .padding(18.dp),
            contentAlignment = Alignment.Center
        ){
            Text(text = value)

        }
    }

}

@Composable
fun AfterButtonComponent(){
    Box(modifier = Modifier.padding(12.dp))    {
        Row {
            Divider(modifier = Modifier
                .width(144.dp)
                .padding(9.dp), thickness = 2.dp)
Text(text = "or")
            Divider(modifier = Modifier
                .width(124.dp)
                .padding(start = 9.dp, 9.dp) ,  thickness = 2.dp)

        }
    }
}



@Composable
fun AlreadySignUpText(){
    Row(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()   ,
        horizontalArrangement = Arrangement.Center
        ) {

        Text(text = "Already Registered ? " , modifier = Modifier.padding(1.dp) , fontSize = 18.sp , fontWeight = FontWeight.Bold)
        Text(text = "Login ->" ,
            textDecoration = TextDecoration.Underline,  fontSize = 18.sp

            ,modifier = Modifier.clickable {
 PostOfficeAppRouter.navigateTo(Screen.loginScreen)
            } )

    }
}


@Composable
fun NotloginText(){
    Row(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()   ,
        horizontalArrangement = Arrangement.Center
    ) {

        Text(text = "Not Registered ? " , modifier = Modifier.padding(1.dp) , fontSize = 18.sp , fontWeight = FontWeight.Bold)
        Text(text = "Sign Up ->" ,
            textDecoration = TextDecoration.Underline,  fontSize = 18.sp

            ,modifier = Modifier.clickable {
PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
            } )

    }
}
