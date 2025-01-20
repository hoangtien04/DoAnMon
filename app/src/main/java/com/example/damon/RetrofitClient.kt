package com.example.damon

import com.example.damon.APIService.APIService
import com.example.damon.APIService.SanPhamAPIService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{
    val apiService : APIService by lazy {
        Retrofit.Builder()
            .baseUrl("https://270f-2001-ee0-54be-9120-d47d-971-fcd9-7fe5.ngrok-free.app/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(APIService::class.java)
    }
}