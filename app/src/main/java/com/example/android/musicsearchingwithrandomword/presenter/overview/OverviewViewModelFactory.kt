package com.example.android.musicsearchingwithrandomword.presenter.overview

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Overview view model factory
 * Simple ViewModel factory that provides the selectedNum and context to the ViewModel.
 * @property selectedNumber comes with args
 * @property application
 * @constructor Create empty Overview view model factory
 */
class OverviewViewModelFactory(
    private val selectedNumber: Int,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OverviewViewModel::class.java)) {
            return OverviewViewModel(selectedNumber, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}