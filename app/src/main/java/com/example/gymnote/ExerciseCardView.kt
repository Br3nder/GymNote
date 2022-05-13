package com.example.gymnote
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

val inSurfacePadding = 18.dp
val surfacePadding = 24.dp

var enter: Int = 0
var enterS: String = ""

data class Approache(val weight: Int, val repeats: Int){}
data class Exercise(val name: String,val typeOfExercise: Boolean,val approaches: List<Approache>){}

@Composable
fun ApproacheTemplate(numOfApproache: Int, approache: Approache){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = surfacePadding, end = surfacePadding - 3.dp, top = surfacePadding / 2),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Column(horizontalAlignment = Alignment.Start) { //Approach
            Text(
                text = numOfApproache.toString(),
                fontSize = 4.em,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.width(40.dp))
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) { //weight

            OutlinedTextField(
                value = "",
                onValueChange = { it -> enterS},
                modifier = Modifier
                    .width(70.dp)
                    .height(40.dp),
                textStyle = TextStyle(textAlign = TextAlign.Center))
        }
        Column(horizontalAlignment = Alignment.End) { //repeat
            OutlinedTextField(
                value = "",
                onValueChange = { it -> enterS},
                modifier = Modifier
                    .width(70.dp)
                    .height(40.dp))
        }
    }
}

@Composable
fun ExerciseCard(exercise: Exercise){ // false - время, true - повторения
    Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 16.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = surfacePadding,
                end = surfacePadding,
                top = surfacePadding / 2,
                bottom = surfacePadding / 2
            )) {
        Column(modifier = Modifier.padding(inSurfacePadding)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = inSurfacePadding),
                horizontalArrangement = Arrangement.SpaceBetween){ //Шапка
                Text(
                    text = exercise.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 4.em)
                Icon(
                    Icons.Rounded.ArrowDropDown,
                    contentDescription = "More about exercise")
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = inSurfacePadding, end = inSurfacePadding),
                horizontalArrangement = Arrangement.SpaceBetween){ //Контент карточки упражнения
                Text(text = "Подход")
                Text(
                    text = "Вес",
                    textAlign = TextAlign.Center)
                Text(
                    text = if(exercise.typeOfExercise) "Повторения" else "Время",
                    textAlign = TextAlign.End)
            }
            //Сделать так, чтобы была возможность создания множества Row по входящему списку
            LazyColumn() {
                var numOfApproache: Int = 1 // fix: start from 4? why?
                items(exercise.approaches){
                        approache -> ApproacheTemplate(numOfApproache = numOfApproache,approache = approache)
                    numOfApproache++
                }
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = surfacePadding / 2)
                    .height(40.dp),
                shape = MaterialTheme.shapes.small,
                onClick = { /*TODO*/ }) {
                Text(text = "Начать")
            }
        }
    }
}

//Test data

val approaches: List<Approache> = listOf(
    Approache(80, 12),
    Approache(120, 10),
    Approache( 15, 100))
val exercise = Exercise(name = "Chest press", typeOfExercise = true, approaches = approaches) //Example for data

@Preview(showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun ExerciseCardPreview(){
    ExerciseCard(exercise = exercise)
}