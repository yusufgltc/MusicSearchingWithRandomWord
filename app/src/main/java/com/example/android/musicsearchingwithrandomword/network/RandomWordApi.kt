package com.example.android.musicsearchingwithrandomword.network

import com.example.android.musicsearchingwithrandomword.util.Constant.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * Moshi is a modern JSON library for Android, Java and Kotlin.
 * It makes it easy to parse JSON into Java and Kotlin classes.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Building a retrofit object
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object RandomWordApi {
    val retrofitService: RandomWordApiService by lazy {
        retrofit.create(RandomWordApiService::class.java)
    }
}