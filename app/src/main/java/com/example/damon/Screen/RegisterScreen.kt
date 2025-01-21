package com.example.damon.Screen

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
import com.example.damon.Navigation.ScreenRoute
import com.example.damon.ViewModel.AllViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(navController: NavController, viewModel: AllViewModel) {
    var TaiKhoan by remember { mutableStateOf<String>("") }
    var MatKhau by remember { mutableStateOf<String>("") }
    var NhapLaiMatKhau by remember { mutableStateOf<String>("") }
    var showDialog by remember { mutableStateOf(false) } // State to show/hide the failure dialog
    var showSuccessDialog by remember { mutableStateOf(false) } // State to show/hide the success dialog
    var errorMessage by remember { mutableStateOf<String?> (null) } // State for error message

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "ĐĂNG KÝ", fontSize = 35.sp, fontWeight = FontWeight.Bold)

        TextField(
            value = TaiKhoan,
            onValueChange = { TaiKhoan = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 15.dp, end = 15.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.LightGray
            ),
            label = { Text(text = "Tài Khoản") },
            shape = RoundedCornerShape(12.dp)
        )
        TextField(
            value = MatKhau,
            onValueChange = { MatKhau = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 15.dp, end = 15.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.LightGray
            ),
            label = { Text(text = "Mật khẩu") },
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
        TextField(
            value = NhapLaiMatKhau,
            onValueChange = { NhapLaiMatKhau = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 15.dp, end = 15.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.LightGray
            ),
            label = { Text(text = "Nhập lại mật khẩu") },
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
        if (errorMessage != null) {
            Text(text = errorMessage ?: "", color = Color.Red, fontSize = 14.sp)
        }
        Button(
            onClick = {
                CoroutineScope(Dispatchers.Main).launch {
                viewModel.kiemtrataikhoan(TaiKhoan)
                    delay(300)

                if (MatKhau != NhapLaiMatKhau || MatKhau.isEmpty()) {
                    errorMessage = "Mật khẩu và nhập lại mật khẩu không khớp hoặc bị trống"
                } else {
                    errorMessage = null
                    if (viewModel.dangky != 0) {
                        showDialog = true
                    } else {
                        viewModel.dangky(TaiKhoan, MatKhau)
                        showSuccessDialog = true
                    }
                }
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
                text = "ĐĂNG KÝ",
                fontSize = 18.sp,
                color = Color.White
            )
        }
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text(text = "Đăng Ký Thất Bại") },
                text = { Text("Tài khoản đã tồn tại. Vui lòng chọn tài khoản khác.") },
                confirmButton = {
                    Button(
                        onClick = { showDialog = false },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text("OK")
                    }
                }
            )
        }
        if (showSuccessDialog) {
            AlertDialog(
                onDismissRequest = { showSuccessDialog = false },
                title = { Text(text = "Đăng Ký Thành Công") },
                text = { Text("Bạn đã đăng ký thành công.") },
                confirmButton = {
                    Button(
                        onClick = {
                            showSuccessDialog = false
                            navController.navigate(ScreenRoute.Login.route)
                        },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text("OK")
                    }
                }
            )
        }
    }
}