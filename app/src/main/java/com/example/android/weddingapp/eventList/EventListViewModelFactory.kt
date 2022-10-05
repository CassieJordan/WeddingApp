package com.example.android.weddingapp.eventList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.weddingapp.data.EventDataBaseDao

class EventListViewModelFactory(val dataBase: EventDataBaseDao, val application: Application):
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EventListViewModel::class.java)){
            return EventListViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}