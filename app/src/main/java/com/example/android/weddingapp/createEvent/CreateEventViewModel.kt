package com.example.android.weddingapp.createEvent

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.weddingapp.data.EventDataBase
import com.example.android.weddingapp.data.EventRepository
import com.example.android.weddingapp.eventList.EventDataItem
import kotlinx.coroutines.launch

class CreateEventViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = EventRepository(EventDataBase.getInstance(application).dao)
    val TAG = this.javaClass.simpleName
    fun saveEvent(event: EventDataItem?) {
        if (event != null) {
            viewModelScope.launch { repo.saveEvent(event) }
        }
        else {
            Log.e(TAG, "saveEvent: event to be saved was null")
        }
    }

}