package com.example.gymnote

import kotlinx.serialization.Serializable

@Serializable
data class Approache(val weight: Int = 0, val units: Int = 0)

data class Exercise(var name: String,val typeOfExercise: Boolean,var approaches: MutableList<Approache>?)