package com.example.gymnote

import android.app.Application
import com.example.gymnote.room.ExercisesDataBase

class ExercisesApplication: Application() {
    val database: ExercisesDataBase by lazy { ExercisesDataBase.getDatabase(this) }
}