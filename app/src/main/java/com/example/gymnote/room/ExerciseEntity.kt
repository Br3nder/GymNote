package com.example.gymnote.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.gymnote.Approache
import com.example.gymnote.Exercise

@Entity(
    tableName = "exercises")
class ExerciseEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(collate = ColumnInfo.NOCASE) val name: String, //не чувствителен к регистру
    val type: Boolean,
    var approaches: MutableList<Approache>?){

    fun toExercise(): Exercise = Exercise(
        name = name,
        typeOfExercise = type,
        approaches = approaches)

    companion object {
        fun fromExercise(exercise: Exercise): ExerciseEntity = ExerciseEntity(
            id = 0,
            name = exercise.name,
            type = exercise.typeOfExercise,
            approaches = exercise.approaches
        )
    }
}