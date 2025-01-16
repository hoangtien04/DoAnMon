package com.example.damon.DataClass

data class DonHang(
    val MaDH:Int,
    val MaND:Int,
    val MaDC:Int,
    val NgayDat:String,
    val NgayTT:String,
    val TongTien:Int,
    val PhuongThucTT:String,
    val TrangThaiTT:String,
    val TrangThaiDH:String
)
data class DonHangResponse(
    val protocol: String,
    val code:String,
    var url:String
)