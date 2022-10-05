package com.example.android.weddingapp.eventList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.android.weddingapp.R
import com.example.android.weddingapp.data.EventDataBase
import com.example.android.weddingapp.databinding.FragmentEventListBinding

class EventListFragment : Fragment() {

    private lateinit var viewModel: EventListViewModel

    private lateinit var binding: FragmentEventListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_event_list, container, false)

        val adapter = EventListAdapter()
        val application = requireNotNull(this.activity).application
        val dataSource = EventDataBase.getInstance(application).dao
        val factory = EventListViewModelFactory(dataSource, application)

        viewModel = ViewModelProvider(this, factory).get(EventListViewModel::class.java)
        binding.viewModel = viewModel
        binding.eventList.adapter = adapter
        binding.lifecycleOwner = this
        viewModel.eventList.observe(viewLifecycleOwner, Observer {
            it?.let{
                adapter.list = it
            }
        })
        return binding.root
    }

}