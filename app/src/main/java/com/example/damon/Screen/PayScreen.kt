package com.example.damon.Screen


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.damon.R
import org.jetbrains.annotations.Async

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun PayScreen(navController: NavController){
    var lsGenders = mutableListOf("Thanh toán khi nhận hàng", "Thanh toán qua MoMo", "Thanh toán qua QR Code")
    var selection by remember {mutableStateOf(lsGenders[0])}
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Thanh toán") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.LightGray,
                    titleContentColor = Color.Black
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                contentColor = Color.Black,
            ) {
                Row (modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(modifier = Modifier.width(250.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Tổng thanh toán", fontSize = 18.sp)
                        Text(text = "315000 VND", color = Color.Red, modifier = Modifier.padding(top = 5.dp), fontSize = 15.sp)
                    }
                    Button(onClick = {},modifier = Modifier
                        .width(140.dp)
                        .height(58.dp),
                        shape = RoundedCornerShape(11.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red,
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "ĐẶT HÀNG",

                            )

                    }
                }
            }
        }
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF5F5F5))
            .padding(it)
            .verticalScroll(rememberScrollState())
        ){
            Card(modifier = Modifier.padding(10.dp)
            ){
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFD9D9D9)),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Column(modifier = Modifier.padding(10.dp)){
                        Text(text = "Hoàng Tiến", fontSize = 20.sp)
                        Text(text = "417/69/27 Quang Trung", fontSize = 15.sp, modifier = Modifier.padding(top = 5.dp))
                        Text(text = "Phường 10, Quận Gò Vấp, Tp, Hồ Chí Minh", fontSize = 15.sp, modifier = Modifier.padding(top = 5.dp))
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = "")
                    }
                }
            }
            Card(modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFD9D9D9))
                    .drawBehind {
                        val lineHeight = 145.dp.toPx()
                        drawLine(
                            color = Color(0xFF8B8B8B),
                            start = Offset(30f, lineHeight), // bắt đầu từ bên trái
                            end = Offset(size.width - 30f, lineHeight), // đến hết bên phải
                            strokeWidth = 4f,
                        )
                    },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Image(
                        painter = painterResource(id = R.drawable.anh1),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .weight(4f)
                            .size(150.dp)
                            .padding(10.dp)
                    )
                    Column(
                        modifier = Modifier
                            .weight(6f)
                            .padding(top = 10.dp, bottom = 10.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            "Áo khoác dù",
                            style = TextStyle(
                                color = Color.Black,
                                 fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            "Màu sắc: Đen",
                            style = TextStyle(
                                color = Color.Gray,
                                fontSize = 15.sp,
                            )
                        )
                        Spacer(modifier = Modifier.height(7.dp))
                        Text(
                            "Kích cỡ: Nam M",
                            style = TextStyle(
                                color = Color.Gray,
                                fontSize = 15.sp,
                            )
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        Row(horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth().padding(end = 20.dp)){
                            Text(
                                "150000 VND",
                                style = TextStyle(
                                    color = Color.Red,
                                    fontSize = 16.sp,
                                )
                            )
                            Text(text = "x1")
                        }

                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFD9D9D9))
                    .drawBehind {
                        val lineHeight = 147.dp.toPx()
                        drawLine(
                            color = Color(0xFF8B8B8B),
                            start = Offset(30f, lineHeight), // bắt đầu từ bên trái
                            end = Offset(size.width - 30f, lineHeight), // đến hết bên phải
                            strokeWidth = 4f,
                        )
                    },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Image(
                        painter = painterResource(id = R.drawable.anh1),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .weight(4f)
                            .size(150.dp)
                            .padding(10.dp)
                    )
                    Column(
                        modifier = Modifier
                            .weight(6f)
                            .padding(top = 10.dp, bottom = 10.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            "Áo khoác dù",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            "Màu sắc: Đen",
                            style = TextStyle(
                                color = Color.Gray,
                                fontSize = 15.sp,
                            )
                        )
                        Spacer(modifier = Modifier.height(7.dp))
                        Text(
                            "Kích cỡ: Nam M",
                            style = TextStyle(
                                color = Color.Gray,
                                fontSize = 15.sp,
                            )
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        Row(horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth().padding(end = 20.dp)){
                            Text(
                                "150000 VND",
                                style = TextStyle(
                                    color = Color.Red,
                                    fontSize = 16.sp,
                                )
                            )
                            Text(text = "x1")
                        }
                    }
                }
            }
            Card(modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp)){
                Column(modifier = Modifier.fillMaxSize().background(Color(0xFFD9D9D9)).padding(15.dp)){
                    Text(text = "Phương thức thanh toán", modifier = Modifier.padding(bottom = 10.dp), fontSize = 18.sp)
                    lsGenders.forEach{
                            gender -> Row(
                        modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = gender, modifier = Modifier.padding(start = 20.dp, top = 10.dp))
                        RadioButton(
                            selected = gender == selection,
                            onClick = {selection = gender},
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                            )
                        )

                    }
                    }
                }
            }
            Card(modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp)){
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFD9D9D9))
                    .padding(15.dp)
                ){
                    Text(text = "Chi tiết thanh toán", fontSize = 18.sp)
                    Row(modifier = Modifier.fillMaxWidth().padding(start = 20.dp, top = 10.dp), horizontalArrangement = Arrangement.SpaceBetween){
                        Text(text = "Tổng tiền hàng")
                        Text(text = "300000 VND")
                    }
                    Row(modifier = Modifier.fillMaxWidth().padding(start = 20.dp, top = 10.dp), horizontalArrangement = Arrangement.SpaceBetween){
                        Text(text = "Phí vận chuyển")
                        Text(text = "15000 VND")
                    }
                    Row(modifier = Modifier.fillMaxWidth().padding(start = 20.dp, top = 10.dp), horizontalArrangement = Arrangement.SpaceBetween){
                        Text(text = "Tổng tiền hàng")
                        Text(text = "315000 VND")
                    }
                }
            }
        }
    }
}