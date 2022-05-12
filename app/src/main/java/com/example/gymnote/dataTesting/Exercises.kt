package com.example.gymnote

val a: List<Approache> = listOf(
    Approache(80, 12),
    Approache(120, 10),
    Approache(15, 100)
)
val e1 = Exercise(name = "Chest press", typeOfExercise = true, approaches = a)
val e2 = Exercise(name = "Pull-ups", typeOfExercise = true, approaches = a)
val e3 = Exercise(name = "Barbell", typeOfExercise = true, approaches = a)

val exercises: List<Exercise> = listOf(e1, e2, e3)