package com.example.damon.DataClass

data class nguoidung(
    val MaND: Int,
    val HoTen:String,
    val GioiTinh:Boolean,
    val NgaySinh:String,
    val SDT:String,
    val Email:String,
    val TaiKhoan:String,
    val MatKhau:String,
    val isAdmin:Boolean
)

data class nguoidungResponse(
    val protocol: String,
    val code:String,
    var url:String
)