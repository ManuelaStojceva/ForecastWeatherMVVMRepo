package ch.protonmail.android.protonmailtest.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ch.protonmail.android.protonmailtest.models.GetLessRainingOrderedDaysResponseItem

@Dao
interface HottestDao {
    @Query("SELECT * FROM Hottest")
    fun getLessRainingOrderedDays(): List<GetLessRainingOrderedDaysResponseItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addLessRainingOrderedDays(data: List<GetLessRainingOrderedDaysResponseItem>)
}