package com.example.damon.APIService

import com.example.damon.Card.TrangThaiDH
import com.example.damon.DataClass.ChiTietDonHang
import com.example.damon.DataClass.ChiTietDonHangResponse
import com.example.damon.DataClass.ChiTietSanPham
import com.example.damon.DataClass.ChiTietSanPhamMauSacHinhAnh
import com.example.damon.DataClass.ChiTietSanPhamResponse
import com.example.damon.DataClass.DetailDonHang
import com.example.damon.DataClass.DiaChiGiaoHang
import com.example.damon.DataClass.DiaChiGiaoHangResponse
import com.example.damon.DataClass.DiaChiNhanHang
import com.example.damon.DataClass.DonHang
import com.example.damon.DataClass.DonHangResponse
import com.example.damon.DataClass.GioHang
import com.example.damon.DataClass.GioHangResponse
import com.example.damon.DataClass.LoaiSanPham
import com.example.damon.DataClass.LoaiSanPhamResponse
import com.example.damon.DataClass.NguoiDung
import com.example.damon.DataClass.SanPham
import com.example.damon.DataClass.SanPhamMauSacHinh
import com.example.damon.DataClass.YeuThich
import com.example.damon.DataClass.YeuThichResponse
import com.example.damon.DataClass.nguoidungResponse
import com.example.damon.DataClass.sanphamResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

     //Người dùng
    @GET("nguoidung")
    suspend fun getAllNguoiDung(): List<NguoiDung>

    @GET("nguoidung/{mand}")
    suspend fun getNguoiDungById(
        @Path("mand") id: Int
    ): NguoiDung

     @POST("themnguoidung")
     suspend fun addNguoiDung(@Body nguoiDung: NguoiDung): Response<nguoidungResponse>

     @PUT("suanguoidung/{MaND}")
     suspend fun updateNguoiDung(
         @Path("MaND") mand: Int,
         @Body nguoiDung: NguoiDung
     ): Response<nguoidungResponse>

     //Loại sản phẩm
     @GET("loaisanpham")
     suspend fun getAllLoaiSanPham(): List<LoaiSanPham>

     @POST("themloaisanpham")
     suspend fun addLoaiSanPham(@Body loaisanpham: LoaiSanPham): Response<LoaiSanPhamResponse>

    //Sản Phẩm
    @GET("sanpham")
    suspend fun getAllSanPham(): List<SanPham>

     @GET("sanpham/{MaSP}")
     suspend fun getSanPhamById(
         @Path("MaSP") id: Int
     ): SanPham

     @POST("themsanpham")
     suspend fun addSanPham(@Body sanPham: SanPham): Response<sanphamResponse>

     @PUT("suasanpham/{MaSP}")
     suspend fun updateSanPham(
         @Path("MaSP") masp: Int,
         @Body sanPham: SanPham
     ): Response<sanphamResponse>

     @DELETE("xoasanpham/{MaSP}")
     suspend fun deleteSanPham(
         @Path("id") sanphamid:Int
     ):Response<sanphamResponse>

     //Chi Tiết Sản Phẩm
     @GET("chitietsanpham")
     suspend fun getAllChiTietSanPham(): List<ChiTietSanPham>

     @GET("chitietsanpham/{MaSP}")
     suspend fun getChiTietSanPhamById(
         @Path("MaSP") id: Int
     ): ChiTietSanPham

     @POST("themchitietsanpham")
     suspend fun addChiTietSanPham(@Body chiTietSanPham: ChiTietSanPham): Response<ChiTietSanPhamResponse>

     @PUT("suachitietsanpham/{MaCTSP}")
     suspend fun updateChiTietSanPham(
         @Path("MaCTSP") mactsp: Int,
         @Body chiTietSanPham: ChiTietSanPham
     ): Response<ChiTietSanPhamResponse>

     @DELETE("xoachitietsanpham/{MaCTSP}")
     suspend fun deleteChiTietSanPham(
         @Path("id") mactsp:Int
     ):Response<ChiTietSanPhamResponse>

     //Đơn Hàng

     @GET("donhang")
     suspend fun getAllDonHang(): List<DonHang>

     @GET("donhang/{madonhang}")
     suspend fun getDonHangById(
         @Path("madonhang") id: Int
     ): DonHang


    @GET("donhang/trangthai/{MaND}/{trangthai}")
    suspend fun getDonHangUserByStatus(
        @Path("MaND") MaND: Int,
        @Path("trangthai") trangthai:Int
    ): List<DonHang>

     @POST("themdonhang")
     suspend fun addDonHang(@Body donHang: DonHang): Response<DonHangResponse>

     @PUT("suadonhang/{MaDH}")
     suspend fun updateDonHang(
         @Path("MaDH") id: Int,
         @Body donhang: DonHang
     ): Response<DonHangResponse>

     @DELETE("xoadonhang/{MaDH}")
     suspend fun deleteDonHang(
         @Path("id") madonhang:Int
     ):Response<DonHangResponse>

     //Chi Tiết Đơn Hàng

     @GET("chitietdonhang")
     suspend fun getAllChiTietDonHang(): List<ChiTietDonHang>

     @GET("chitietdonhang/{machitietdonhang}")
     suspend fun getChiTietDonHangById(
         @Path("machitietdonhang") id: Int
     ): ChiTietDonHang

     @POST("themchitietdonhang")
     suspend fun addChiTietDonHang(@Body chiTietDonHang: ChiTietDonHang): Response<ChiTietDonHangResponse>

     @PUT("suachitietdonhang/{machitietdonhang}")
     suspend fun updateChiTietDonHang(
         @Path("machitietdonhang") machitietdonhang: Int,
         @Body chiTietDonHang: ChiTietDonHang
     ): Response<ChiTietDonHangResponse>

     @DELETE("xoachitietdonhang/{machitietdonhang}")
     suspend fun deleteChiTietDonHang(
         @Path("id") machitietdonhang:Int
     ):Response<ChiTietDonHangResponse>

     //Địa chỉ giao hàng

     @GET("diachigiaohang")
     suspend fun getAllDiaChiGiaoHang(): List<DiaChiGiaoHang>

     @GET("diachigiaohang/{madiachi}")
     suspend fun getDiaChiGiaoHangById(
         @Path("madiachi") id: Int
     ): DiaChiGiaoHang

     @POST("themdiachigiaohang")
     suspend fun addDiaChiGiaoHang(@Body diaChiGiaoHang: DiaChiGiaoHang): Response<DiaChiGiaoHangResponse>

     @PUT("suadiachigiaohang/{madiachi}")
     suspend fun updateDiaChiGiaoHang(
         @Path("madiachi") madiachi: Int,
         @Body diaChiGiaoHang: DiaChiGiaoHang
     ): Response<DiaChiGiaoHangResponse>

     @DELETE("xoadiachigiaohang/{madiachi}")
     suspend fun deleteDiaChiGiaoHang(
         @Path("id") madiachi:Int
     ):Response<DiaChiGiaoHangResponse>

     //Danh Sách Yêu Thích

     @GET("danhsachyeuthich/{maND}")
     suspend fun getAllDanhSachYeuThich(
         @Path("maND") maND: Int
     ): List<YeuThich>

     @POST("adddanhsachyeuthich")
     suspend fun addDanhSachYeuThich(@Body danhsachyeuthich: YeuThich): Response<YeuThichResponse>

     @DELETE("xoadanhsachyeuthich/{manguoidung}/{masanpham}")
     suspend fun deleteDanhSachYeuThich(
         @Path("manguoidung") manguoidung:Int,
         @Path("masanpham") masanpham:Int
     ):Response<YeuThichResponse>

     //Giỏ Hàng

     @GET("giohang/{mand}")
     suspend fun getAllGioHang(
         @Path("mand") mand: Int
     ): List<GioHang>

     @POST("adddanhsachgiohang")
     suspend fun addGioHang(@Body danhsachgiohang: GioHang): Response<GioHangResponse>

     @PUT("editgiohang/{mand}/{mactsp}")
     suspend fun updateGioHang(
         @Path("mand") mand: Int,
         @Path("mactsp") mactsp: Int,
         @Body giohang: GioHang
     ): Response<GioHangResponse>

     //Danh sách Sản Phẩm có màu có hình

     @GET("sanphammausachinhanh")
     suspend fun getAllSanPhamMauSacHinhAnh(): List<SanPhamMauSacHinh>

     //Danh Sách chi tiết Sản Phẩm có màu có hình

     @GET("chitietsanphammausachinhanh")
     suspend fun getAllChiTietSanPhamMauSacHinhAnh(): List<ChiTietSanPhamMauSacHinhAnh>

     //Đăng nhập
//    @POST("dangnhap")
//    suspend fun kiemTraDangNhap(@Body nguoiDung: NguoiDung): Response<nguoidungResponse>


     @GET("dangnhap/{taikhoan}/{matkhau}")
     suspend fun kiemTraDangNhap(
         @Path("taikhoan") taikhoan: String,
         @Path("matkhau") matkhau: String
     ): List<NguoiDung>





    @GET("donhang/ctdonhang/{MaDH}")
    suspend fun getChiTietDonHangByMaDH(
        @Path("MaDH") MaDH: Int
    ): List<DetailDonHang>

    @GET("donhang/diachi/{MaDH}")
    suspend fun getDiaChiByMaDH(
        @Path("MaDH") MaDH: Int
    ): List<DiaChiNhanHang>

    @GET("donhang/trangthaidonhang/{MaDH}")
    suspend fun getTrangThaiByMaDH(
        @Path("MaDH") MaDH: Int
    ): List<TrangThaiDH>

}