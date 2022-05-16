package com.example.gymnote

data class Approache(val weight: Int, val repeats: Int){}
data class Exercise(val name: String,val typeOfExercise: Boolean,val approaches: List<Approache>){}