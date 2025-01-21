package com.example.damon.DataClass

data class GioHang(
    val MaSP:Int,
    val MaCTSP: Int,
    val TenSP: String,
    val DuongDan: String,
    val Size: String,
    val TenMau: String,
    val DonGia: Int,
    val SoLuong: Int,
)
data class DiaChi(
    val MaDC : Int,
    val MaND: Int,
    val NguoiNhan: String,
    val SDT : String,
    val DiaChiMD: Int,
    val TinhThanh:String,
    val QuanHuyen:String,
    val PhuongXa:String,
    val CTDiaChi:String
)
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
    val message: String
)