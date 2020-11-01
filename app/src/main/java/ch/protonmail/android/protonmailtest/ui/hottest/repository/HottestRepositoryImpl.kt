package ch.protonmail.android.protonmailtest.ui.hottest.repository

import ch.protonmail.android.protonmailtest.api.ApiService
import ch.protonmail.android.protonmailtest.api.SafeApiRequest
import ch.protonmail.android.protonmailtest.db.HottestDao
import ch.protonmail.android.protonmailtest.models.GetLessRainingOrderedDaysResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/*
  repository class to handle hottest network and local storage data
 */
class HottestRepositoryImpl(
    private val apiService: ApiService,
    private val dao: HottestDao
) : HottestRepository, SafeApiRequest() {
    override suspend fun getDaysLessChangeOfRainOrderedByHottest(): List<GetLessRainingOrderedDaysResponseItem>? {
        if(dataPresentInLocalStorageOrderedAndLessRaining()){
            return getLessRainingOrderedDaysFromLocalStorage()
        }
        val response = safeApiCall(
            call = {apiService.getDayList()},
            error = "Error fetching Data"
        )?.filter { it.chance_rain!! < 0.5 }?.sortedByDescending {
            it.high
        }
        if(!response.isNullOrEmpty()) addLessRainingOrderedDays(response)

        return response
    }

    override suspend fun dataPresentInLocalStorageOrderedAndLessRaining(): Boolean {
        val data = getLessRainingOrderedDaysFromLocalStorage()
        if (data.isNullOrEmpty()){
            return false
        }
        return true
    }

    override suspend fun getLessRainingOrderedDaysFromLocalStorage(): List<GetLessRainingOrderedDaysResponseItem>? {
        return withContext(Dispatchers.IO) {
            dao.getLessRainingOrderedDays()
        }
    }

    override suspend fun addLessRainingOrderedDays(data: List<GetLessRainingOrderedDaysResponseItem>) {
        withContext(Dispatchers.IO) { dao.addLessRainingOrderedDays(data) }
    }
}