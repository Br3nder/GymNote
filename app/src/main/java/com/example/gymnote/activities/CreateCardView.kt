package com.example.gymnote.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.OutlinedTextField
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.example.gymnote.*
import com.example.gymnote.R
import com.example.gymnote.room.ExercisesDataBase
import com.example.gymnote.room.Repository
import com.example.gymnote.ui.theme.GymNoteTheme
import com.example.gymnote.ui.theme.Shapes
import com.example.gymnote.ui.theme.SportBlue
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.Color.Companion as Color1


class CreateCardViews : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymNoteTheme {
                val Header: String = intent?.extras?.getString("Header").toString()
                val context = this
                Column() {
                    header("Создать карточку")
                    topApptex()
                }
            }
        }
    }
}

@Preview
@Composable
fun tso() {
    header("Создать карточку")
}

@Composable
fun topApptex() {
    val context = LocalContext.current
    val newExerciseName = remember { mutableStateOf("") }
    val tag = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(inSurfacePadding)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                newExerciseName.value,
                onValueChange = { newExerciseName.value = it },
                label = { Text("Название упражнения") },
                shape = Shapes.medium
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
                tag.value,
                onValueChange = { tag.value = it },
                label = { Text("#хэштег") },
                shape = Shapes.medium
            )
        }
        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = inSurfacePadding, start = 25.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Режим", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            val lock = remember {
                mutableStateOf(false)
            }

            Switch(
                checked = lock.value,
                onCheckedChange = { lock.value = it },
                colors = SwitchDefaults.colors(SportBlue)
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
                onClick = {
                    var newExercise = Exercise(newExerciseName.value, false, null)
                    GlobalScope.launch {
                        Repository(ExercisesDataBase.getDatabase(context)).add(newExercise)
                    }
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(BTN_HEIGHT_LONG),
                shape = Shapes.medium
            )
            {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Создать"
                    )
                }

            }


        }
    }


}