package com.example.android.musicsearchingwithrandomword.presenter.numberpicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.musicsearchingwithrandomword.databinding.FragmentNumberPickerBinding
import com.example.android.musicsearchingwithrandomword.util.Constant.MAX_VALUE_NUMBER_PICKER
import com.example.android.musicsearchingwithrandomword.util.Constant.MIN_VALUE_NUMBER_PICKER

class NumberPickerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNumberPickerBinding.inflate(inflater)

        binding.apply {
            numberPicker.minValue = MIN_VALUE_NUMBER_PICKER
            numberPicker.maxValue = MAX_VALUE_NUMBER_PICKER
            numberPicker.wrapSelectorWheel = true
        }

        // Set number picker value changed listener
        binding.numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            //Display the newly selected number to text view
            binding.textViewPickerNumber.text = "Selected Value : $newVal"
        }

        binding.button.setOnClickListener {
            view?.findNavController()
                ?.navigate(
                    NumberPickerFragmentDirections
                        .actionNumberPickerFragmentToOverviewFragment(binding.numberPicker.value)
                )
        }
        return binding.root
    }

}