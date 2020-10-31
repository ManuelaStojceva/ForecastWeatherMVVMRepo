package ch.protonmail.android.protonmailtest.api
import ch.protonmail.android.protonmailtest.models.GetUpcomingDayListResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    //fetches upcoming list of days
    @Headers("Content-Type: application/json")
    @GET("forecast")
    suspend fun getUpcomingDayList(): Response<GetUpcomingDayListResponse>
}