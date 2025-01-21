package com.example.damon.APIService

import com.example.damon.DataClass.ChiTietDonHang
import com.example.damon.DataClass.ChiTietDonHangResponse
import com.example.damon.DataClass.ChiTietSanPham
import com.example.damon.DataClass.DiaChi
import com.example.damon.DataClass.DonHang
import com.example.damon.DataClass.DonHangResponse
import com.example.damon.DataClass.GioHang
import com.example.damon.DataClass.GioHangResponse
import com.example.damon.DataClass.HinhAnhSanPham
import com.example.damon.DataClass.LoaiSanPham
import com.example.damon.DataClass.MauSac
import com.example.damon.DataClass.SanPhamCard
import com.example.damon.DataClass.SanPhamDetail
import com.example.damon.DataClass.SanPhamYeuThich
import com.example.damon.DataClass.SizeDetail
import com.example.damon.DataClass.ThemGioHang
import com.example.damon.DataClass.ThemGioHangResponse
import com.example.damon.DataClass.ThemSanPhamYeuThich
import retrofit2.Response

class Repository(private val apiService: SanPhamAPIService) {
    suspend fun getAllSanPhamCard(): List<SanPhamCard> {
        return apiService.getAllSanPham()
    }

    suspend fun getSanPhamDetailByID(MaSP: Int): SanPhamDetail {
        return apiService.getSanPhamDetailByID(MaSP)
    }

    suspend fun kiemTraSPYeuThich(MaND: Int, MaSP: Int): Boolean {
        return apiService.kiemTraSPYeuThich(MaND, MaSP)
    }

    suspend fun addSanPhamYeuThich(item: ThemSanPhamYeuThich) {
        apiService.addSanPhamYeuThich(item)
    }

    suspend fun deleteSPYeuThich(ManD: Int, MaSP: Int) {
        apiService.deleteSanPhamYeuThich(ManD, MaSP)
    }

    suspend fun getMauSacBySanPhamID(MaSP: Int): List<MauSac> {
        return apiService.getMauSacByID(MaSP)
    }

    suspend fun getSizeBySanPhamID(MaSP: Int): List<SizeDetail> {
        return apiService.getSizeByID(MaSP)
    }

    suspend fun getSanPhamYeuThich(MaND: Int): List<SanPhamYeuThich> {
        return apiService.getSanPhamYeuThich(MaND)
    }

    suspend fun getLoaiSanPham(): List<LoaiSanPham> {
        return apiService.getDanhMucSanPham()
    }

    suspend fun getHinhAnh(): List<HinhAnhSanPham> {
        return apiService.getHinhAnh()
    }

    suspend fun addDanhSachGioHang(MaND: Int, MaCTSP: Int, SoLuong: Int) {
        apiService.addDanhSachGioHang(MaND, MaCTSP, SoLuong)
    }

    suspend fun getChiTietSanPham(MaSP: Int, MaMau: Int, MaSize: Int):  ChiTietSanPham {
        return apiService.getChiTietSanPham(MaSP, MaMau, MaSize)
    }

    suspend fun getGioHang(MaND: Int): List<GioHang>{
        return apiService.getGioHang(MaND)
    }
    suspend fun getDiaChi(MaND: Int):List<DiaChi>{
        return apiService.getDiaChi(MaND)
    }
    suspend fun deleteCartItem(MaND: Int, MaCTSP: Int) {
        apiService.deleteCartItem(MaND, MaCTSP)
    }
    suspend fun themDonHang(donHang: DonHang): Response<DonHangResponse> {
        return apiService.themDonHang(donHang)
    }

    suspend fun themChiTietDonHang(chiTietDonHang: ChiTietDonHang): Response<ChiTietDonHangResponse> {
        return apiService.themChiTietDonHang(chiTietDonHang)
    }

    suspend fun xoaGioHangSauThanhToan(MaND: Int): Response<GioHangResponse> {
        return apiService.xoaGioHangSauThanhToan(MaND)
    }

}