package ch.protonmail.android.protonmailtest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ch.protonmail.android.protonmailtest.models.GetLessRainingOrderedDaysResponseItem

@Database(
    entities = [GetLessRainingOrderedDaysResponseItem::class],
    version = 1, exportSchema = false
)
abstract class HottestDatabase: RoomDatabase() {
    abstract val hottestDao: HottestDao
}