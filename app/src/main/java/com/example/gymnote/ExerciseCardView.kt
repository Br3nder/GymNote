package com.example.gymnote

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ExerciseCard(exerciseName: String, typeOfExercise: Boolean){ // false - повторения, true - время
    Row {
        Text(text = exerciseName)
        Icon(Icons.Rounded.ArrowDropDown,
            contentDescription = "Show more about exercise",
            modifier = Modifier.wrapContentWidth(Alignment.End, unbounded = false))
    }
    Row {
        // exercise more inf
    }

}

@Preview
@Composable
fun ExerciseCardPreview(){
    ExerciseCard(exerciseName = "Chest press", typeOfExercise = false)
}