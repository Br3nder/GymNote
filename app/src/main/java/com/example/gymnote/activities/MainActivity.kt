package com.example.gymnote.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.gymnote.*
import com.example.gymnote.models.ExercisesViewModel
import com.example.gymnote.room.ExerciseEntity
import com.example.gymnote.room.ExercisesDao
import com.example.gymnote.room.ExercisesDataBase
import com.example.gymnote.room.Repository
import com.example.gymnote.ui.theme.GymNoteTheme
import com.example.gymnote.ui.theme.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = Repository(ExercisesDataBase.getDatabase(this))
        var exerciseList: MutableList<Exercise>? = mutableListOf()
        GlobalScope.launch {
            exerciseList = repository.getAll()
        }
        setContent {
            GymNoteTheme {
                //TODO здесь надо сделать запрос на бд, чтобы получить
                // ответ в exercises (после просмотра паттерна repository)
                Column() {
                    topAppBar()
                    ExercisesList(exercises = exerciseList)
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
fun ExercisesList(exercises: MutableList<Exercise>?) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        var i = 0
        items(exercises!!.toList()) { item ->
            ExerciseCard(
                exercise = item,
                exerciseIndex = i
            )
            i++
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