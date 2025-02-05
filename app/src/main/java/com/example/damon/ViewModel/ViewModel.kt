package com.example.damon.ViewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.damon.APIService.KiemTraTaiKhoanResponse
import com.example.damon.Card.TrangThaiDH
import com.example.damon.DataClass.ChiTietDonHang
import com.example.damon.DataClass.ChiTietSanPham
import com.example.damon.DataClass.DetailDonHang
import com.example.damon.DataClass.DiaChiGiaoHang
import com.example.damon.DataClass.DiaChiNhanHang
import com.example.damon.DataClass.DonHang
import com.example.damon.DataClass.GioHang
import com.example.damon.DataClass.MauSac
import com.example.damon.DataClass.NguoiDung
import com.example.damon.DataClass.SanPhamCard
import com.example.damon.DataClass.SanPhamDetail
import com.example.damon.DataClass.SizeDetail
import com.example.damon.DataClass.YeuThich
import com.example.damon.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllViewModel: ViewModel(){


    fun clearDonHangList() {
        listDonHang = emptyList()
    }
    var gioHang :GioHang by mutableStateOf(GioHang(1,1,"","","","",1,1))
    var nguoidungtaikhoan :NguoiDung by mutableStateOf(NguoiDung(0,"",0,"","","","","",0))

    var trangthaiDangNhap: Boolean = false
    var listtempdangnhap : List<NguoiDung> by mutableStateOf(emptyList())
    fun kiemtratrangthai(){
        if (nguoidungtaikhoan.MaND == 0)
            trangthaiDangNhap = false
        else
            trangthaiDangNhap = true
    }

    var nguoidungdangnhap :NguoiDung by mutableStateOf(NguoiDung(0,"",0,"","","","","",0))

    fun getNguoiDungByTaiKhoanMatKhau(TaiKhoan:String,MauKhau:String){
        viewModelScope.launch (Dispatchers.IO){
            try{
                listtempdangnhap = RetrofitClient.apiService.kiemTraDangNhap(TaiKhoan,MauKhau)
                nguoidungdangnhap = listtempdangnhap[0]
            }
            catch (e:Exception){
                Log.e("DangNhapViewModel","Error: ${e.message}")
            }
        }
    }



    var listSanPham : List<SanPhamCard> by mutableStateOf(emptyList())
    var sanphamAddResult by mutableStateOf("")
    var sanphamUpdateResult by mutableStateOf("")
    var sanpham: SanPhamCard by mutableStateOf(SanPhamCard(0,"","",0,""))
    var sanPhamDetail: SanPhamDetail by mutableStateOf(SanPhamDetail(0,"", "","",0,""))
    var listMauSac: List<MauSac> by mutableStateOf(emptyList())

    var listSize : List<SizeDetail> by mutableStateOf(emptyList())


    var listNguoiDung:List<NguoiDung> by mutableStateOf(emptyList())
    var nguoidungaddResult by mutableStateOf("")
    var nguoidungupdateResult by mutableStateOf("")
    var nguoidung: NguoiDung by mutableStateOf(NguoiDung(0,"",1,"","","","","",1))

    //Người dùng
    fun getAllNguoiDung() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient.apiService.getAllNguoiDung()
                Log.d("API Response", response.toString())
                if (response.isNotEmpty()) {
                    listNguoiDung = response
                } else {
                    Log.e("NguoiDungViewModel", "Không tìm thấy người dùng.")
                }
            } catch (e: Exception) {
                Log.e("NguoiDungViewModel", "Lỗi khi lấy người dùng", e)
            }
        }
    }
    fun getNguoiDungById(id:Int){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                nguoidung = RetrofitClient.apiService
                    .getNguoiDungById(id)
            }catch (e:Exception){
                Log.e("NguoiDungViewModel","Lỗi khi lấy người dùng", e)
            }
        }
    }
    fun addNguoiDung(nguoidung:NguoiDung){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                nguoidungaddResult = RetrofitClient.apiService.addNguoiDung(nguoidung).message()
                listNguoiDung = RetrofitClient.apiService.getAllNguoiDung()
            }catch (e:Exception){
                Log.e("NguoiDungViewModel","Lỗi khi thêm người dùng", e)
            }
        }
    }
    fun editNguoiDung(nguoidungId:Int ,nguoidung:NguoiDung){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                nguoidungupdateResult = RetrofitClient.apiService.updateNguoiDung(nguoidungId,nguoidung).message()
                listNguoiDung = RetrofitClient.apiService.getAllNguoiDung()
            }catch (e:Exception){
                Log.e("NguoiDungViewModel","Lỗi khi sửa người dùng", e)
            }
        }
    }

    var listYeuThich:List<YeuThich> by mutableStateOf(emptyList())
    var yeuthichaddResult by mutableStateOf("")




    var listGioHang:List<GioHang> by mutableStateOf(emptyList())
    var giohangaddResult by mutableStateOf("")
    var giohangupdateResult by mutableStateOf("")

    //Đơn Hàng
    var listDonHang:List<DonHang> by mutableStateOf(emptyList())
    var donhangaddResult by mutableStateOf("")
    var donhangupdateResult by mutableStateOf("")
    var donhang: DonHang by mutableStateOf(DonHang(0,0,0,"","",0,"","",0))

    //Đơn Hàng
    fun getAllDonHang() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient.apiService.getAllDonHang()
                Log.d("API Response", response.toString())
                if (response.isNotEmpty()) {
                    listDonHang = response
                } else {
                    Log.e("DonHangViewModel", "Không tìm thấy đơn hàng.")
                }
            } catch (e: Exception) {
                Log.e("DonHangViewModel", "Lỗi khi lấy đơn hàng", e)
            }
        }
    }
    fun getDonHangId(id:Int){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                donhang = RetrofitClient.apiService
                    .getDonHangById(id)
            }catch (e:Exception){
                Log.e("DonHangViewModel","Lỗi khi lấy đơn hàng", e)
            }
        }
    }
    fun getDonHangUserStatus(MaND:Int,trangthai:Int){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                listDonHang = RetrofitClient.apiService
                    .getDonHangUserByStatus(MaND,trangthai)
            }catch (e:Exception){
                Log.e("DonHangViewModel","Lỗi khi lấy đơn hàng", e)
            }
        }
    }

    fun addDonHang(donHang: DonHang){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                donhangaddResult = RetrofitClient.apiService.addDonHang(donHang).message()
                listDonHang = RetrofitClient.apiService.getAllDonHang()
            }catch (e:Exception){
                Log.e("DonHangViewModel","Lỗi khi thêm đơn hàng", e)
            }
        }
    }


    fun editDonHang(donhangid:Int ,donHang: DonHang){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                donhangupdateResult = RetrofitClient.apiService.updateDonHang(donhangid,donHang).message()
            }catch (e:Exception){
                Log.e("DonHangViewModel","Lỗi khi sửa đơn hàng ", e)
            }
        }
    }
    fun editTrangThaiDonHang(trangthai:Int ,MaDH:Int){
        viewModelScope.launch ( Dispatchers.IO ){
            try {
                val response = RetrofitClient.apiService.suatrangthaidonhang(trangthai, MaDH)
                if (response.isSuccessful) {
                    Log.d("DonHangViewModel", "Phản hồi: ${response.body()}")
                } else {
                    Log.e("DonHangViewModel", "Lỗi API: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("DonHangViewModel", "Lỗi khi sửa đơn hàng", e)
            }
        }
    }

    fun doimatkhau(MaND:Int ,MatKhau:String){
        viewModelScope.launch ( Dispatchers.IO ){
            try {
                val response = RetrofitClient.apiService.doimatkhau(MaND, MatKhau)
                if (response.isSuccessful) {
                    Log.d("DoiMatKhauViewModel", "Phản hồi: ${response.body()}")
                } else {
                    Log.e("DoiMatKhauViewModel", "Lỗi API: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("DoiMatKhauViewModel", "Lỗi khi đổi mật khẩu", e)
            }
        }
    }

    var listDiaChiGiaoHang:List<DiaChiGiaoHang> by mutableStateOf(emptyList())
    var diachigiaohangaddResult by mutableStateOf("")
    var diachigiaohangupdateResult by mutableStateOf("")
    var diachigiaohang: DiaChiGiaoHang by mutableStateOf(DiaChiGiaoHang(0,"","","","","","",""))

    //Đơn Hàng
    fun getAllDiaChiGiaoHang() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient.apiService.getAllDiaChiGiaoHang()
                Log.d("API Response", response.toString())
                if (response.isNotEmpty()) {
                    listDiaChiGiaoHang = response
                } else {
                    Log.e("DiaChiGiaoHangViewModel", "Không tìm thấy địa chỉ giao hàng.")
                }
            } catch (e: Exception) {
                Log.e("DiaChiGiaoHangViewModel", "Lỗi khi lấy địa chỉ giao hàng", e)
            }
        }
    }
    fun getDiaChiGiaoHangId(id:Int){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                diachigiaohang = RetrofitClient.apiService
                    .getDiaChiGiaoHangById(id)
            }catch (e:Exception){
                Log.e("DiaChiGiaoHangViewModel","Lỗi khi lấy địa chỉ giao hàng", e)
            }
        }
    }
    fun addDiaChiGiaoHang(diaChiGiaoHang: DiaChiGiaoHang){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                diachigiaohangaddResult = RetrofitClient.apiService.addDiaChiGiaoHang(diaChiGiaoHang).message()
                listDiaChiGiaoHang = RetrofitClient.apiService.getAllDiaChiGiaoHang()
            }catch (e:Exception){
                Log.e("DiaChiGiaoHangViewModel","Lỗi khi thêm địa chỉ giao hàng", e)
            }
        }
    }
    fun editDiaChiGiaoHang(diachiId:Int ,diaChiGiaoHang: DiaChiGiaoHang){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                diachigiaohangupdateResult = RetrofitClient.apiService.updateDiaChiGiaoHang(diachiId,diaChiGiaoHang).message()
                listDiaChiGiaoHang = RetrofitClient.apiService.getAllDiaChiGiaoHang()
            }catch (e:Exception){
                Log.e("DonHangViewModel","Lỗi khi sửa đơn hàng", e)
            }
        }
    }

    var listChiTietSanPham:List<ChiTietSanPham> by mutableStateOf(emptyList())
    var chitietsanphamaddResult by mutableStateOf("")
    var chitietsanphamupdateResult by mutableStateOf("")
    var chitietsanpham: ChiTietSanPham by mutableStateOf(ChiTietSanPham(0,0,0,0,0))

    //Chi Tiết Sản Phẩm
    fun getAllChiTietSanPham() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient.apiService.getAllChiTietSanPham()
                Log.d("API Response", response.toString())
                if (response.isNotEmpty()) {
                    listChiTietSanPham = response
                } else {
                    Log.e("ChiTietSanPhamViewModel", "Không tìm thấy chi tiết sản phẩm.")
                }
            } catch (e: Exception) {
                Log.e("ChiTietSanPhamViewModel", "Lỗi khi lấy chi tiết sản phẩm", e)
            }
        }
    }
    fun getChiTietSanPhamId(id:Int){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                chitietsanpham = RetrofitClient.apiService
                    .getChiTietSanPhamById(id)
            }catch (e:Exception){
                Log.e("ChiTietSanPhamViewModel","Lỗi khi lấy chi tiết sản phẩm", e)
            }
        }
    }
    fun addChiTietSanPham(chitietsanPham: ChiTietSanPham){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                chitietsanphamaddResult = RetrofitClient.apiService.addChiTietSanPham(chitietsanPham).message()
                listChiTietSanPham = RetrofitClient.apiService.getAllChiTietSanPham()
            }catch (e:Exception){
                Log.e("ChiTietSanPhamViewModel","Lỗi khi thêm chi tiết sản phẩm", e)
            }
        }
    }
    fun editChiTietSanPham(chitietsanphamid:Int ,chitietsanPham: ChiTietSanPham){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                chitietsanphamupdateResult = RetrofitClient.apiService.updateChiTietSanPham(chitietsanphamid,chitietsanPham).message()
                listChiTietSanPham = RetrofitClient.apiService.getAllChiTietSanPham()
            }catch (e:Exception){
                Log.e("SanPhamViewModel","Lỗi khi sửa chi tiết sản phẩm", e)
            }
        }
    }

    var listChiTietDonHang:List<ChiTietDonHang> by mutableStateOf(emptyList())
    var chitietdonhangaddResult by mutableStateOf("")
    var chitietdonhangupdateResult by mutableStateOf("")
    var chitietdonhang: ChiTietDonHang by mutableStateOf(ChiTietDonHang(0,0,0,0,0,0))

    //Đơn Hàng
    fun getAllChiTietDonHang() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient.apiService.getAllChiTietDonHang()
                Log.d("API Response", response.toString())
                if (response.isNotEmpty()) {
                    listChiTietDonHang = response
                } else {
                    Log.e("ChiTietDonHangViewModel", "Không tìm thấy chi tiết đơn hàng.")
                }
            } catch (e: Exception) {
                Log.e("ChiTietDonHangViewModel", "Lỗi khi lấy chi tiết đơn hàng", e)
            }
        }
    }
    fun getChiTietDonHangId(id:Int){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                chitietdonhang = RetrofitClient.apiService
                    .getChiTietDonHangById(id)
            }catch (e:Exception){
                Log.e("ChiTietDonHangViewModel","Lỗi khi lấy chi tiết đơn hàng", e)
            }
        }
    }
    fun addChiTietDonHang(chitietdonHang: ChiTietDonHang){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                chitietdonhangaddResult = RetrofitClient.apiService.addChiTietDonHang(chitietdonHang).message()
                listChiTietDonHang = RetrofitClient.apiService.getAllChiTietDonHang()
            }catch (e:Exception){
                Log.e("DonHangViewModel","Lỗi khi thêm đơn hàng", e)
            }
        }
    }
    fun editChiTietDonHang(chitietdonhangId:Int ,chitietdonHang: ChiTietDonHang){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                chitietdonhangupdateResult = RetrofitClient.apiService.updateChiTietDonHang(chitietdonhangId,chitietdonHang).message()
                listChiTietDonHang = RetrofitClient.apiService.getAllChiTietDonHang()
            }catch (e:Exception){
                Log.e("DonHangViewModel","Lỗi khi sửa đơn hàng", e)
            }
        }
    }


    var listDetailDonHang:List<DetailDonHang> by mutableStateOf(emptyList())

    fun getChiTietDonHangByMaDH(MaDH:Int) {
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                listDetailDonHang = RetrofitClient.apiService
                    .getChiTietDonHangByMaDH(MaDH)
            }catch (e:Exception){
                Log.e("ChiTietDonHangViewModel","Lỗi khi lấy chi tiết đơn hàng", e)
            }
        }
    }

    var listDiachi:List<DiaChiNhanHang> by mutableStateOf(emptyList())
    var diachihang: DiaChiNhanHang by mutableStateOf(DiaChiNhanHang(0,0,"","","","","",""))
    fun getDiaChiByDonHang(MaDH:Int){
        viewModelScope.launch (Dispatchers.IO){
            try{
                listDiachi = RetrofitClient.apiService.getDiaChiByMaDH(MaDH)
                diachihang = listDiachi[0]
            }
            catch (e:Exception){
                Log.e("DangNhapViewModel","Error: ${e.message}")
            }
        }
    }

    var listTrangThai:List<TrangThaiDH> by mutableStateOf(emptyList())
    var trangthaidonhang: TrangThaiDH by mutableStateOf(TrangThaiDH(0,"",0))

    fun getTrangThaiByDonHang(MaDH:Int){
        viewModelScope.launch (Dispatchers.IO){
            try{
                listTrangThai = RetrofitClient.apiService.getTrangThaiByMaDH(MaDH)
                trangthaidonhang = listTrangThai[0]
            }
            catch (e:Exception){
                Log.e("DangNhapViewModel","Error: ${e.message}")
            }
        }
    }

    var dangkyResult by mutableStateOf("")

    fun dangky(taikhoan:String,matkhau:String){
        viewModelScope.launch ( Dispatchers.IO ){
            try{
                dangkyResult = RetrofitClient.apiService.dangky(taikhoan,matkhau).message()
                listNguoiDung = RetrofitClient.apiService.getAllNguoiDung()
            }catch (e:Exception){
                Log.e("ChiTietSanPhamViewModel","Lỗi khi thêm chi tiết sản phẩm", e)
            }
        }
    }

    var listdangky: List<KiemTraTaiKhoanResponse> by mutableStateOf(emptyList())
    var dangky by mutableStateOf(0)

    fun kiemtrataikhoan(TaiKhoan: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                listdangky = RetrofitClient.apiService.kiemtrataikhoan(TaiKhoan)
                if (listdangky.isNotEmpty()) {
                    dangky = listdangky[0].SoLuong
                }
            } catch (e: Exception) {
                Log.e("DangKyViewModel", "Error: ${e.message}")
            }
        }
    }



}