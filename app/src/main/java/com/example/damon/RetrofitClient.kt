package com.example.damon

import com.example.damon.APIService.APIService
import com.example.damon.APIService.SanPhamAPIService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{
    val apiService : APIService by lazy {
        Retrofit.Builder()
            .baseUrl("https://106d-171-252-189-157.ngrok-free.app/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(APIService::class.java)
    }
}