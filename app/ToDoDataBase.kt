import androidx.room.RoomDatabase


@Database(
    entities = [ToDo::Class],
    version = 1
)

abstract class ToDoDataBase : RoomDatabase() {
    abstarct val dao: ToDoDao
}