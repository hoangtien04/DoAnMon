package com.example.damon.APIService

import com.example.damon.DataClass.SanPhamCard
import com.example.damon.DataClass.sanphamResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface SanPhamAPIService {
    @GET("sanphamcard")
    suspend fun getAllSanPham():List<SanPhamCard>

    @GET("sanpham/{MaSP}")
    suspend fun getSanPhamByID(
        @Path("MaSP") MaSP:Int,
    ):SanPhamCard

    @POST("/sanpham")
    suspend fun addSanPham(
        @Body sanpham: SanPhamCard
    ): Response<sanphamResponse>

    @PUT("/sanpham/{MaSP}")
    suspend fun updateSanPham(
        @Path("MaSP") MaSP: Int,
        @Body sanpham: SanPhamCard
    ): Response<sanphamResponse>

    @DELETE("/sanpham/{MaSP}")
    suspend fun deleteSanPham(
        @Path("MaSP") MaSP: Int
    ):Response<sanphamResponse>

}