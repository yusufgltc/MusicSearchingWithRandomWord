package com.example.android.musicsearchingwithrandomword.network

import com.example.android.musicsearchingwithrandomword.util.Constant.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object RandomWordApi {
    val retrofitService: RandomWordApiService by lazy {
        retrofit.create(RandomWordApiService::class.java)
    }
}