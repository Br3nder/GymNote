package com.example.gymnote.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gymnote.room.ExercisesDao
import java.lang.IllegalArgumentException

class ExerciseViewModelFactory(
    private val exercisesDao: ExercisesDao
    ): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ExercisesViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ExercisesViewModel(exercisesDao) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }

    }