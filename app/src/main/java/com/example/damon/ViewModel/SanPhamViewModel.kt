package com.example.damon.ViewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.damon.APIService.SanPhamRetrofitClient
import com.example.damon.DataClass.MauSac
import com.example.damon.DataClass.SanPhamCard
import com.example.damon.DataClass.SanPhamDetail
import com.example.damon.DataClass.SanPhamYeuThich
import com.example.damon.DataClass.SizeDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SanPhamViewModel():ViewModel(){
    var listSanPham : List<SanPhamCard> by mutableStateOf(emptyList())
    var sanphamAddResult by mutableStateOf("")
    var sanphamYeuThichAddResult by mutableStateOf("")
    var sanphamUpdateResult by mutableStateOf("")
    var sanpham: SanPhamCard by mutableStateOf(SanPhamCard(0,"","",0,""))
    var sanPhamDetail: SanPhamDetail by mutableStateOf(SanPhamDetail(0,"", "","",0,""))
    var listMauSac: List<MauSac> by mutableStateOf(emptyList())

    var listSize : List<SizeDetail> by mutableStateOf(emptyList())

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

    fun getSanPhamDetailByID(MaSP:Int){
        viewModelScope.launch (Dispatchers.IO){
            try{
                sanPhamDetail = SanPhamRetrofitClient.sanPhamAPIService.getSanPhamDetailByID(MaSP)
            }
            catch (e:Exception){
                Log.e("SanPhamViewModel","Error: ${e.message}")
            }
        }
    }

    fun getMauSacByID(MaSP:Int){
        viewModelScope.launch (Dispatchers.IO){
            try{
                listMauSac = SanPhamRetrofitClient.sanPhamAPIService.getMauSacByID(MaSP)
            }
            catch (e:Exception){
                Log.e("SanPhamViewModel","Error: ${e.message}")
            }
        }
    }

    fun getSizeByID(MaSP:Int){
        viewModelScope.launch (Dispatchers.IO){
            try{
                listSize = SanPhamRetrofitClient.sanPhamAPIService.getSizeByID(MaSP)
            }
            catch (e:Exception){
                Log.e("SanPhamViewModel","Error: ${e.message}")
            }
        }
    }

    fun addSanPhamYeuThich(sanPhamYeuThich: SanPhamYeuThich){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                sanphamYeuThichAddResult = SanPhamRetrofitClient.sanPhamAPIService.addSanPhamYeuThich(sanPhamYeuThich).message()
            }
            catch (e:Exception){
                Log.e("SanPhamViewModel", "Error add san pham yeu thich", e)
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


