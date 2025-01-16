package com.example.damon.DataClass

data class YeuThich(
    val MaND:Int,
    val HoTen:String,
    val Email:String,
    val SDT:String,
    val MaSP:Int,
    val TenSP:String,
    val DonGia:Int,
    val MoTa:String
)
data class YeuThichResponse(
    val protocol: String,
    val code:String,
    var url:String
)