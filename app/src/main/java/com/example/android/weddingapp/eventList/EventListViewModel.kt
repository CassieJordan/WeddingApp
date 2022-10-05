package com.example.android.weddingapp.eventList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.weddingapp.data.EventDataBase
import com.example.android.weddingapp.data.EventDataBaseDao
import com.example.android.weddingapp.data.EventRepository
import kotlinx.coroutines.launch

class EventListViewModel(application: Application) :
    AndroidViewModel(application) {
    private val repo = EventRepository(EventDataBase.getInstance(application).dao)
    val eventList = MutableLiveData<List<EventDataItem>>()

    init {
        getEvents()
    }

    private fun getEvents() {
        viewModelScope.launch {
            val result = repo.getEvents()

            eventList.value = result
        }
    }


}