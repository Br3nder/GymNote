import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises_and_approaches")
data class ExerciseAndApproaches(
    @PrimaryKey @ColumnInfo(name = "name") val exerciseName: String,
    @ColumnInfo(name = "type") val typeOfExercise: Boolean,
    @ColumnInfo(name = "weight") val weight: Int,
    @ColumnInfo(name = "units") val units: Int,
    @ColumnInfo(name = "serial_number_in_exercise") val serialNumber: Int
)