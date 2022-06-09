package com.example.gymnote.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymnote.App
import com.example.gymnote.Exercise
import com.example.gymnote.room.ExerciseEntity
import com.example.gymnote.room.ExercisesDao
import kotlinx.coroutines.launch

class ExercisesViewModel(private val exercisesDao: ExercisesDao): ViewModel() {
    val db = App.instance?.getDatabase()
    val dbDao = db!!.getExerciseDao()

    fun add(exercise: Exercise){
        viewModelScope.launch {
            dbDao.add(ExerciseEntity(
                id = 0,
                name = exercise.name,
                type = exercise.typeOfExercise,
                approaches = exercise.approaches))
        }
    }

    fun getExerciseName(name: String): String?{
        var returnName: String? = null
        viewModelScope.launch {
            returnName = dbDao.get(name)?.toExercise()?.name
        }
        return returnName
    }

    fun update(exercise: Exercise){
        viewModelScope.launch {
            dbDao.update(ExerciseEntity(id = 0, name = exercise.name, type = exercise.typeOfExercise, approaches = exercise.approaches))
        }
    }
    fun getAllExercises(): MutableList<Exercise>{
        var exercises: MutableList<Exercise> = mutableListOf()
        var dbExercises: List<ExerciseEntity> = listOf()
        viewModelScope.launch {
            dbExercises = dbDao.getAll()!!
        }
        for(i in dbExercises)
            exercises.add(Exercise(name = i.name, typeOfExercise = i.type, i.approaches ))

        return exercises
    }
    fun getCount(): Int {
        var a: Int = 0
        viewModelScope.launch {
            a = dbDao.writeCount()
        }
        return a

    }
}