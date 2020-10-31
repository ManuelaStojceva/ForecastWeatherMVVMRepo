package ch.protonmail.android.protonmailtest.models

data class GetUpcomingDayListResponseItem(
    val chance_rain: Double?,
    val day: String?,
    val description: String?,
    val high: Int?,
    val image: String?,
    val low: Int?,
    val sunrise: Int?,
    val sunset: Int?
)