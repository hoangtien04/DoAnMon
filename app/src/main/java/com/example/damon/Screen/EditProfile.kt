package com.example.damon.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.damon.DataClass.NguoiDung
import com.example.damon.ViewModel.AllViewModel
import androidx.compose.material.DropdownMenuItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun EditProfile(navController: NavController, viewModel: AllViewModel) {
    var nguoidung: NguoiDung = viewModel.nguoidungtaikhoan
    var email by remember { mutableStateOf(nguoidung.Email) }
    var fullName by remember { mutableStateOf(nguoidung.HoTen) }
    var phoneNumber by remember { mutableStateOf(nguoidung.SDT) }
    var NgaySinh by remember { mutableStateOf(nguoidung.NgaySinh) }
    var expanded by remember { mutableStateOf(false) }
    var selectedGender by remember { mutableStateOf("Chọn giới tính") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Chỉnh sửa hồ sơ ") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "", tint = Color.Black)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray, titleContentColor = Color.Black)
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = Color(0xFFF5F5F5))
        ) {
            item { EditTextField(label = "Địa chỉ email", value = email, onValueChange = { email = it }) }
            item { EditTextField(label = "Họ Tên", value = fullName, onValueChange = { fullName = it }) }
            item { EditTextField(label = "Số điện thoại", value = phoneNumber, onValueChange = { phoneNumber = it }) }
            item { EditTextField(label = "Ngày Sinh", value = NgaySinh, onValueChange = { NgaySinh = it }) }

            item {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "Giới tính",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 10.dp),
                        color = Color.Black
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(Color.White)
                            .clickable { expanded = true }
                            .padding(horizontal = 16.dp, vertical = 12.dp)
                    ) {
                        Text(text = selectedGender, color = Color.Black)
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                    ) {
                        val genders = listOf("Nam", "Nữ")
                        genders.forEach { gender ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedGender = gender
                                    expanded = false
                                }
                            ) {
                                Text(text = gender,color = Color.Black)
                            }
                        }
                    }
                }
            }

            item {
                SaveButton(onClick = {
                    nguoidung.Email = email
                    nguoidung.HoTen = fullName
                    nguoidung.SDT = phoneNumber
                    nguoidung.NgaySinh = NgaySinh
                    nguoidung.GioiTinh = if(selectedGender.equals("Nam")){
                        1
                    }else{
                        0
                    }
                    viewModel.editNguoiDung(nguoidung.MaND, nguoidung = nguoidung)
                }
                )
            }
        }
    }
}

@Composable
fun EditTextField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(text = label, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Black, RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.colors(focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent),
            shape = RoundedCornerShape(8.dp),
            placeholder = { Text(text = "Nhập $label") }
        )
    }
}



@Composable
fun SaveButton(onClick: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .padding(20.dp)
                .width(250.dp)
                .height(55.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red, contentColor = Color.White)
        ) {
            Text(text = "Lưu", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}
