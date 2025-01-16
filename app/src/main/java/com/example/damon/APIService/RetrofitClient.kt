package com.example.damon.APIService

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SanPhamRetrofitClient {
    val sanPhamAPIService : SanPhamAPIService by lazy {
        Retrofit.Builder()
            .baseUrl("https://48ea-171-252-189-157.ngrok-free.app/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(SanPhamAPIService::class.java)
    }
}