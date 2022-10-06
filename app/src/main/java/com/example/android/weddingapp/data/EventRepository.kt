package com.example.android.weddingapp.data

import com.example.android.weddingapp.eventList.EventDataItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EventRepository(private val dao: EventDataBaseDao) {


    suspend fun saveEvent(event: EventDataItem) {
        withContext(Dispatchers.IO) {
            dao.saveEvent(event)
        }
    }

    suspend fun getEvents(): List<EventDataItem> = withContext(Dispatchers.IO) {
        return@withContext dao.getEvents().value.orEmpty()
    }

    suspend fun clear() {
        withContext(Dispatchers.IO){
            dao.clear()
        }
    }
}