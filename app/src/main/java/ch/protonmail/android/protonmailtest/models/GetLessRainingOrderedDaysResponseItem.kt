package ch.protonmail.android.protonmailtest.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Hottest")
@Parcelize
data class GetLessRainingOrderedDaysResponseItem (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val chance_rain: Float?,
    val day: String?,
    val description: String?,
    val high: Int?,
    val image: String?,
    val low: Int?,
    val sunrise: Long?,
    val sunset: Long?
) : Parcelable