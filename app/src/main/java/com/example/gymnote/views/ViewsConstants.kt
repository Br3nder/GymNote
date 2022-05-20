package com.example.gymnote


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
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
import com.example.gymnote.activities.ExercisesList

import com.example.gymnote.activities.showAlletrDialog
import com.example.gymnote.activities.topAppBar
import com.example.gymnote.ui.theme.GymNoteTheme
import com.example.gymnote.ui.theme.SportBlue

val BTN_HEIGHT_LONG = 46.dp
val BTN_HEIGHT_SHORT = 64.dp
val BTN_WIDTH_SHORT = 64.dp



@Composable
fun TopAppBar(Header: String) {
    val context = LocalContext.current
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
                text = Header,
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
}