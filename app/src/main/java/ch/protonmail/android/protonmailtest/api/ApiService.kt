package ch.protonmail.android.protonmailtest.api
import ch.protonmail.android.protonmailtest.models.GetUpcomingDayListResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    //fetches upcoming list of days
    @Headers("Content-Type: application/json")
    @GET("forecast")
    suspend fun getUpcomingDayList(): Response<List<GetUpcomingDayListResponseItem>>
}