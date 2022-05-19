import androidx.room.*
import com.example.gymnote.Exercise

@Dao
interface ExerciseAndApproachesDao {
    @Insert
    suspend fun insert(vararg exercises: Exercise)

    @Delete
    suspend fun delete(exercise: Exercise)

    @Query(value = "DELETE FROM exercises_and_approaches WHERE name = :nameOfExercise")
    suspend fun delete(nameOfExercise: String)

    @Update
    suspend fun updateExerсises(vararg exercises: Exercise)

    @Query(value = "SELECT * FROM exercises_and_approaches WHERE name = :nameOfExercise ")
    suspend fun getExercise(nameOfExercise: String): List<Exercise>
}