package com.example.damon.APIService

import com.example.damon.DataClass.NguoiDung
import com.example.damon.DataClass.SanPhamYeuThichResponse
import com.example.damon.DataClass.ThongTinDangNhap
import com.example.damon.DataClass.nguoidungResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface NguoiDungAPIService {
    @GET("dsnd")
    suspend fun getAllNguoiDung(): List<NguoiDung>

    @POST("/dangnhap")
    suspend fun kiemTraDangNhap(
        @Body thongTinDangNhap: ThongTinDangNhap
    ): Response<ThongTinDangNhap>

    @GET("nd/{mand}")
    suspend fun getNguoiDungById(
        @Path("mand") id: Int
    ): NguoiDung

    @POST("/themnd")
    suspend fun addNguoiDung(@Body nguoiDung: NguoiDung): Response<nguoidungResponse>

    @PUT("/suand/{mand}")
    suspend fun updateNguoiDung(
        @Path("mand") mand: Int,
        @Body nguoiDung: NguoiDung
    ): Response<nguoidungResponse>
}