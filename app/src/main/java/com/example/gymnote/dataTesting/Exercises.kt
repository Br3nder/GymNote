package com.example.gymnote

var a1: MutableList<Approache> = mutableListOf(
    Approache(80, 12),
    Approache(120, 10)
)

val a2: MutableList<Approache> = mutableListOf(
    Approache(80, 12),
    Approache(120, 10),
    Approache(15, 100),
    Approache(15, 100),
    Approache(15, 100)
)

val a3: MutableList<Approache> = mutableListOf(
    Approache(80, 12)
)

val a4: MutableList<Approache> = mutableListOf(
    Approache(80, 12),
    Approache(100, 10),
    Approache(15, 100),
    Approache(16, 100),
    Approache(15, 100),
)

var e1 = Exercise(name = "Chest press", typeOfExercise = true, approaches = a1)
val e2 = Exercise(name = "Pull-ups", typeOfExercise = true, approaches = a2)
val e3 = Exercise(name = "Barbell", typeOfExercise = true, approaches = a3)
val e4 = Exercise(name = "Push-ups", typeOfExercise = true, approaches = a4)

var exercises: MutableList<Exercise> = mutableListOf(e1, e2, e3, e4)