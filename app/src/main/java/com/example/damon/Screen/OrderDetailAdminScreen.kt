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
import com.example.damon.DataClass.DetailDonHang
import com.example.damon.DataClass.DiaChiNhanHang
import com.example.damon.DataClass.Product
import com.example.damon.R
import com.example.damon.ViewModel.AllViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderDetailAdminScreen(navController: NavController, viewModel: AllViewModel, id: Int = 0) {
    viewModel.getChiTietDonHangByMaDH(id)
    val lisdetail = viewModel.listDetailDonHang
    viewModel.getDiaChiByDonHang(id)
    val diaChiNhanHang: DiaChiNhanHang = viewModel.diachihang
    viewModel.getTrangThaiByDonHang(id)
    val trangThaiDH: TrangThaiDH = viewModel.trangthaidonhang

    val nguoinhan = diaChiNhanHang.NguoiNhan
    val SDT = diaChiNhanHang.SDT
    val diaChi = "${diaChiNhanHang.TinhThanh} ${diaChiNhanHang.QuanHuyen} ${diaChiNhanHang.PhuongXa} ${diaChiNhanHang.CTDiaChi}"
    val trangthai = trangThaiDH.TrangThaiDH

    val totalAmount = lisdetail.sumOf { it.DonGia * it.SoLuong }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
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
            items(lisdetail) { detail ->
                OrderDetailCard(detailDonHang = detail, nguoinhan, SDT, diaChi, trangthai)
            }
            item {
                TotalAmountRow(totalAmount)
            }
        }
    }
}

@Composable
fun TotalAmountRow(totalAmount: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Tổng giá trị đơn hàng:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "$totalAmount VND",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
    }
}