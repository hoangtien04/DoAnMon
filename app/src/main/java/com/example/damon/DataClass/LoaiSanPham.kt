package com.example.damon.DataClass

data class LoaiSanPham(
    val MaLoai:Int,
    val TenLoai:String,
)
data class LoaiSanPhamResponse(
    val protocol: String,
    val code:String,
    var url:String
)