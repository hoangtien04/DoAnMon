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
    var TrangThaiDH:Int
)
data class DonHangResponse(
    val message: String
)