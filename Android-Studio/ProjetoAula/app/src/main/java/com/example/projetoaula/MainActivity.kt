package com.example.projetoaula

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.projetoaula.ui.theme.ProjetoAulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoAulaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        App()
                }
            }
        }
    }
}
@Composable
fun App (){
    Column (
    Modifier
        .background(Color.White)

    ){
    Row(
        Modifier
            .background(Color.Yellow)
            .fillMaxWidth(),
            Arrangement.Center
    ){

        Text(text = "Aulinha de PAM",
             fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp,
            color = Color(Blue)

            )

    }
        Row(
            Modifier
                .padding(6.dp)
        ){

        }
        Row(
            Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding( 8.dp),
                 Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically



        ) {

        Column(

        ) {
            Text(text = "Gabriel Messias",

                )
        }

        Column(

        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Editar")

            }
        }

        Column() {
            Button(onClick = { /*TODO*/ }) {
                    Text(text = "Excluir")
            }
        }
    }
        Row(
            Modifier
                .padding(6.dp)
        ){

        }
        Row(
            Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding( 8.dp),
            Arrangement.SpaceAround,
            Alignment.CenterVertically
        ) {

            Column(

            ) {
                Text(text = "Gabriel Messias")
            }

            Column(

            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Editar")
                }
            }

            Column() {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Excluir")
                }
            }
        }
    }
}

@Composable
@Preview

fun AppPreview(){
    ProjetoAulaTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            App()
        }
    }

}
