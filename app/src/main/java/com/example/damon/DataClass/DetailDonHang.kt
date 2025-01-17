package com.example.damon.DataClass

data class DetailDonHang(
    val MaSP:Int,
    val TenSP:String,
    val DonGia:Int,
    val MoTa:String,
    val Size:String,
    val TenMau:String,
    val DuongDan:String,
    val SoLuong:Int,
    val TongTien:Int
)
data class DetailDonHangResponse(
    val protocol: String,
    val code:String,
    var url:String
)