package com.example.damon.DataClass

 data class NguoiDung(
    val MaND: Int,
    var HoTen:String,
    var GioiTinh:Int,
    var NgaySinh:String,
    var SDT:String,
    var Email:String,
    val TaiKhoan:String,
    var MatKhau:String,
    val isAdmin:Int
)

 data class nguoidungResponse(
    val protocol: String,
    val code:String,
    var url:String
)