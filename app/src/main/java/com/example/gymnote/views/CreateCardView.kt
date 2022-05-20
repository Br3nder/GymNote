package com.example.gymnote.views

import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.runtime.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TopAppBar
import androidx.navigation.compose.rememberNavController
import com.example.gymnote.*
import com.example.gymnote.R
import com.example.gymnote.activities.ExercisesList
import com.example.gymnote.activities.TrainingActivity

import com.example.gymnote.ui.theme.GymNoteTheme
import com.example.gymnote.ui.theme.Shapes
import com.example.gymnote.ui.theme.SportBlue
import androidx.compose.ui.graphics.Color.Companion as Color1



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val Header: String = intent?.extras?.getString("Header").toString()
            com.example.gymnote.TopAppBar(Header = Header)
            val navController = rememberNavController()
            GymNoteTheme {

                val context = this
                Column() {
                    topApptex()
                    ExercisesList(exercises = exercises, context = context)
                }
            }
        }
    }
}

@Preview
@Composable
fun tso(){
    TopAppBar("Создать карточку")
}

@Preview
@Composable
fun topApptex() {

    val context = LocalContext.current
    val message = remember { mutableStateOf("") }

    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = surfacePadding,
                end = surfacePadding,
                top = surfacePadding / 2,
                bottom = surfacePadding / 2
            )
            .background(color = Color1.White)
    ) {
        Column(
            modifier = Modifier.padding(inSurfacePadding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = surfacePadding,
                        end = surfacePadding - 3.dp,
                        top = surfacePadding / 2,
                        bottom = 10.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {}
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    message.value,
                    { message.value = it },
                    label = { Text("Название упражнения") },
                    shape = Shapes.large
                )


            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    message.value,
                    { message.value = it },

                    label = { Text("#хэштег") },
                    shape = Shapes.large
                )


            }
            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, start = 25.dp, end = 25.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Режим", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp )
                val lock = remember {
                    mutableStateOf(false)
                }

                Switch(
                    checked = lock.value,
                    onCheckedChange = { lock.value = it },
                    colors = SwitchDefaults.colors(Color.Cyan)
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )
            {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = Shapes.large
                )
                {
                    Row() {

                        Image(
                            painter = painterResource(id = R.drawable.bok),

                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier

                                .size(30.dp)
                                .padding(end = 5.dp, top = 8.dp)
                        )
                        Text("Создать", fontSize = 26.sp)
                    }

                }


            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )
            {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = Shapes.large
                )
                {
                    Row() {
                        Image(
                            painter = painterResource(id = R.drawable.bok),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(30.dp)
                                .padding(end = 5.dp, top = 8.dp)
                        )
                        Text("Создать и начать", fontSize = 26.sp)
                    }

                }


            }
        }
    }

}

















