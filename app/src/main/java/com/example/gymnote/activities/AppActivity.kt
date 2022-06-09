package com.example.gymnote

import android.app.Application
import androidx.room.Room
import com.example.gymnote.room.ExercisesDataBase

class App : Application() {

    private lateinit var database: ExercisesDataBase

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, ExercisesDataBase::class.java, "exercises")
            .build()
    }

    fun getDatabase(): ExercisesDataBase {
        return database
    }

    companion object {
        var instance: App? = null
    }
}