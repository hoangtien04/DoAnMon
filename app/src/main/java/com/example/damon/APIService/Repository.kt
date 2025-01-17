package com.example.damon.APIService

import com.example.damon.DataClass.HinhAnhSanPham
import com.example.damon.DataClass.LoaiSanPham
import com.example.damon.DataClass.MauSac
import com.example.damon.DataClass.SanPhamCard
import com.example.damon.DataClass.SanPhamDetail
import com.example.damon.DataClass.SanPhamYeuThich
import com.example.damon.DataClass.SizeDetail
import com.example.damon.DataClass.ThemSanPhamYeuThich

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
}