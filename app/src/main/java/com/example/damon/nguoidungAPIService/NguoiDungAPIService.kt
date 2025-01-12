package com.example.damon.nguoidungAPIService

import com.example.damon.DataClass.nguoidung
import com.example.damon.DataClass.nguoidungResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface NguoiDungAPIService {
    @GET("dsnd")
    suspend fun getAllNguoiDung(): List<nguoidung>

    @GET("nd/{mand}")
    suspend fun getNguoiDungById(
        @Path("mand") id: Int
    ): nguoidung

    @POST("/themnd")
    suspend fun addNguoiDung(@Body nguoiDung: nguoidung): Response<nguoidungResponse>

    @POST("/dangnhap")
    suspend fun kiemTraDangNhap(@Body nguoiDung: nguoidung): Response<nguoidungResponse>

    @PUT("/suand/{mand}")
    suspend fun updateNguoiDung(
        @Path("mand") mand: Int,
        @Body nguoiDung: nguoidung
    ): Response<nguoidungResponse>
}