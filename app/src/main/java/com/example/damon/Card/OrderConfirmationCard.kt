package com.example.damon.Card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
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
import com.example.damon.DataClass.DonHang
import com.example.damon.R

@Composable
fun OrderConfirmationCard( donHang: DonHang,onClick: () -> Unit) {
    val quantity = 3
    var trangthai by remember { mutableStateOf("") }
    if(donHang.TrangThaiDH==1){
        trangthai = "Chờ xác nhận"
    }else{
        if (donHang.TrangThaiDH==2){
            trangthai = "Chờ lấy hàng"
        }else{
            if (donHang.TrangThaiDH==3){
                trangthai = "Chờ giao hàng"
            }else{
                if (donHang.TrangThaiDH==4){
                    trangthai = "Đánh giá"
                }else{
                    trangthai = "Hủy đơn hàng"
                }
            }
        }
    }
    Box(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFCECECE)
            ),
            shape = RoundedCornerShape(12.dp),
            onClick = {onClick}
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                // Order ID and status row
                Spacer(modifier = Modifier.height(16.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Mã đơn hàng: ${donHang.MaDH}",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(

                            text = "Trạng thái: $trangthai",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp
                            )
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .size(50.dp)
                            .background(Color.Gray, shape = RoundedCornerShape(50))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.clipboard_list_solid),
                            contentDescription = "Chi tiết đơn hàng",
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                if (trangthai == "Chờ xác thực") {
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = { },
                            modifier = Modifier
                                .width(140.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(15.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Red,
                                contentColor = Color.White
                            )
                        ) {
                            Text(
                                text = "Xác thực",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Button(
                            onClick = { },
                            modifier = Modifier
                                .width(140.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(15.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Gray,
                                contentColor = Color.White
                            )
                        ) {
                            Text(
                                text = "Hủy",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

        Text(
            text = "x$quantity",
            style = TextStyle(
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(12.dp)
                .background(Color.Red, shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 8.dp, vertical = 2.dp)
        )
    }
}
