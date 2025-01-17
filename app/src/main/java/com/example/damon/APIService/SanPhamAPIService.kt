package com.example.damon.APIService

import com.example.damon.DataClass.ChiTietSanPham
import com.example.damon.DataClass.GioHang
import com.example.damon.DataClass.HinhAnhSanPham
import com.example.damon.DataClass.KiemTraSanPhamYeuThich
import com.example.damon.DataClass.LoaiSanPham
import com.example.damon.DataClass.MauSac
import com.example.damon.DataClass.SanPhamCard
import com.example.damon.DataClass.SanPhamDetail
import com.example.damon.DataClass.SanPhamYeuThich
import com.example.damon.DataClass.SanPhamYeuThichResponse
import com.example.damon.DataClass.SizeDetail
import com.example.damon.DataClass.ThemGioHang
import com.example.damon.DataClass.ThemGioHangResponse
import com.example.damon.DataClass.ThemSanPhamYeuThich
import com.example.damon.DataClass.sanphamResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface SanPhamAPIService {
    @GET("sanphamcard")
    suspend fun getAllSanPham():List<SanPhamCard>

    @GET("sanphamdetail/{MaSP}")
    suspend fun getSanPhamDetailByID(
        @Path("MaSP") MaSP:Int,
    ):SanPhamDetail

    @POST("/adddanhsachyeuthich")
    suspend fun addSanPhamYeuThich(
        @Body sanPhamYeuThich: ThemSanPhamYeuThich
    ): Response<SanPhamYeuThichResponse>

    @GET("/mausac/{MaSP}")
    suspend fun getMauSacByID(
        @Path("MaSP") MaSP:Int,
    ):List<MauSac>

    @GET("/size/{MaSP}")
    suspend fun getSizeByID(
        @Path("MaSP") MaSP:Int,
    ):List<SizeDetail>

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

    @DELETE("/xoadanhsachyeuthich/{manguoidung}/{masanpham}")
    suspend fun deleteSanPhamYeuThich(
        @Path("manguoidung") MaND: Int,
        @Path("masanpham") MaSP: Int
    ):Response<SanPhamYeuThichResponse>

    @GET("/kiemtrayeuthich/{mand}/{masp}")
    suspend fun kiemTraSPYeuThich(
        @Path("mand") userId: Int,
        @Path("masp") productId: Int
    ): Boolean

    @GET("/nguoidung/{MaND}/sanphamyeuthich")
    suspend fun getSanPhamYeuThich(
        @Path("MaND") MaND:Int,
    ):List<SanPhamYeuThich>

    @GET("/danhmuc")
    suspend fun getDanhMucSanPham():List<LoaiSanPham>

    @GET("/hinhanh")
    suspend fun getHinhAnh():List<HinhAnhSanPham>

    @POST("/adddanhsachgiohang/{MaND}/{MaCTSP}/{SoLuong}")
    suspend fun addDanhSachGioHang(
        @Path("MaND") MaND:Int,
        @Path ("MaCTSP") MaCTSP:Int,
        @Path ("SoLuong") SoLuong:Int,
    )

    @GET("chitietsanpham/{MaSP}/{MaMau}/{MaSize}")
    suspend fun getChiTietSanPham(
        @Path("MaSP") MaSP:Int,
        @Path("MaMau") MaMau:Int,
        @Path("MaSize") MaSize:Int,
    ):ChiTietSanPham

    @GET("/giohang/{MaND}")
    suspend fun getGioHang(
        @Path("MaND") MaND:Int,
    ):List<GioHang>

}