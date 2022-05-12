import androidx.room.*
import com.example.gymnote.Exercise

@Dao
interface ExerciseDao {
    @Insert
    fun insert(vararg exercises: Exercise)

    @Delete
    fun delete(exercise: Exercise)

    @Query(value = "DELETE FROM exercises_and_approaches WHERE name = :nameOfExercise")
    fun delete(nameOfExercise: String)

    @Update
    fun updateExersices(vararg exercises: Exercise)

    @Query(value = "SELECT * FROM exercises_and_approaches WHERE name = :nameOfExercise ")
    fun getExercise(nameOfExercise: String): List<Exercise>
}