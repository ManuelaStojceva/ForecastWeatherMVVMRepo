package ch.protonmail.android.protonmailtest.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ch.protonmail.android.protonmailtest.models.GetUpcomingDayListResponseItem

@Dao
interface ForecastDao {
    @Query("SELECT * FROM Forecast")
    fun getUpcomingDays(): List<GetUpcomingDayListResponseItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(data: List<GetUpcomingDayListResponseItem>)
}