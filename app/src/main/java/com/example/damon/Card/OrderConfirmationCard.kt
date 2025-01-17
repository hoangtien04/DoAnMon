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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.damon.DataClass.DonHang
import com.example.damon.R
import com.example.damon.ViewModel.AllViewModel

@Composable
fun OrderConfirmationCard( donHang: DonHang,onClickCard: () -> Unit,viewModel: AllViewModel) {
    var Nut by remember { mutableStateOf("") }
    var trangthai by remember { mutableStateOf("") }
    if(donHang.TrangThaiDH==1){
        trangthai = "Chờ xác nhận"
        Nut = "Xác thực"
    }else{
        if (donHang.TrangThaiDH==2){
            trangthai = "Chờ lấy hàng"
            Nut = "Hoàn tất"
        }else{
            if (donHang.TrangThaiDH==3){
                trangthai = "Chờ giao hàng"
                Nut = "Đã giao"
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

                if(donHang.TrangThaiDH==1||donHang.TrangThaiDH==2||donHang.TrangThaiDH==3){
                Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = {
                                when (donHang.TrangThaiDH) {
                                    1 -> viewModel.editTrangThaiDonHang(2, donHang.MaDH)
                                    2 -> viewModel.editTrangThaiDonHang(3, donHang.MaDH)
                                    3 -> viewModel.editTrangThaiDonHang(4, donHang.MaDH)
                                }

                                viewModel.getAllDonHang()

                            },
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
                                text = Nut,
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
