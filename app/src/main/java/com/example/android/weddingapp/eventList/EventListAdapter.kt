package com.example.android.weddingapp.eventList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.weddingapp.databinding.ListItemEventBinding

class EventListAdapter: RecyclerView.Adapter<EventListAdapter.ViewHolder>()  {

    var list = listOf<EventDataItem>()

    class ViewHolder private constructor(private val binding: ListItemEventBinding):
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemEventBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
        fun bind(event: EventDataItem) {
            binding.event = event
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = list[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}