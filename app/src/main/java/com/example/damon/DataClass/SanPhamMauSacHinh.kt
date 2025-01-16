package com.example.damon.DataClass

data class SanPhamMauSacHinh(
    val MaSP:Int,
    val MaCTSP:Int,
    val TenSP:String,
    val DonGia:Int,
    val MoTa:String,
    val TenMau:String,
    val MauHex:String,
    val Size:String,
    val HinhAnh:String
)
data class SanPhamMauSacHinhResponse(
    val protocol: String,
    val code:String,
    var url:String
)