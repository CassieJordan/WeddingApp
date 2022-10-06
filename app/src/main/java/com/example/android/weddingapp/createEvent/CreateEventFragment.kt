package com.example.android.weddingapp.createEvent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.weddingapp.R
import com.example.android.weddingapp.databinding.FragmentCreateEventBinding
import com.example.android.weddingapp.eventList.EventListViewModel


class CreateEventFragment : Fragment() {
    private lateinit var viewModel: EventListViewModel

    private lateinit var binding: FragmentCreateEventBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_create_event, container, false)

        return binding.root
    }

}