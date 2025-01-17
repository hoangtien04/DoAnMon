package com.example.damon.Card

data class TrangThaiDH(
    val MaDH:Int,
    val TrangThaiTT:String,
    val TrangThaiDH:Int
)
data class TrangThaiDHResponse(
    val protocol: String,
    val code:String,
    var url:String
)