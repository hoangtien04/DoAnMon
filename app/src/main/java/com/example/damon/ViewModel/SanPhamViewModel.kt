package com.example.damon.ViewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.damon.APIService.Repository
import com.example.damon.DataClass.KiemTraSanPhamYeuThich
import com.example.damon.DataClass.LoaiSanPham
import com.example.damon.DataClass.MauSac
import com.example.damon.DataClass.SanPhamCard
import com.example.damon.DataClass.SanPhamDetail
import com.example.damon.DataClass.SanPhamYeuThich
import com.example.damon.DataClass.SizeDetail
import com.example.damon.DataClass.ThemSanPhamYeuThich
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SanPhamViewModel(private val repository: Repository):ViewModel() {
    var listMauSac: List<MauSac> by mutableStateOf(emptyList())
    var listSize: List<SizeDetail> by mutableStateOf(emptyList())

    //Danh sách sản phẩm card
    private val _listSanPham = MutableStateFlow<List<SanPhamCard>>(emptyList())
    val listSanPham: StateFlow<List<SanPhamCard>> get() = _listSanPham

    private val _filteredSanPham = MutableStateFlow<List<SanPhamCard>>(emptyList())
    val filteredSanPham: StateFlow<List<SanPhamCard>> get() = _filteredSanPham

    fun getAllSanPham() {
        viewModelScope.launch {
            try {
                val sanPhamCard = repository.getAllSanPhamCard()
                _listSanPham.value = sanPhamCard
                _filteredSanPham.value = sanPhamCard
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private val _sanPhamDetail = MutableStateFlow(SanPhamDetail(0, "", "", "", 0, ""))
    val sanPhamDetail: StateFlow<SanPhamDetail> get() = _sanPhamDetail

    fun getSanPhamDetailByID(maSP: Int) {
        viewModelScope.launch {
            try {
                val detail = repository.getSanPhamDetailByID(maSP)
                _sanPhamDetail.value = detail
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

    private val _mauSacByID = MutableStateFlow<List<MauSac>>(emptyList())
    val MauSac: StateFlow<SanPhamDetail> get() = _sanPhamDetail

    fun getMauSacByID(MaSP: Int) {
        viewModelScope.launch {
            try {
                val listMauSac = repository.getMauSacBySanPhamID(MaSP)
                _mauSacByID.value = listMauSac
            } catch (e: Exception) {
                Log.e("SanPhamViewModel", "Error: ${e.message}")
            }
        }
    }

    private val _sizeByID = MutableStateFlow<List<SizeDetail>>(emptyList())
    val sizeDetail: StateFlow<List<SizeDetail>> get() = _sizeByID

    fun getSizeByID(MaSP: Int) {
        viewModelScope.launch {
            try {
                val sizeDetail = repository.getSizeBySanPhamID(MaSP)
                _sizeByID.value = sizeDetail
            } catch (e: Exception) {
                Log.e("SanPhamViewModel", "Error: ${e.message}")
            }
        }
    }

    fun addSanPhamYeuThich(item: ThemSanPhamYeuThich) {
        viewModelScope.launch {
            try {
                repository.addSanPhamYeuThich(item)
                _kiemTraSPYeuThich.value = true
            } catch (e: Exception) {
                Log.e("SanPhamViewModel", "Error add san pham yeu thich", e)
            }
        }
    }

    private val _kiemTraSPYeuThich = MutableStateFlow(false) // Trạng thái yêu thích
    val kiemTraSPYeuThich: StateFlow<Boolean> get() = _kiemTraSPYeuThich

    fun getKiemTraSPYeuThich(MaND: Int, MaSP: Int) {
        viewModelScope.launch {
            try {
                val kiemTraSPYT = repository.kiemTraSPYeuThich(MaND, MaSP)
                _kiemTraSPYeuThich.value = kiemTraSPYT
            } catch (e: Exception) {
                Log.e("SanPhamViewModel", "Error: ${e.message}")
            }
        }
    }

    fun deleteSPYeuThich(MaND: Int, MaSP: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.deleteSPYeuThich(MaND, MaSP)
                _kiemTraSPYeuThich.value = false
            } catch (e: Exception) {
                Log.e("SanPhamViewModel", "Error: ${e.message}")
            }
        }
    }

    private val _sanPhamYeuThich = MutableStateFlow<List<SanPhamYeuThich>>(emptyList())
    val SanPhamYeuThich: StateFlow<List<SanPhamYeuThich>> get() = _sanPhamYeuThich

    fun getSanPhamyeuThich(MaND:Int){
        viewModelScope.launch {
            try {
                val sanPhamYeuThich = repository.getSanPhamYeuThich(MaND)
                _sanPhamYeuThich.value = sanPhamYeuThich
            } catch (e: Exception) {
                Log.e("SanPhamViewModel", "Error: ${e.message}")
            }
        }
    }

    private val _loaiSanPham = MutableStateFlow<List<LoaiSanPham>>(emptyList())
    val loaiSanPham: StateFlow<List<LoaiSanPham>> get() = _loaiSanPham

    fun getLoaiSanPham(){
        viewModelScope.launch {
            try {
                val loaiSanPham = repository.getLoaiSanPham()
                _loaiSanPham.value = loaiSanPham
            } catch (e: Exception) {
                Log.e("SanPhamViewModel", "Error: ${e.message}")
            }
        }
    }





    fun searchSanPham(query: String) {
        viewModelScope.launch {
            if (query.isBlank()) {
                _filteredSanPham.value = _listSanPham.value // Hiển thị toàn bộ nếu từ khóa rỗng
            } else {
                _filteredSanPham.value = _listSanPham.value.filter {
                    it.TenSP.contains(query, ignoreCase = true) // Lọc theo tên sản phẩm
                }
            }
        }
    }

}


