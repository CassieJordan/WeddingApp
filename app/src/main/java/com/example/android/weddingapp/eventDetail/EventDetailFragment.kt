package com.example.android.weddingapp.eventDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.weddingapp.databinding.FragmentEventDetailBinding
import com.example.android.weddingapp.eventList.EventDataItem


class EventDetailFragment : Fragment() {

    private lateinit var event: EventDataItem
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEventDetailBinding.inflate(inflater)
        binding.event = event // not initialized yet

        return binding.root
    }

}