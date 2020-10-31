package ch.protonmail.android.protonmailtest.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Forecast")
@Parcelize
data class GetUpcomingDayListResponseItem(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val chance_rain: Double?,
    val day: String?,
    val description: String?,
    val high: Int?,
    val image: String?,
    val low: Int?,
    val sunrise: Int?,
    val sunset: Int?
) : Parcelable