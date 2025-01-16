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

data class sanphamResponse(
    val protocol: String,
    val code:String,
    var url:String
)

data class SanPhamYeuThich(
    val MaND:Int,
    val MaSP:Int
)

data class SanPhamYeuThichResponse(
    val protocol: String,
    val code:String,
    var url:String
)