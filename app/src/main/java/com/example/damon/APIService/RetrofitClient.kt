package com.example.damon.APIService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://270f-2001-ee0-54be-9120-d47d-971-fcd9-7fe5.ngrok-free.app/"

    val apiService: SanPhamAPIService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SanPhamAPIService::class.java)
}

