package com.example.gymnote

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymnote.ui.theme.GymNoteTheme

val a: List<Approache> = listOf(
    Approache(80, 12),
    Approache(120, 10),
    Approache( 15, 100))
val e1 = Exercise(name = "Chest press", typeOfExercise = true, approaches = a)
val e2 = Exercise(name = "Pull-ups", typeOfExercise = true, approaches = a)
val e3 = Exercise(name = "Barbell", typeOfExercise = true, approaches = a)

val exercises: List<Exercise> = listOf(e1,e2,e3,e1,e2,e3,e1,e2,e3)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymNoteTheme {
                topAppBar()
                ExercisesList(exercises = exercises, context = this)
            }
        }
    }
}

@Composable
@Preview
fun topAppBar(){
    TopAppBar(
        contentPadding = PaddingValues(start = 20.dp),
        backgroundColor = Color.White,
        modifier = Modifier.height(54.dp)
    ) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Cyan,
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp),) {
                    append("Gym")
                }

                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp)) {
                    append("Note")
                }

            }
        )
    }
}

@Composable
fun ExercisesList(exercises: List<Exercise>, context: Context){
    LazyColumn(modifier = Modifier.fillMaxSize().padding(top = 54.dp)) {
        items(exercises){ item ->
            ExerciseCard(
                exercise = item,
                context = context)
        }
    }
}