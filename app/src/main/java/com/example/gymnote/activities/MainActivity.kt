package com.example.gymnote.activities

import android.content.Context
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymnote.*
import com.example.gymnote.ui.theme.*
import java.util.*


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            GymNoteTheme {

                val context = this
                Column() {
                    topAppBar()
                    calendar(context = context)
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

private val countryList =
    mutableListOf("Пн", "Вт", "Ср", "Чт","Пт","Сб", "Вс")

@Composable
fun calendar(context: Context) {
    Column(
        modifier = Modifier
            .height(70.dp)
            .background(Color.White)

    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxSize(),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            items(countryList) {
                index->
                val colorClick = listOf(SportBlue, Color.White)
                val mutableColor = remember { mutableStateOf(Color.White) }
                val backGroundColor = animateColorAsState(targetValue = mutableColor.value)
                val colorText = remember { mutableStateOf(Color.Gray) }

                val sdf = SimpleDateFormat("EEEE")
                val d = Date()
                val dayOfTheWeek: String = sdf.format(d)
                val puk = Toast.makeText(context,dayOfTheWeek,Toast.LENGTH_SHORT)
                puk.show()

                if (dayOfTheWeek == "Wednesday"){

                }

                TextButton(
                    onClick = {

                            if (mutableColor.value == colorClick[1]){
                                mutableColor.value = colorClick[0]
                                colorText.value = Color.White
                            }
                            else{
                                mutableColor.value = colorClick[1]
                                colorText.value = Color.Gray
                            }








                    },
                    modifier = Modifier
                        .width(55.dp)
                        .height(50.dp)
                        .padding(end = 5.dp),
                    border = null,

                    shape = RoundedCornerShape(size = 200.dp),
                    colors =
                        ButtonDefaults.buttonColors(backgroundColor = backGroundColor.value)



                ){


                    val mutable = remember { mutableStateOf(index) }
                    Text(

                        text = mutable.value,
                        style = TextStyle(
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = colorText.value),
                        modifier = Modifier

                    )
                }


            }

        }
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




