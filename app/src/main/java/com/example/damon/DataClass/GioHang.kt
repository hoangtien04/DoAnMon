package com.example.damon.DataClass

data class ThemGioHang(
    val MaND: Int,
    val MaCTSP : Int,
    val SoLuong : Int
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