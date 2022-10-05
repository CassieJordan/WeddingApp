package com.example.android.weddingapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android.weddingapp.eventList.EventDataItem

@Dao
interface EventDataBaseDao {

    @Insert
    fun saveEvent(event: EventDataItem)

    @Query("SELECT * FROM events_table")
    fun getEvents(): LiveData<List<EventDataItem>>

    @Query("SELECT * FROM events_table where eventId = :key")
    fun getEventById(key: Long): EventDataItem

    @Query("DELETE FROM events_table")
    fun clear()
}