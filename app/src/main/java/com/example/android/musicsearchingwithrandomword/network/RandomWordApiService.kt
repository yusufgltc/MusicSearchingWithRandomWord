package com.example.android.musicsearchingwithrandomword.network

import com.example.android.musicsearchingwithrandomword.network.models.RandomWord
import retrofit2.http.GET


interface RandomWordApiService {
    @GET("word")
    suspend fun getRandomWord(): List<RandomWord>
}