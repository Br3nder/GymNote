package com.example.gymnote

import android.content.Context
import android.content.Intent
import android.graphics.drawable.shapes.Shape
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymnote.activities.TrainingActivity
import com.example.gymnote.ui.theme.Shapes
import com.example.gymnote.ui.theme.SportBlue

val inSurfacePadding = 18.dp
val surfacePadding = 24.dp

var enterS: String = ""

@Composable
fun ApproacheTemplate(numOfApproache: Int, approache: Approache) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = surfacePadding * 2,
                end = surfacePadding * 2 - 3.dp,
                top = surfacePadding / 2
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(horizontalAlignment = Alignment.Start) { //Approach
            Text(
                text = numOfApproache.toString(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.width(40.dp)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) { //weight

            OutlinedTextField(
                value = enterS,
                onValueChange = {},
                readOnly = true,
                placeholder = { Text(text = "Test") },
                shape = Shapes.small,
                modifier = Modifier
                    .width(70.dp).height(56.dp),
                textStyle = TextStyle(textAlign = TextAlign.Center)
            )
        }
        Column(horizontalAlignment = Alignment.End) {
            OutlinedTextField(
                value = enterS,
                textStyle = TextStyle(textIndent = TextIndent(0.sp)),
                readOnly = true,
                shape = Shapes.small,
                placeholder = { Text(text = "69") },
                onValueChange = { enterS = it },
                modifier = Modifier
                    .width(70.dp)
            )
        }
    }
}

@Composable
fun ExerciseCard(exercise: Exercise, context: Context) { // false - ??????????, true - ????????????????????
    var isExpanded by remember { mutableStateOf(false) }
    Surface(
        shape = Shapes.medium,
        elevation = 16.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = surfacePadding,
                end = surfacePadding,
                top = surfacePadding / 2,
                bottom = surfacePadding / 2
            )
            .clickable { isExpanded = !isExpanded }
    ) {
        Column(modifier = Modifier
            .animateContentSize()
            .height(if (isExpanded) getCardHeight(exercise.approaches.size) else 64.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
                    .padding(inSurfacePadding),
                horizontalArrangement = Arrangement.SpaceBetween
            ) { //??????????
                Text(
                    text = exercise.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Icon(
                    Icons.Rounded.ArrowDropDown,
                    modifier = Modifier.rotate(if (isExpanded) 180f else 0f),
                    contentDescription = "More about exercise"
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = inSurfacePadding * 2, end = inSurfacePadding * 2),
                horizontalArrangement = Arrangement.SpaceBetween
            ) { //?????????????? ???????????????? ????????????????????
                Text(
                    text = "????????????",
                    color = Color.Gray
                )
                Text(
                    text = "??????",
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )
                Text(
                    text = if (exercise.typeOfExercise) "????????????????????" else "??????????",
                    textAlign = TextAlign.End,
                    color = Color.Gray
                )
            }
            if (isExpanded)
                for (i in exercise.approaches.indices) {
                    ApproacheTemplate(numOfApproache = i + 1, approache = exercise.approaches[i])
                }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(surfacePadding)
                    .height(BTN_HEIGHT_LONG),
                colors = ButtonDefaults.buttonColors(SportBlue),
                shape = Shapes.medium,
                onClick = {
                    val intent = Intent(context, TrainingActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.putExtra("exerciseName", exercise.name)
                    context.startActivity(intent)
                }) {
                Text(text = "????????????")
            }

        }
    }
}

@Composable
fun myForm(enterString: String) {
    var text: String = enterString
    BasicTextField(
        value = text,
        onValueChange = { newText -> text = newText },
        Modifier
            .padding(vertical = 6.dp)
            .width(64.dp)
    )
}

@Composable
@Preview(showBackground = true)
fun myFormPreview() {
    myForm(enterString = "Hello")
}

fun getCardHeight(approachCount: Int): Dp {
    return surfacePadding / 2 * approachCount + (56 * approachCount).dp + inSurfacePadding * 2 + 50.dp + surfacePadding * 2 + BTN_HEIGHT_LONG
}