package com.example.postofficeapp.components


import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.OffsetEffect
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.postofficeapp.R

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}



@Composable
fun clickableText(){
    Row(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()    ) {

 Text(text = "are u satisfy with our " )
        Text(text = "Privacy" ,
            textDecoration = TextDecoration.Underline

        ,modifier = Modifier.clickable {
//
        })
        Text(text = " and " )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Terms" ,  textDecoration = TextDecoration.Underline

            ,modifier = Modifier.clickable {
                //
            })
    }
}

@Composable
fun Forgetpasswordtext( value : String){
Text(text = value, modifier = Modifier.padding(12.dp).clickable {
                                                                //TODO
},
    fontSize = 14.sp,
    textDecoration = TextDecoration.Underline,
    fontWeight = FontWeight.Normal,
    color = colorResource(id = R.color.colorText),
    textAlign = TextAlign.Center
    )

}


