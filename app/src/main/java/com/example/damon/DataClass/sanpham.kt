package com.example.damon.DataClass

data class SanPhamCard(
    val MaSP:Int,
    val TenSP:String,
    val DonGia:Int,
    val DuongDan:String
)

data class sanphamResponse(
    val protocol: String,
    val code:String,
    var url:String
)