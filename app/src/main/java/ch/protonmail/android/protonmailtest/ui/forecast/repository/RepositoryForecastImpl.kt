package ch.protonmail.android.protonmailtest.ui.forecast.repository

import ch.protonmail.android.protonmailtest.api.ApiService
import ch.protonmail.android.protonmailtest.api.SafeApiRequest
import ch.protonmail.android.protonmailtest.db.ForecastDao
import ch.protonmail.android.protonmailtest.models.GetUpcomingDayListResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryForecastImpl(
    private val apiService: ApiService,
    private val dao: ForecastDao
) : RepositoryForecast, SafeApiRequest() {
    override suspend fun getUpcomingDayList(): List<GetUpcomingDayListResponseItem>? {
        if(dataPresentInLocalStorage()){
            return getDataFromLocalStorage()
        }
        val response = safeApiCall(
            call = {apiService.getUpcomingDayList()},
            error = "Error fetching Data"
        )
        if(!response.isNullOrEmpty())
            addDataToLocalStorage(response)
        return response
    }

    override suspend fun dataPresentInLocalStorage(): Boolean {
        val data = getDataFromLocalStorage()
         if (data.isNullOrEmpty()){
            return false
        }
        return true
    }

    override suspend fun getDataFromLocalStorage(): List<GetUpcomingDayListResponseItem>? {
        return withContext(Dispatchers.IO) {
            dao.getUpcomingDays()
        }
    }

    override suspend fun addDataToLocalStorage(data: List<GetUpcomingDayListResponseItem>) {
        withContext(Dispatchers.IO) { dao.add(data) }
    }
}