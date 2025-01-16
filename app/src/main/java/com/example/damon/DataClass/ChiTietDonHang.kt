package com.example.damon.DataClass

data class ChiTietDonHang(
    val MaCT:Int,
    val MaDH:Int,
    val MaCTSP:Int,
    val SoLuong:Int,
    val DonGia:Int,
    val TongTien:Int
)
data class ChiTietDonHangResponse(
    val protocol: String,
    val code:String,
    var url:String
)