package ch.protonmail.android.protonmailtest.ui.hottest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ch.protonmail.android.protonmailtest.api.NoInternetException
import ch.protonmail.android.protonmailtest.models.GetLessRainingOrderedDaysResponseItem
import ch.protonmail.android.protonmailtest.ui.hottest.repository.HottestRepository
import kotlinx.coroutines.launch

class ViewModelHottest(
    private val repository: HottestRepository
) : ViewModel(){

    private var _hottestDayList : MutableLiveData<List<GetLessRainingOrderedDaysResponseItem>> = MutableLiveData()
    val hottestDayList : LiveData<List<GetLessRainingOrderedDaysResponseItem>> = _hottestDayList
    private var _errorMessage : MutableLiveData<String> = MutableLiveData()
    val errorMessage : LiveData<String> = _errorMessage

    //detail view data
    private var _hottestDayDetail : MutableLiveData<GetLessRainingOrderedDaysResponseItem> = MutableLiveData()
    val hottestDayDetail : LiveData<GetLessRainingOrderedDaysResponseItem> = _hottestDayDetail

    fun setDetailData(data : GetLessRainingOrderedDaysResponseItem){
        _hottestDayDetail.value = data
    }

    fun getDaysLessChangeOfRainOrderedByHottest(){
        viewModelScope.launch {
            try {
                val response = repository.getDaysLessChangeOfRainOrderedByHottest()
                response?.let {list->
                    if(list.isNotEmpty()) {
                        _hottestDayList.value = list
                    }
                }
            }catch (e : NoInternetException){
                _errorMessage.value = e.message
            }
        }
    }
}