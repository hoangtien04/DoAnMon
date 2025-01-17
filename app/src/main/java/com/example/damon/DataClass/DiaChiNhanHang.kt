package com.example.damon.DataClass

data class DiaChiNhanHang(
    val MaDH:Int,
    val MaDC:Int,
    val NguoiNhan:String,
    val SDT:String,
    val CTDiaChi:String,
    val PhuongXa:String,
    val QuanHuyen:String,
    val TinhThanh:String,
)
data class DiaChiNhanHangResponse(
    val protocol: String,
    val code:String,
    var url:String
)