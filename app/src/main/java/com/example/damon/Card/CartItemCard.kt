package com.example.damon.Card

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.damon.DataClass.GioHang
import com.example.damon.R
import com.example.damon.ViewModel.AllViewModel
import com.example.damon.ViewModel.SanPhamViewModel

@Composable
fun CartItemCard(gioHang: GioHang, viewModel: AllViewModel,viewModel2: SanPhamViewModel) {

    var soLuong by remember { mutableStateOf(gioHang.SoLuong) }
    var showDeleteConfirmation by remember { mutableStateOf(false) }

    if (showDeleteConfirmation) {
        AlertDialog(
            onDismissRequest = { showDeleteConfirmation = false },
            title = { Text("Xác nhận xóa") },
            text = { Text("Bạn có chắc muốn xóa sản phẩm này khỏi giỏ hàng?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        Log.d("CartItemCard", "Delete confirmed")
                        viewModel2.deleteCartItem(
                            viewModel.nguoidungdangnhap.MaND,
                            gioHang.MaCTSP
                        )
                        showDeleteConfirmation = false
                    }
                ) {
                    Text("Xóa")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteConfirmation = false }) {
                    Text("Hủy")
                }
            }
        )
    }
    Card(
        modifier = Modifier.padding(7.dp,3.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row {
                AsyncImage(
                    model = gioHang.DuongDan,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .weight(4f)
                        .size(120.dp)
                )
                Column(
                    modifier = Modifier
                        .weight(6f)
                        .padding(start = 16.dp)
                ) {
                    Text(
                        gioHang.TenSP,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                    Text(
                        "Màu sắc: ${gioHang.TenMau}",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                        )
                    )
                    Text(
                        "Size: ${gioHang.Size}",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                        )
                    )
                    Text(
                        "Số lượng: ${gioHang.SoLuong}",
                        style = TextStyle(
                            fontSize = 16.sp,
                        )
                    )
                    Text(
                        "Đơn giá: ${gioHang.DonGia} VND",
                        style = TextStyle(
                            color = Color.Red,
                            fontSize = 16.sp,
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Column(modifier = Modifier.weight(5f)) {
                    Text(
                        text = "TỔNG: ${soLuong * gioHang.DonGia} VND",
                        style = TextStyle(
                            color = Color.Red,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    IconButton(
                        onClick = {
                            viewModel2.deleteCartItem(viewModel.nguoidungdangnhap.MaND,gioHang.MaCTSP)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Xóa sản phẩm",
                            tint = Color.Red,
                            modifier = Modifier
                                .size(28.dp)
                                .clickable { showDeleteConfirmation = true }
                        )
                    }
                }
            }
        }
    }
}