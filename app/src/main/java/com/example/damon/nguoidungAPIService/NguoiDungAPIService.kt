package com.example.damon.nguoidungAPIService

import com.example.damon.DataClass.nguoidung
import com.example.damon.DataClass.nguoidungResponse

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