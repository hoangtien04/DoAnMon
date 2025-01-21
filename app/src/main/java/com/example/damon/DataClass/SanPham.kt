package com.example.damon.DataClass

data class SanPhamCard(
    val MaSP:Int,
    val TenSP:String,
    val TenLoai:String,
    val DonGia:Int,
    val DuongDan:String
)

data class SanPhamDetail(
    val MaSP:Int = 0,
    val TenSP:String = "",
    val TenLoai:String = "",
    val DuongDan:String = "",
    val DonGia:Int = 0,
    val MoTa:String = "",
)

data class SanPham(
    val MaSP:Int,
    val MaLoai:Int,
    val TenSP:String,
    val DonGia:Int,
    val MoTa:String
)
data class sanphamResponse(
    val protocol: String,
    val code:String,
    var url:String
)

data class  ThemSanPhamYeuThich(
    val MaND:Int,
    val MaSP:Int
)

data class KiemTraSanPhamYeuThich(
    val YeuThich:Boolean
)

data class SanPhamYeuThichResponse(
    val protocol: String,
    val code:String,
    var url:String
)

data class SanPhamYeuThich(
    val MaSP:Int,
    val TenSP:String,
    val DuongDan: String,
    val DonGia: Int,
    val MoTa: String,
    val TenLoai: String
)

data class Product(
    var imageResId: Int,
    var title:String,
    var subtitle:String
)

data class HinhAnhSanPham(
    val MaHA:Int,
    val MaSp: Int,
    val MaMau: Int,
    val DuongDan: String,
    val Avatar: Int
)
