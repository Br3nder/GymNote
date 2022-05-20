package com.example.gymnote.activities

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymnote.*
import com.example.gymnote.ui.theme.GymNoteTheme
import com.example.gymnote.ui.theme.Shapes
import com.example.gymnote.ui.theme.SportBlue

class TrainingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymNoteTheme {
               // val exerciseName: String = intent?.extras?.getString("exerciseName").toString()
               // header(exerciseName = exerciseName, context = this)
                val Header: String = intent?.extras?.getString("Header").toString()
                com.example.gymnote.TopAppBar(Header = Header)
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 54.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    contentPadding = PaddingValues(bottom = 32.dp)
                ) {
                    item {
                        approachesTitle()
                    }
                    var i = 1
                    items(exercises[0].approaches) { item ->
                        approach(numOfApproache = i, approache = item)
                        i++
                    }
                    item{
                        Row(){
                            Button(
                                modifier = Modifier
                                    .padding(top = surfacePadding, end = surfacePadding / 2)
                                    .height(BTN_HEIGHT_LONG)
                                    .fillMaxWidth(0.6f),
                                colors = ButtonDefaults.buttonColors(SportBlue),
                                shape = Shapes.medium,
                                onClick = {
                                    //TODO *click*
                                }) {
                                Text(text = "Завершить")
                            }
                            Button( modifier = Modifier
                                .padding(top = surfacePadding, start = surfacePadding / 2)
                                .height(BTN_HEIGHT_LONG)
                                .fillMaxWidth(0.4f),
                                colors = ButtonDefaults.buttonColors(SportBlue),
                                shape = Shapes.medium,
                                onClick = {
                                    //TODO *click*
                                }) {
                                Icon(Icons.Rounded.Add, contentDescription = "Add approach")
                            }
                        }
                    }
                }
            }
        }
    }
}

/*@Composable
fun header(exerciseName: String, context: Context) {
    TopAppBar(
        contentPadding = PaddingValues(start = 20.dp),
        backgroundColor = Color.White,
        modifier = Modifier.height(54.dp)

    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 8.dp)
        ) {
            Text(
                text = exerciseName,
                fontWeight = FontWeight.Black,
                fontSize = 26.sp,
                color = SportBlue
            )
            IconButton(onClick = {
                showAlletrDialog(context = context)
            }) {
                Icon(
                    Icons.Rounded.Close,
                    contentDescription = "close exercise",
                    tint = Color.Red,
                )
            }
        }
    }
}*/

@Composable
@Preview
fun headerPrew(){
    TopAppBar("Ah")
}

@Composable
@Preview
fun approachesTitle() {
    Row(
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 24.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Подход",
            color = Color.Gray
        )
        Text(
            text = "Вес",
            color = Color.Gray
        )
        Text(
            text = "Повторения",
            color = Color.Gray
        )
    }
}

@Composable
fun approach(numOfApproache: Int, approache: Approache) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, start = 24.dp * 2 - 3.dp, end = 24.dp + 3.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = numOfApproache.toString(),
            modifier = Modifier.padding(end = 13.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            modifier = Modifier.width(70.dp),
            value = approache.weight.toString(),
            onValueChange = {})
        OutlinedTextField(
            modifier = Modifier.width(70.dp),
            value = approache.repeats.toString(),
            onValueChange = {})
    }
}

@Composable
@Preview
fun approachPreview() {
    approach(numOfApproache = 1, approache = a1[0])
}

fun showAlletrDialog(context: Context) {
    val listener = DialogInterface.OnClickListener { _, which ->
        when (which) {
            DialogInterface.BUTTON_POSITIVE -> {
                //TODO сделать не открытие, а закрытие действующего активити
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    val dialog = AlertDialog.Builder(context)
        .setTitle("Отменить выполнение упражнения?")
        .setMessage("Все новые записанные результаты будут утеряны")
        .setPositiveButton("Yes", listener)
        .create()

    dialog.show()
}

@Composable
fun ApproachesList(approaches: List<Approache>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 54.dp)
    ) {

    }
}
