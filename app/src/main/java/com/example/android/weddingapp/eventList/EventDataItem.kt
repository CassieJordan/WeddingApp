package com.example.android.weddingapp.eventList

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events_table")
data class EventDataItem(
    @PrimaryKey(autoGenerate = true)
    var eventId: Long = 0L,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "time")
    var time: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "location")
    var location: String)