package com.example.android.musicsearchingwithrandomword.presenter.overview

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android.musicsearchingwithrandomword.network.models.RandomWord
import com.example.android.musicsearchingwithrandomword.network.RandomWordApi
import kotlinx.coroutines.launch
import javax.inject.Inject

class OverviewViewModel @Inject constructor(
    selectedNumber: Int,
    app: Application
) : AndroidViewModel(app) {

    enum class RandomWordApiStatus { LOADING, ERROR, DONE }

    private val _status = MutableLiveData<RandomWordApiStatus>()
    val status: LiveData<RandomWordApiStatus>
        get() = _status

    private val _randomWord = MutableLiveData<List<RandomWord>>()
    val randomWord: LiveData<List<RandomWord>>
        get() = _randomWord


    /**
     * Call getRandomWordFromAPI() on init so we can display status immediately.
     */
    init {
        getRandomWordFromAPI(selectedNumber)
    }

    /**
     * Sets the value of the status LiveData to the RandomWord API status.
     */
    fun getRandomWordFromAPI(selectedNum: Int) {

        viewModelScope.launch {
            _status.value = RandomWordApiStatus.LOADING
            try {
                for (i in 1..selectedNum) {
                    _randomWord.value = RandomWordApi.retrofitService.getRandomWord()
                }
                _status.value = RandomWordApiStatus.DONE
            } catch (e: Exception) {
                Log.e("error",e.toString())
                _status.value = RandomWordApiStatus.ERROR
            }
        }
    }

}