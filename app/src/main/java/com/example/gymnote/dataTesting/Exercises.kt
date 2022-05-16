package com.example.gymnote

val a1: List<Approache> = listOf(
    Approache(80, 12),
    Approache(120, 10)
)

val a2: List<Approache> = listOf(
    Approache(80, 12),
    Approache(120, 10),
    Approache(15, 100),
    Approache(15, 100),
    Approache(15, 100)
)

val a3: List<Approache> = listOf(
    Approache(80, 12)
)

val a4: List<Approache> = listOf(
    Approache(80, 12),
    Approache(120, 10),
    Approache(15, 100),
    Approache(15, 100),
    Approache(15, 100),
    Approache(80, 12),
    Approache(120, 10),
    Approache(15, 100),
    Approache(15, 100),
    Approache(15, 100)
)

val e1 = Exercise(name = "Chest press", typeOfExercise = true, approaches = a1)
val e2 = Exercise(name = "Pull-ups", typeOfExercise = true, approaches = a2)
val e3 = Exercise(name = "Barbell", typeOfExercise = true, approaches = a3)
val e4 = Exercise(name = "Push-ups", typeOfExercise = true, approaches = a4)

val exercises: List<Exercise> = listOf(e1, e2, e3, e4)