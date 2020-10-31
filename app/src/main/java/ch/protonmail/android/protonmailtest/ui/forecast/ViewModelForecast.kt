package ch.protonmail.android.protonmailtest.ui.forecast

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ch.protonmail.android.protonmailtest.api.NoInternetException
import ch.protonmail.android.protonmailtest.models.GetUpcomingDayListResponseItem
import ch.protonmail.android.protonmailtest.ui.forecast.repository.RepositoryForecast
import kotlinx.coroutines.launch

class ViewModelForecast(private val repository: RepositoryForecast) :ViewModel(){

    private var _upcomingDayList : MutableLiveData<List<GetUpcomingDayListResponseItem>> = MutableLiveData()
    val upcomingDayList : LiveData<List<GetUpcomingDayListResponseItem>> = _upcomingDayList
    private var _errorMessage : MutableLiveData<String> = MutableLiveData()
    val errorMessage : LiveData<String> = _errorMessage

    //detail view data
    private var _upcomingDayDetail : MutableLiveData<GetUpcomingDayListResponseItem> = MutableLiveData()
    val upcomingDayDetail : LiveData<GetUpcomingDayListResponseItem> = _upcomingDayDetail

    fun setDetailData(data : GetUpcomingDayListResponseItem){
        _upcomingDayDetail.value = data
    }

    fun getUpcomingDayList(){
        viewModelScope.launch {
            try {
                val response = repository.getUpcomingDayList()
                response?.let {list->
                    if(list.isNotEmpty()) {
                        _upcomingDayList.value = list
                    }
                }
            }catch (e : NoInternetException){
                _errorMessage.value = e.message
            }
        }
    }
}