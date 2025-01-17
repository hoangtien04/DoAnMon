package com.example.damon.DataClass

data class GioHang(
    val MaND:Int,
    val HoTen:String,
    val Email:String,
    val SDT:String,
    val MaCTSP:Int,
    var SoLuongTrongGio:Int,
    val MaSP:Int,
    val TenSP:String,
    val DonGia:Int,
    val MoTa:String
)

data class ThemGioHang(
    val MaND: Int,
    val MaCTSP: Int,
    val SoLuong: Int
)

data class ThemGioHangResponse(
    val protocol: String,
    val code:String,
    var url:String
)

data class GioHangResponse(
    val protocol: String,
    val code:String,
    var url:String
)