package com.example.damon.DataClass

data class ChiTietSanPhamResponse(
    val protocol: String,
    val code:String,
    var url:String
)

data class ChiTietSanPham(
    val MaCTSP:Int,
    val MaSP:Int,
    val MaMau:Int,
    val MaSize:Int,
    val SoLuong:Int
)