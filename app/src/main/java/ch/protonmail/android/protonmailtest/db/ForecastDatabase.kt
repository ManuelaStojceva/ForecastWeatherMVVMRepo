package ch.protonmail.android.protonmailtest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ch.protonmail.android.protonmailtest.models.GetUpcomingDayListResponseItem

@Database(
    entities = [GetUpcomingDayListResponseItem::class],
    version = 1, exportSchema = false
)
abstract class ForecastDatabase : RoomDatabase(){
    abstract val forecastDao: ForecastDao
}