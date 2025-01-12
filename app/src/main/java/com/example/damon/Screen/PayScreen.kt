package com.example.damon.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.damon.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
@OptIn(ExperimentalMaterial3Api::class)
fun PayScreen() {
    val paymentMethods = listOf("Thanh toán khi nhận hàng", "Thanh toán qua MoMo", "Thanh toán qua QR Code")
    var selectedMethod by remember { mutableStateOf(paymentMethods[0]) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Thanh toán") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, tint = Color.Black)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray, titleContentColor = Color.Black)
            )
        },
        bottomBar = {
            BottomAppBar(containerColor = Color.White, contentColor = Color.Black) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        modifier = Modifier.width(250.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Tổng thanh toán", fontSize = 18.sp)
                        Text("315000 VND", color = Color.Red, fontSize = 15.sp, modifier = Modifier.padding(top = 5.dp))
                    }
                    Button(
                        onClick = {  },
                        modifier = Modifier.size(140.dp, 58.dp),
                        shape = RoundedCornerShape(11.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red, contentColor = Color.White)
                    ) {
                        Text("ĐẶT HÀNG")
                    }
                }
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(it)
        ) {
            item { AddressCard() }
            item { ProductList() }
            item { PaymentMethods(paymentMethods, selectedMethod) { selectedMethod = it } }
            item { PaymentDetails() }
        }
    }
}

@Composable
fun AddressCard() {
    Card(Modifier.padding(10.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFD9D9D9)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.padding(10.dp)) {
                Text("Hoàng Tiến", fontSize = 20.sp)
                Text("417/69/27 Quang Trung", fontSize = 15.sp, modifier = Modifier.padding(top = 5.dp))
                Text("Phường 10, Quận Gò Vấp, Tp, Hồ Chí Minh", fontSize = 15.sp, modifier = Modifier.padding(top = 5.dp))
            }
            IconButton(onClick = {  }) {
                Icon(Icons.Default.ChevronRight, contentDescription = null)
            }
        }
    }
}

@Composable
fun ProductList() {
    val productModifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFFD9D9D9))
        .drawBehind {
            val lineHeight = 145.dp.toPx()
            drawLine(
                color = Color(0xFF8B8B8B),
                start = Offset(30f, lineHeight),
                end = Offset(size.width - 30f, lineHeight),
                strokeWidth = 4f
            )
        }

    listOf("Áo khoác dù", "Áo khoác dù").forEach {
        Card(Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
            Row(productModifier, horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.anh1),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(4f)
                        .size(150.dp)
                        .padding(10.dp)
                )
                Column(
                    modifier = Modifier
                        .weight(6f)
                        .padding(vertical = 10.dp)
                        .fillMaxWidth()
                ) {
                    Text(it, style = TextStyle(color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold))
                    Text("Màu sắc: Đen", style = TextStyle(color = Color.Gray, fontSize = 15.sp))
                    Spacer(Modifier.height(7.dp))
                    Text("Kích cỡ: Nam M", style = TextStyle(color = Color.Gray, fontSize = 15.sp))
                    Spacer(Modifier.height(25.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("150000 VND", style = TextStyle(color = Color.Red, fontSize = 16.sp))
                        Text("x1")
                    }
                }
            }
        }
    }
}

@Composable
fun PaymentMethods(paymentMethods: List<String>, selectedMethod: String, onSelectionChange: (String) -> Unit) {
    Card(Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
        Column(Modifier.background(Color(0xFFD9D9D9)).padding(15.dp)) {
            Text("Phương thức thanh toán", fontSize = 18.sp, modifier = Modifier.padding(bottom = 10.dp))
            paymentMethods.forEach { method ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(method, Modifier.padding(start = 20.dp, top = 10.dp))
                    RadioButton(
                        selected = method == selectedMethod,
                        onClick = { onSelectionChange(method) },
                        colors = RadioButtonDefaults.colors(selectedColor = Color.Black)
                    )
                }
            }
        }
    }
}

@Composable
fun PaymentDetails() {
    Card(Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
        Column(Modifier.background(Color(0xFFD9D9D9)).padding(15.dp)) {
            Text("Chi tiết thanh toán", fontSize = 18.sp)
            Row(Modifier.fillMaxWidth().padding(start = 20.dp, top = 10.dp), Arrangement.SpaceBetween) {
                Text("Tổng tiền hàng")
                Text("300000 VND")
            }
            Row(Modifier.fillMaxWidth().padding(start = 20.dp, top = 10.dp), Arrangement.SpaceBetween) {
                Text("Phí vận chuyển")
                Text("15000 VND")
            }
            Row(Modifier.fillMaxWidth().padding(start = 20.dp, top = 10.dp), Arrangement.SpaceBetween) {
                Text("Tổng cộng")
                Text("315000 VND")
            }
        }
    }
}
