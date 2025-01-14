package com.example.damon.ViewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.damon.APIService.SanPhamRetrofitClient
import com.example.damon.DataClass.SanPhamCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SanPhamViewModel:ViewModel(){
    var listSanPham : List<SanPhamCard> by mutableStateOf(emptyList())
    var sanphamAddResult by mutableStateOf("")
    var sanphamUpdateResult by mutableStateOf("")
    var sanpham: SanPhamCard by mutableStateOf(SanPhamCard(0,"",0,""))

    fun getAllSanPham(){
        viewModelScope.launch {
            try{
                listSanPham = SanPhamRetrofitClient.sanPhamAPIService.getAllSanPham()
            }
            catch (e:Exception){
                Log.e("SanPhamViewModel","Error: ${e.message}")
            }
        }
    }
    fun getSanPhamByID(MaSP:Int){
        viewModelScope.launch (Dispatchers.IO){
            try{
                sanpham = SanPhamRetrofitClient.sanPhamAPIService.getSanPhamByID(MaSP)
            }
            catch (e:Exception){
                Log.e("SanPhamViewModel","Error: ${e.message}")
            }
        }
    }
    fun addSanPham(sanpham: SanPhamCard){
        viewModelScope.launch (Dispatchers.IO) {
            try {
                sanphamAddResult = SanPhamRetrofitClient.sanPhamAPIService.toString()
                listSanPham = SanPhamRetrofitClient.sanPhamAPIService.getAllSanPham()
            } catch (e: Exception) {
                Log.e("SanPhamViewModel", "Error: ${e.message}")
            }
        }
    }

    fun updateSanPham(MaSP: Int, sanpham: SanPhamCard) {
        viewModelScope.launch(Dispatchers.IO) {
            try{
                sanphamUpdateResult = SanPhamRetrofitClient.sanPhamAPIService.updateSanPham(MaSP, sanpham).toString()
                listSanPham = SanPhamRetrofitClient.sanPhamAPIService.getAllSanPham()
            }
            catch (e:Exception){
                Log.e("SanPhamViewModel","Error: ${e.message}")
            }
        }
    }

    fun newSanPham() : Int{
        if(listSanPham.isEmpty()){
            return 1
        }
        return listSanPham.maxOf{ it.MaSP.toInt() } + 1
    }

    suspend fun deleteSanPham(MaSP: Int) {
        viewModelScope.launch(Dispatchers.IO){
            try{
                SanPhamRetrofitClient.sanPhamAPIService.deleteSanPham(MaSP)
                listSanPham = SanPhamRetrofitClient.sanPhamAPIService.getAllSanPham()
            }
            catch (e:Exception){
                Log.e("SanPhamViewModel","Error: ${e.message}")
            }
        }
    }
}