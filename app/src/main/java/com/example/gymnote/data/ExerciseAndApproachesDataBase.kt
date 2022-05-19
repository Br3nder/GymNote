import androidx.room.*

@Database(entities = [ExerciseAndApproaches::class],
        views = [ExerciseAndApproachesDataBaseView::class], version = 1)
abstract class ExerciseAndApproachesDataBase: RoomDatabase(){
    abstract fun exerciseAndApproachesDao(): ExerciseAndApproachesDao
}