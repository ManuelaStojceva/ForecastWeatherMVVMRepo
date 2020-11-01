package ch.protonmail.android.protonmailtest.ui.hottest.repository

import ch.protonmail.android.protonmailtest.models.GetLessRainingOrderedDaysResponseItem

interface HottestRepository {
    suspend fun getDaysLessChangeOfRainOrderedByHottest() : List<GetLessRainingOrderedDaysResponseItem>?
    suspend fun dataPresentInLocalStorageOrderedAndLessRaining() : Boolean
    suspend fun getLessRainingOrderedDaysFromLocalStorage() : List<GetLessRainingOrderedDaysResponseItem>?
    suspend fun addLessRainingOrderedDays(data  : List<GetLessRainingOrderedDaysResponseItem>)
}