package com.example.android.weddingapp.createEvent

import android.app.Application
import com.example.android.weddingapp.data.EventDataBase
import com.example.android.weddingapp.data.EventRepository
import com.example.android.weddingapp.eventList.EventDataItem

class CreateEventViewModel(
    application: Application,
    val title: String,
    val description: String,
    val time: String,
    val location: String
) {
    private val repo = EventRepository(EventDataBase.getInstance(application).dao)

    suspend fun saveEvent(event: EventDataItem) {
        repo.saveEvent(event)
    }

}