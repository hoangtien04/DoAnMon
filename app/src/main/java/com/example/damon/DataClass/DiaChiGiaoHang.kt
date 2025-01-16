package com.example.damon.DataClass

data class DiaChiGiaoHang(
    val MaDC:Int,
    val NguoiNhan:String,
    val SDT:String,
    val DiaChiMD:String,
    val TinhThanh:String,
    val QuanHuyen:String,
    val PhuongXa:String,
    val CTDiaChi:String
)
data class DiaChiGiaoHangResponse(
    val protocol: String,
    val code:String,
    var url:String
)