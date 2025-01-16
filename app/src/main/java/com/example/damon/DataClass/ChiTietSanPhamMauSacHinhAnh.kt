package com.example.damon.DataClass

data class ChiTietSanPhamMauSacHinhAnh(
    val MaSP:Int,
    val MaCTSP:Int,
    val TenMau:String,
    val MauHex:String,
    val Size:String,
    val HinhAnh:String
)
data class ChiTietSanPhamMauSacHinhAnhResponse(
    val protocol: String,
    val code:String,
    var url:String
)