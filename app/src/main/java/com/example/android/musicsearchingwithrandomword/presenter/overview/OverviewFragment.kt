package com.example.android.musicsearchingwithrandomword.presenter.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.musicsearchingwithrandomword.databinding.FragmentOverviewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OverviewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        @Suppress("UNUSED_VARIABLE")
        binding.lifecycleOwner = this
        val args = OverviewFragmentArgs.fromBundle(requireArguments()).selectedNum
        val application = requireNotNull(activity).application
        // Giving the binding access to the OverviewViewModel
        val viewModelFactory =
            OverviewViewModelFactory(
                selectedNumber = args,
                application = application
            )

        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(OverviewViewModel::class.java)

        binding.recyclerView.adapter = RandomWordLinearAdapter()


        return binding.root
    }

}