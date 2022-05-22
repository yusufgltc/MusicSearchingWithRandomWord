package com.example.android.musicsearchingwithrandomword.presenter.overview

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

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