package ch.protonmail.android.protonmailtest.interfaces

import ch.protonmail.android.protonmailtest.models.GetUpcomingDayListResponseItem

interface ForecastDataInterface {
    fun onItemClick(data : GetUpcomingDayListResponseItem)
}