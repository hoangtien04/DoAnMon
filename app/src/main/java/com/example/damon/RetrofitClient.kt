package com.example.damon

import com.example.damon.APIService.APIService
import com.example.damon.APIService.SanPhamAPIService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{
    val apiService : APIService by lazy {
        Retrofit.Builder()
            .baseUrl("https://6715-2001-ee0-54be-f10-a456-86d7-9dc-9487.ngrok-free.app/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(APIService::class.java)
    }
}