package ch.protonmail.android.protonmailtest.interfaces

import ch.protonmail.android.protonmailtest.models.GetUpcomingDayListResponseItem

/*
 interface to handle on forecast item clicked
 */
interface ForecastDataInterface {
    fun onItemClick(data : GetUpcomingDayListResponseItem)
}