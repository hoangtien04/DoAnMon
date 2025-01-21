package com.example.damon.Screen


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.damon.DataClass.GioHang
import com.example.damon.Navigation.ScreenRoute
import com.example.damon.R
import com.example.damon.ViewModel.AllViewModel
import com.example.damon.ViewModel.SanPhamViewModel
import kotlinx.coroutines.delay
import org.jetbrains.annotations.Async

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

@OptIn(ExperimentalMaterial3Api::class)
fun PayScreen(navController: NavController,viewModel: AllViewModel, viewModel2: SanPhamViewModel){
    var lsGenders = mutableListOf("Thanh toán khi nhận hàng", "Thanh toán qua MoMo", "Thanh toán qua QR Code")
    var selection by remember {mutableStateOf(lsGenders[0])}
    var showPaymentConfirmation by remember { mutableStateOf(false) }
    viewModel2.getGioHang(viewModel.nguoidungdangnhap.MaND)
    val listGioHang by viewModel2.gioHang.collectAsState()

    LaunchedEffect(Unit) {
        viewModel2.getDiaChi(viewModel.nguoidungdangnhap.MaND)
    }
    val listDiaChi by viewModel2.diaChiGH.collectAsState()
    // Lấy địa chỉ đầu tiên trong danh sách (nếu có)
    val diaChi = listDiaChi.firstOrNull()
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
                        Text(text = "đ${tinhTongTien(listGioHang)} ", color = Color.Red, modifier = Modifier.padding(top = 5.dp), fontSize = 18.sp)
                    }
                    Button(onClick = {
                        diaChi?.let { dc ->
                            viewModel2.thanhToan(
                                MaND = viewModel.nguoidungdangnhap.MaND,
                                MaDC = dc.MaDC,
                                TongTien = tinhTongTien(listGioHang),
                                PhuongThucTT = selection,
                                listGioHang = listGioHang,
                                TrangThaiDH = 1
                            )
                            // Hiển thị dialog xác nhận thanh toán
                            showPaymentConfirmation = true
                        }

                    },modifier = Modifier
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
                        Text(text ="${diaChi?.NguoiNhan}", fontSize = 20.sp)
                        Text(text = "${diaChi?.CTDiaChi}", fontSize = 15.sp, modifier = Modifier.padding(top = 5.dp))
                        Text(text = "${diaChi?.PhuongXa}, ${diaChi?.QuanHuyen}, ${diaChi?.TinhThanh}", fontSize = 15.sp, modifier = Modifier.padding(top = 5.dp))
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = "")
                    }
                }
            }
            Card( modifier = Modifier
                .padding(horizontal = 10.dp)
                .height(300.dp)) {
                LazyColumn {
                    items(listGioHang) { giohang ->

                        Card(
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color(0xFFD9D9D9))
                                    .drawBehind {
                                        val lineHeight = 145.dp.toPx()
                                        drawLine(
                                            color = Color(0xFF8B8B8B),
                                            start = Offset(30f, lineHeight), // bắt đầu từ bên trái
                                            end = Offset(
                                                size.width - 30f,
                                                lineHeight
                                            ), // đến hết bên phải
                                            strokeWidth = 4f,
                                        )
                                    },
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                AsyncImage(
                                    model = giohang.DuongDan,
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
                                        giohang.TenSP,
                                        style = TextStyle(
                                            color = Color.Black,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    Text(
                                        "Màu sắc:  ${giohang.TenMau}",
                                        style = TextStyle(
                                            color = Color.Gray,
                                            fontSize = 15.sp,
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(7.dp))
                                    Text(
                                        "Size:  ${giohang.Size}",
                                        style = TextStyle(
                                            color = Color.Gray,
                                            fontSize = 15.sp,
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(25.dp))
                                    Row(
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier.fillMaxWidth().padding(end = 20.dp)
                                    ) {
                                        Text(
                                            "${giohang.DonGia}",
                                            style = TextStyle(
                                                color = Color.Red,
                                                fontSize = 16.sp,
                                            )
                                        )
                                        Text(text = "${giohang.SoLuong}")
                                    }
                                }
                            }
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
    fun tinhTongTien(listGioHang: List<GioHang>): Int {
        var tongTien = 0
        for (gioHang in listGioHang) {
            tongTien += gioHang.SoLuong * gioHang.DonGia
        }
        return tongTien
    }
    if (showPaymentConfirmation) {
        PaymentConfirmationDialog(
            navController = navController,
            viewModel = viewModel,
            viewModel2 = viewModel2,
            onDismiss = { showPaymentConfirmation = false }
        )
    }
}
@Composable
fun PaymentConfirmationDialog(
    navController: NavController,
    viewModel: AllViewModel,
    viewModel2: SanPhamViewModel,
    onDismiss: () -> Unit
) {
    var countdown by remember { mutableStateOf(3) }

    // Đếm ngược và điều hướng
    LaunchedEffect(Unit) {
        while (countdown > 0) {
            delay(1000)
            countdown--
        }
        // Sau khi đếm ngược xong, điều hướng về màn hình giỏ hàng
        navController.navigate(ScreenRoute.Oder.createRoute(0)) {
            popUpTo(ScreenRoute.PayScreen.route) { inclusive = true }
        }
        onDismiss()
    }

    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Thanh toán thành công!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Green,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                Text(
                    text = "Bạn sẽ được chuyển về trang đơn hàng sau $countdown giây",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                Row {
                    Button(
                        onClick = {
                            // Điều hướng ngay lập tức
                            navController.navigate(ScreenRoute.Oder.createRoute(0)) {
                                popUpTo(ScreenRoute.PayScreen.route) { inclusive = true }
                            }
                            onDismiss()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red
                        )
                    ) {
                        Text("Đi đến Đơn hàng")
                    }
                }
            }
        }
    }
}