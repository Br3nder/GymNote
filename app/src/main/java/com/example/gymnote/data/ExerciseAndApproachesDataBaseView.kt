import androidx.room.*

@DatabaseView()
data class ExerciseAndApproachesDataBaseView(
    val exerciseName: String,
    val typeOfExercise: Boolean,
    val weight: Int,
    val units: Int,
    val serialNumber: Int
)