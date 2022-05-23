package com.example.gymnote.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gymnote.*
import com.example.gymnote.ui.theme.GymNoteTheme
import com.example.gymnote.ui.theme.*
import com.example.gymnote.activities.CreateCardViews



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            GymNoteTheme {

                val context = this
                Column() {
                    topAppBar()
                    ExercisesList(exercises = exercises, context = context)
                }
            }
        }
    }
}

@Composable
@Preview
fun topAppBar() {
    TopAppBar(
        contentPadding = PaddingValues(start = 20.dp),
        backgroundColor = Color.White,
        modifier = Modifier.height(54.dp)
    ) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = SportBlue,
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp
                    ),
                ) {
                    append("Gym")
                }

                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp
                    )
                ) {
                    append("Note")
                }

            }
        )
    }
}

@Composable
fun ExercisesList(exercises: List<Exercise>, context: Context) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        items(exercises) { item ->
            ExerciseCard(
                exercise = item,
                context = context
            )
        }
        item {
            Button(
                onClick = {
                    val intent = Intent(context, CreateCardViews::class.java)

                    context.startActivity(intent)
                     },
                modifier = Modifier
                    .padding(top = 32.dp)
                    .height(BTN_HEIGHT_SHORT)
                    .width(BTN_WIDTH_SHORT),
                shape = Shapes.medium,
                colors = ButtonDefaults.buttonColors(backgroundColor = SportBlue)
            ) {
                Icon(
                    Icons.Rounded.Add,
                    contentDescription = "add new exercise",
                    tint = Color.White
                )
            }
        }
    }
}




