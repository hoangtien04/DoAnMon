package com.example.damon.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.damon.Card.OrderDetailCard
import com.example.damon.Card.TrangThaiDH
import com.example.damon.DataClass.DiaChiNhanHang
import com.example.damon.DataClass.Product
import com.example.damon.R
import com.example.damon.ViewModel.AllViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderDetailAdminScreen(navController: NavController, viewModel: AllViewModel, id: Int = 0,) {
    viewModel.getChiTietDonHangByMaDH(id)
    var lisdetail = viewModel.listDetailDonHang
    viewModel.getDiaChiByDonHang(id)
    var diaChiNhanHang:DiaChiNhanHang = viewModel.diachihang
    viewModel.getTrangThaiByDonHang(id)
    var trangThaiDH:TrangThaiDH = viewModel.trangthaidonhang

    var nguoinhan = diaChiNhanHang.NguoiNhan
    var SDT = diaChiNhanHang.SDT
    var diaChi = "${diaChiNhanHang.TinhThanh} ${diaChiNhanHang.QuanHuyen} ${diaChiNhanHang.PhuongXa} ${diaChiNhanHang.CTDiaChi}}"
    var trangthai = trangThaiDH.TrangThaiDH
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, "")
                    }
                },
                title = {
                    Text(
                        "Chi tiết đơn hàng",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
            )
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(lisdetail){
                OrderDetailCard(detailDonHang = it,nguoinhan,SDT,diaChi,trangthai)
            }
        }
    }
}