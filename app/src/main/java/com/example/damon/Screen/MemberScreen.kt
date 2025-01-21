package com.example.damon.Screen


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.damon.DataClass.NguoiDung
import com.example.damon.Navigation.ScreenRoute
import com.example.damon.ViewModel.AllViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MemberScreen(navController: NavController,viewModel: AllViewModel) {
    if (viewModel.nguoidungdangnhap.Email == null){
        viewModel.nguoidungdangnhap.Email = ""
        viewModel.nguoidungdangnhap.HoTen = "Chưa cập nhật"
        viewModel.nguoidungdangnhap.SDT = ""
        viewModel.nguoidungdangnhap.NgaySinh = ""
        viewModel.nguoidungdangnhap.GioiTinh = 1
    }
    var nguoidung:NguoiDung = viewModel.nguoidungdangnhap
    var email by remember { mutableStateOf(nguoidung.Email) }
    var fullName by remember { mutableStateOf(nguoidung.HoTen) }
    var phoneNumber by remember { mutableStateOf(nguoidung.SDT) }
    var NgaySinh by remember { mutableStateOf(nguoidung.NgaySinh) }
    var TaiKhoan by remember { mutableStateOf(nguoidung.TaiKhoan) }
    var gender by remember { mutableStateOf(nguoidung.GioiTinh) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Hồ Sơ") },
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
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .fillMaxWidth()
                .background(color = Color(0xFFF5F5F5))
        ) {
            item {
                ProfileField(label = "Địa chỉ email", value = email)
            }
            item {
                ProfileField(label = "Họ Tên", value = fullName)
            }
            item {
                ProfileField(label = "Số điện thoại", value = phoneNumber)
            }
            item {
                ProfileField(label = "Ngày Sinh", value = NgaySinh)
            }
            item {
                ProfileField(label = "Tài Khoản", value = TaiKhoan)
            }
            item {
                ProfileField(label = "Giới tính", value = if(gender==1){
                    "Nam"
                }else{
                    "Nữ"
                }
                )
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            navController.navigate(ScreenRoute.EditProfile.route)
                        },
                        modifier = Modifier
                            .padding(20.dp)
                            .width(250.dp)
                            .height(55.dp),
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red,
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Chỉnh sửa",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileField(label: String, value: String) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            text = label,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 5.dp),
            color = Color.Black
        )
        Text(
            text = value,
            fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .background(color = Color.White)
                .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                .padding(10.dp),
            color = Color.Black
        )
    }
}
