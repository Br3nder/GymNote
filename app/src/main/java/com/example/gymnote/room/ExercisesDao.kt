package com.example.gymnote.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ExercisesDao {

    @Query("SELECT * FROM exercises WHERE name = :name")
    suspend fun get(name: String): ExerciseEntity?

    @Query("SELECT * FROM exercises")
    suspend fun getAll(): MutableList<ExerciseEntity>?

    @Update()
    suspend fun update(exerciseEntity: ExerciseEntity)

    @Insert()
    suspend fun add(exerciseEntity: ExerciseEntity)

    @Query("SELECT COUNT(*) FROM exercises")
    suspend fun writeCount(): Int

}