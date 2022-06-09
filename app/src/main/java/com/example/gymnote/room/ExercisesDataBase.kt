package com.example.gymnote.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.gymnote.room.converters.ApproachesConverter

@Database(
    version = 1,
    entities = [
        ExerciseEntity::class
    ],
    exportSchema = false
)
@TypeConverters(ApproachesConverter::class)
abstract class ExercisesDataBase: RoomDatabase() {
    abstract fun getExerciseDao(): ExercisesDao
    companion object {
        @Volatile
        private var INSTANCE: ExercisesDataBase? = null

        fun getDatabase(context: Context): ExercisesDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ExercisesDataBase::class.java,
                    "app_database")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}


