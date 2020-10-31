package ch.protonmail.android.protonmailtest.ui.forecast.repository

import ch.protonmail.android.protonmailtest.models.GetUpcomingDayListResponseItem

interface RepositoryForecast {
    suspend fun getUpcomingDayList() : List<GetUpcomingDayListResponseItem>?
    suspend fun dataPresentInLocalStorage() : Boolean
    suspend fun getDataFromLocalStorage() : List<GetUpcomingDayListResponseItem>?
    suspend fun addDataToLocalStorage(data  : List<GetUpcomingDayListResponseItem>)
}