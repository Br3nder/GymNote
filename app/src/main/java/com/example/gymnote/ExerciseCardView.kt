package com.example.gymnote
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val inSurfacePadding = 18.dp
val surfacePadding = 24.dp

var enter: Int = 0
var enterS: String = ""

val myShape = Shapes(
    small = RoundedCornerShape(percent = 7),
    medium = RoundedCornerShape(percent = 24),
    large = RoundedCornerShape(percent = 32))

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
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.width(40.dp))
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) { //weight

            OutlinedTextField(
                value = enterS,
                onValueChange = {},
                readOnly = true,
                placeholder = { Text(text = "Test")},
                shape = myShape.medium,
                modifier = Modifier
                    .width(70.dp),
                    //.height(40.dp),
                textStyle = TextStyle(textAlign = TextAlign.Center))
        }
        Column(horizontalAlignment = Alignment.End) { //repeat
            OutlinedTextField(
                value = enterS,
                textStyle = TextStyle(textIndent = TextIndent(0.sp)),
                readOnly = true,
                shape = myShape.medium,
                placeholder = { Text(text = "69")},
                onValueChange = { enterS = it},
                modifier = Modifier
                    .width(70.dp))
                //    .height(40.dp))
        }
    }
}

@Composable
fun ExerciseCard(exercise: Exercise, context: Context){ // false - время, true - повторения
    var isExpanded by remember { mutableStateOf(false) }
    Surface(
        shape = myShape.small,
        elevation = 16.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = surfacePadding,
                end = surfacePadding,
                top = surfacePadding / 2,
                bottom = surfacePadding / 2
            )
            .clickable { isExpanded = !isExpanded }) {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
                    .padding(inSurfacePadding),
                horizontalArrangement = Arrangement.SpaceBetween){ //Шапка
                Text(
                    text = exercise.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp)
                Icon(
                    Icons.Rounded.ArrowDropDown,
                    contentDescription = "More about exercise")
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = inSurfacePadding * 2, end = inSurfacePadding * 2),
                horizontalArrangement = Arrangement.SpaceBetween){ //Контент карточки упражнения
                Text(
                    text = "Подход",
                    color = Color.Gray
                )
                Text(
                    text = "Вес",
                    textAlign = TextAlign.Center,
                    color = Color.Gray)
                Text(
                    text = if(exercise.typeOfExercise) "Повторения" else "Время",
                    textAlign = TextAlign.End,
                    color = Color.Gray)
            }
            //Сделать так, чтобы была возможность создания множества Row по входящему списку
            //LazyColumn(modifier = Modifier.padding(start = inSurfacePadding, end = inSurfacePadding)) {
            for(i in exercise.approaches.indices){
                ApproacheTemplate(numOfApproache = i + 1, approache = exercise.approaches[i])
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(surfacePadding)
                    .height(40.dp),
                shape = myShape.large,
                onClick = {
                    val intent = Intent(context, TrainingActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.putExtra("exerciseName", exercise.name)
                    context.startActivity(intent)
                }) {
                Text(text = "Начать")
            }
        }
    }
}

@Composable
fun myForm(enterString: String){
    var text: String = enterString;
    BasicTextField(
        value = text,
        onValueChange = {newText -> text = newText},
        Modifier
            .padding(vertical = 6.dp)
            .width(64.dp))
}

@Composable
@Preview(showBackground = true)
fun myFormPreview(){
    myForm(enterString = "Hello")
}