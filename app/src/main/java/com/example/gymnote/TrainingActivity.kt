package com.example.gymnote

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymnote.ui.theme.GymNoteTheme

class TrainingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymNoteTheme {
                val exerciseName: String = intent?.extras?.getString("exerciseName").toString()
                header(exerciseName = exerciseName, context = this)
            }
        }
    }
}

@Composable
fun header(exerciseName: String, context: Context) {
    TopAppBar(
        contentPadding = PaddingValues(start = 20.dp),
        backgroundColor = Color.White,

        ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 8.dp)){
            Text(
                text = exerciseName,
                fontWeight = FontWeight.Black,
                fontSize = 26.sp,
                color = Color.Blue
            )
            IconButton(onClick = {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            }) {
                Icon(
                    Icons.Rounded.Close,
                    contentDescription = "close exercise",
                    tint = Color.Red,
                )
            }
        }
    }
}

@Composable
fun ApproachesList(approaches: List<Approache>){
    LazyColumn(modifier = Modifier.fillMaxSize().padding(top = 54.dp)){

    }
}