package com.example.gymnote

import android.graphics.Paint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

val inSurfacePadding = 18.dp
val surfacePadding = 24.dp

var enterText: String = ""

data class Approache(val weight: Int, val repeats: Int){}

@Composable
fun ExerciseCard(exerciseName: String, typeOfExercise: Boolean, approaches: List<Approache>){ // false - время, true - повторения
    Surface(shape = MaterialTheme.shapes.medium, elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = surfacePadding, end = surfacePadding)) {
        Column(modifier = Modifier.padding(inSurfacePadding)) {
            Row( modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = inSurfacePadding),
                horizontalArrangement = Arrangement.SpaceBetween){ //Шапка
                Text(text = exerciseName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 4.em)
                Icon(Icons.Rounded.ArrowDropDown,
                    contentDescription = "More about exercise")
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = surfacePadding / 2)
                .padding(start = inSurfacePadding, end = inSurfacePadding),
                horizontalArrangement = Arrangement.SpaceBetween){ //Контент карточки упражнения
                Text(text = "Подход")
                Text(text = "Вес", textAlign = TextAlign.Center)
                Text(text = if(typeOfExercise) "Повторения" else "Время", textAlign = TextAlign.End)
            }
            //Сделать так, чтобы была возможность создания множества Row по входящему списку
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "1",
                    modifier = Modifier.padding(start = 24.dp).height(40.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 4.em
                )
                TextField(value = "XX",
                    onValueChange = { enterText = it},
                modifier = Modifier.width(100.dp))
                TextField(value = "XX",
                    onValueChange = { enterText = it},
                    modifier = Modifier.width(100.dp))
            }
        }
    }
}

//Test data

val approaches: List<Approache> = listOf(
    Approache(80, 12),
    Approache(120, 10),
    Approache( 15, 100))

@Preview(showBackground = true)
@Composable
fun ExerciseCardPreview(){
    ExerciseCard(exerciseName = "Chest press", typeOfExercise = true, approaches = approaches)
}