package com.example.damon.Card

import Product
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
import com.example.damon.DataClass.GioHang
import com.example.damon.R
import com.example.damon.ViewModel.AllViewModel

@Composable
fun CartItemCard(gioHang: GioHang, viewModel: AllViewModel) {

    var soLuong by remember { mutableStateOf(gioHang.SoLuongTrongGio) }
    var donGia = gioHang.DonGia

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
                Image(
                    painter = painterResource(id = R.drawable.anh1),
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
                        "Áo khoác dù",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                    Text(
                        "Màu sắc: Đen",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                        )
                    )
                    Text(
                        "Kích cỡ: Nam M",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                        )
                    )
                    Text(
                        "Đơn giá: ${donGia} VND",
                        style = TextStyle(
                            color = Color.Red,
                            fontSize = 16.sp,
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        IconButton(
                            onClick = {

                                if (soLuong > 1) {
                                    soLuong--
                                    gioHang.SoLuongTrongGio = soLuong
                                    viewModel.editGioHang(viewModel.nguoidungdangnhap.MaND,gioHang.MaCTSP,gioHang)
                                }
                            },
                            modifier = Modifier.size(40.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.minus_solid),
                                contentDescription = "Decrease quantity",
                                modifier = Modifier.size(25.dp)
                            )
                        }

                        Text(
                            text = soLuong.toString(),
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .align(Alignment.CenterVertically)
                        )

                        IconButton(
                            onClick = {
                                soLuong++
                                gioHang.SoLuongTrongGio = soLuong
                                viewModel.editGioHang(viewModel.nguoidungdangnhap.MaND,gioHang.MaCTSP,gioHang)
                            },
                            modifier = Modifier.size(40.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Increase quantity"
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "TỔNG: ${soLuong * donGia} VND",
                style = TextStyle(
                    color = Color.Red,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
