package com.example.damon.Screen


import android.annotation.SuppressLint

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.damon.DataClass.NguoiDung
import com.example.damon.Navigation.ScreenRoute
import com.example.damon.ViewModel.AllViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavHostController, viewModel: AllViewModel){
    var TaiKhoan by remember { mutableStateOf<String>("") }
    var MatKhau by remember { mutableStateOf<String>("") }
    var showDialog by remember { mutableStateOf(false) }
    var isSuccess by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "ĐĂNG NHẬP", fontSize = 35.sp, fontWeight = FontWeight.Bold)
        TextField(
            value = TaiKhoan,
            onValueChange = {TaiKhoan = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 15.dp, end = 15.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.LightGray
            ),
            shape = RoundedCornerShape(12.dp),
            label = {Text(text = "Tài Khoản")}
        )
        TextField(
            value = MatKhau,
            onValueChange = {MatKhau = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.LightGray
            ),
            shape = RoundedCornerShape(12.dp),
            label = {Text(text = "Mật Khẩu")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
        Row(modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),horizontalArrangement = Arrangement.SpaceBetween ){
            Text(text = "",
                modifier = Modifier
                    .clickable {navController.navigate(ScreenRoute.comfirmPassword.route)},
                color = Color.Blue
            )
            Text(text = "Tạo Tài Khoản",
                modifier = Modifier
                    .clickable { navController.navigate(ScreenRoute.Register.route) },
                color = Color.Blue
            )
        }
        Button(
            onClick = {
                CoroutineScope(Dispatchers.Main).launch {
                viewModel.getNguoiDungByTaiKhoanMatKhau(TaiKhoan, MatKhau)
                    delay(800)
                val nguoiDung: NguoiDung = viewModel.nguoidungdangnhap
                if (nguoiDung.MaND == 0) {
                    isSuccess = false
                    errorMessage = "Tên đăng nhập hoặc mật khẩu không đúng."
                } else {
                    viewModel.nguoidungtaikhoan = nguoiDung
                    isSuccess = true
                }
                showDialog = true
                viewModel.kiemtratrangthai()
                }
            },
            modifier = Modifier
                .padding(top = 35.dp)
                .width(250.dp)
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                text = "ĐĂNG NHẬP",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }

    if (showDialog) {
        handleLoginResult(
            isSuccess = isSuccess,
            errorMessage = errorMessage,
            onDismiss = { showDialog = false },
            navController
        )
    }
}

@Composable
fun showSuccessDialog(onDismiss: () -> Unit,navController: NavController) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Đăng Nhập Thành Công") },
        text = { Text(text = "Chào mừng bạn đã đăng nhập thành công!") },
        confirmButton = {
            Button(onClick = {
                onDismiss()
                navController.navigate(ScreenRoute.Main.route)
            }) {
                Text("OK")
            }
        }
    )
}

@Composable
fun showFailureDialog(errorMessage: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Đăng Nhập Thất Bại") },
        text = { Text(text = "Đăng nhập không thành công. \nLỗi: $errorMessage") },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Thử lại")
            }
        }
    )
}


@Composable
fun handleLoginResult(
    isSuccess: Boolean,
    errorMessage: String = "",
    onDismiss: () -> Unit,
    navController: NavController
) {
    if (isSuccess) {
        showSuccessDialog(onDismiss = onDismiss,navController)
    } else {
        showFailureDialog(errorMessage = errorMessage, onDismiss = onDismiss)
    }
}