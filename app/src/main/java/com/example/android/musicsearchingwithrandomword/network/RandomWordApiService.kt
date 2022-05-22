package com.example.android.musicsearchingwithrandomword.network

import com.example.android.musicsearchingwithrandomword.network.models.RandomWord
import retrofit2.http.GET

/**
 * A public interface that exposes the [getRandomWord] method
 */
interface RandomWordApiService {
    /**
     * Returns a Coroutine [List] of [RandomWord] which can be fetched in a Coroutine scope.
     * The @GET annotation indicates that the "word" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("word")
    suspend fun getRandomWord(): List<RandomWord>
}