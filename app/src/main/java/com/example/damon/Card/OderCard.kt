package com.example.damon.Card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.damon.DataClass.DonHang
import com.example.damon.DataClass.NguoiDung
import com.example.damon.R
import com.example.damon.ViewModel.AllViewModel

@Composable
fun OderCard(donHang: DonHang,onClickCard: () -> Unit,viewModel: AllViewModel) {
    var donhang:DonHang = donHang
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
            onClick = onClickCard
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
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

                if (donhang.TrangThaiDH==1) {
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = {
                                donhang.TrangThaiDH=5
                                viewModel.editDonHang(donHang.MaDH,donhang)
                            },
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
    }
}