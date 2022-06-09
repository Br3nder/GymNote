package com.example.gymnote.room

import com.example.gymnote.Exercise

class Repository(val exercisesDataBase: ExercisesDataBase) {
    suspend fun getAll(): MutableList<Exercise> {
        var exercisesEntitys = exercisesDataBase.getExerciseDao().getAll()
        var exercises = mutableListOf<Exercise>()
        if(exercisesEntitys != null)
            for (i in exercisesEntitys.indices)
                exercises.add(exercisesEntitys[i].toExercise())
        return exercises
    }

    suspend fun add(exercise: Exercise){
        exercisesDataBase.getExerciseDao().add(ExerciseEntity.fromExercise(exercise))
    }
}