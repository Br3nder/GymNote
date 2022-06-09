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

    suspend fun getAllEntityes(): MutableList<ExerciseEntity>? {
        return exercisesDataBase.getExerciseDao().getAll()
    }

    suspend fun add(exercise: Exercise){
        exercisesDataBase.getExerciseDao().add(ExerciseEntity.fromExercise(exercise))
    }

    suspend fun update(exerciseEntity: ExerciseEntity){
        exercisesDataBase.getExerciseDao().update(exerciseEntity)
    }

}