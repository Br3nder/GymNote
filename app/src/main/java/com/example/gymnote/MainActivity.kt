package com.example.gymnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
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
val e = Exercise(name = "Chest press", typeOfExercise = true, approaches = a)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymNoteTheme {



            }
        }
    }
}

@Composable
@Preview
fun topAppBar(){
    TopAppBar(
        contentPadding = PaddingValues(start = 20.dp),
        backgroundColor = Color.White
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