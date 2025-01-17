package com.example.damon.APIService

import com.example.damon.ViewModel.SanPhamViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://106d-171-252-189-157.ngrok-free.app/"

    val apiService: SanPhamAPIService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SanPhamAPIService::class.java)
}

