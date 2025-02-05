package com.example.damon.Card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.damon.DataClass.DetailDonHang
import com.example.damon.ViewModel.AllViewModel

@Composable
fun OrderDetailCard(detailDonHang: DetailDonHang, nguoinhan: String, SDT: String, diachi: String, trangthai: Int) {
    var orderStatus = when (trangthai) {
        1 -> "Chờ xác nhận"
        2 -> "Chờ lấy hàng"
        3 -> "Chờ giao hàng"
        4 -> "Đánh giá"
        else -> "Hủy đơn hàng"
    }

    val totalPrice = detailDonHang.DonGia * detailDonHang.SoLuong

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = detailDonHang.DuongDan,
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(12.dp))

            // Tên sản phẩm
            Text(
                text = "Sản phẩm: ${detailDonHang.TenSP}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            // Mô tả sản phẩm
            Text(
                text = "Mô tả: ${detailDonHang.MoTa}",
                fontSize = 16.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Đơn giá
            Text(
                text = "Đơn giá: ${detailDonHang.DonGia} VND",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            // Số lượng
            Text(
                text = "Số lượng: ${detailDonHang.SoLuong}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )

            // Tổng tiền
            Text(
                text = "Tổng tiền: $totalPrice VND",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Thông tin người đặt
            Text(
                text = "Người đặt: $nguoinhan",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "Số điện thoại: $SDT",
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                text = "Địa chỉ: $diachi",
                fontSize = 16.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Trạng thái đơn hàng
                Text(
                    text = "Trạng thái đơn hàng: $orderStatus",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }
}