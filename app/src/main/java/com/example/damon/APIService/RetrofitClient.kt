package com.example.damon.APIService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://6715-2001-ee0-54be-f10-a456-86d7-9dc-9487.ngrok-free.app/"

    val apiService: SanPhamAPIService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SanPhamAPIService::class.java)


}

