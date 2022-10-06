package com.example.android.weddingapp.createEvent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android.weddingapp.R
import com.example.android.weddingapp.databinding.FragmentCreateEventBinding
import com.example.android.weddingapp.eventList.EventDataItem
import com.example.android.weddingapp.eventList.EventListViewModel


class CreateEventFragment : Fragment() {

    private lateinit var binding: FragmentCreateEventBinding

    private lateinit var viewModel: CreateEventViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(CreateEventViewModel::class.java)

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_create_event, container, false)
        val event = binding.event
        binding.saveButton.setOnClickListener{

            if (validate(event)){
                viewModel.saveEvent(event)
                Toast.makeText(activity, "Event saved!", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

    private fun validate(event: EventDataItem?): Boolean {

        if (event == null || event.description.isNullOrEmpty() || event.time.isNullOrEmpty() ||
            event.title.isNullOrEmpty() || event.location.isNullOrEmpty()) {
            Toast.makeText(activity, "Fill out all fields to create an event", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

}