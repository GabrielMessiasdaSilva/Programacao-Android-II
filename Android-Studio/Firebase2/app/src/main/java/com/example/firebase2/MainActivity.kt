package com.example.firebase2

import android.graphics.fonts.FontFamily
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebase2.ui.theme.Firebase2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Firebase2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App (){
    val nome = "";
    val telefone = "";
    Column (
        Modifier
            .background(Color.White)

    ) {
        Row(
            Modifier
                .background(Color.DarkGray)
                .fillMaxWidth(),
            Arrangement.Center
        ) {

            Text(
                text = "Firestore ",
                color = Color.White,
                fontWeight = FontWeight.Bold,

                fontSize = 50.sp,


                )

        }
        Row(
            Modifier
                .padding(6.dp)
        ) {

        }
        Row(
            Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(8.dp),
            Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically


        ) {

            Column(

            ) {
                Text(
                    text = "nome",

                    )
            }
            Column() {
                TextField(value = "nome", onValueChange = {})
            }


        }
        Row(
            Modifier
                .padding(6.dp)
        ) {

        }
        Row(
            Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(8.dp),
            Arrangement.SpaceAround,
            Alignment.CenterVertically
        ) {

            Column(

            ) {
                Text(text = "telefone")
            }
            Column() {
                TextField(value = "telefone", onValueChange = {})
            }

        }
        Row(
            Modifier.fillMaxWidth(),
            Arrangement.Center
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Cadastrar")
            }
        }
    }
}


@Composable
@Preview

fun AppPreview(){
    Firebase2Theme() {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            App()
        }
    }

}
