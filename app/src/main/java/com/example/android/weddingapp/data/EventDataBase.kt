package com.example.android.weddingapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.weddingapp.eventList.EventDataItem


@Database(entities = [EventDataItem::class], version = 1, exportSchema = false)
abstract class EventDataBase : RoomDatabase() {

    abstract val dao: EventDataBaseDao

    companion object {
        @Volatile
        private var INSTANCE: EventDataBase? = null

        fun getInstance(context: Context): EventDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context, EventDataBase::class.java,
                        "events_table").fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}