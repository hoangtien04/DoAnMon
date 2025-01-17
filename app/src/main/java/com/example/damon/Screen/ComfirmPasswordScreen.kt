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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.damon.ViewModel.AllViewModel
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextButton

@Composable
fun ComfirmPasswordScreen(navController: NavHostController, viewModel: AllViewModel) {
    var MatKhauCu by remember { mutableStateOf("") }
    var MatKhauMoi by remember { mutableStateOf("") }
    var NhapLaiMatKhauMoi by remember { mutableStateOf("") }
    var showSuccessDialog by remember { mutableStateOf(false) }
    var showErrorDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "ĐỔI MẬT KHẨU", fontSize = 35.sp, fontWeight = FontWeight.Bold)

            TextField(
                value = MatKhauCu,
                onValueChange = { MatKhauCu = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp, start = 15.dp, end = 15.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray
                ),
                label = { Text(text = "Mật khẩu cũ") },
                shape = RoundedCornerShape(12.dp)
            )
            TextField(
                value = MatKhauMoi,
                onValueChange = { MatKhauMoi = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 15.dp, end = 15.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray
                ),
                label = { Text(text = "Mật khẩu mới") },
                shape = RoundedCornerShape(12.dp)
            )
            TextField(
                value = NhapLaiMatKhauMoi,
                onValueChange = { NhapLaiMatKhauMoi = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 15.dp, end = 15.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray
                ),
                label = { Text(text = "Nhập lại mật khẩu mới") },
                shape = RoundedCornerShape(12.dp)
            )
            Button(
                onClick = {
                    if (MatKhauMoi == NhapLaiMatKhauMoi && MatKhauMoi.isNotBlank() && MatKhauCu == viewModel.nguoidungdangnhap.MatKhau) {
                        showSuccessDialog = true
                    } else {
                        showErrorDialog = true
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
                    text = "XÁC NHẬN",
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
            if (showSuccessDialog) {
                AlertDialog(
                    onDismissRequest = { showSuccessDialog = false },
                    title = { Text(text = "Thành Công") },
                    text = { Text(text = "Mật khẩu đã được thay đổi thành công.") },
                    confirmButton = {
                        TextButton(onClick = {
                            showSuccessDialog = false
                            viewModel.nguoidungtaikhoan.MatKhau = MatKhauMoi
                            viewModel.editNguoiDung(viewModel.nguoidungtaikhoan.MaND,viewModel.nguoidungtaikhoan)
                        }
                        ) {
                            Text(text = "OK")
                        }
                    }
                )
            }
            if (showErrorDialog) {
                AlertDialog(
                    onDismissRequest = { showErrorDialog = false },
                    title = { Text(text = "Thất Bại") },
                    text = { Text(text = "Mật khẩu không khớp hoặc không hợp lệ.") },
                    confirmButton = {
                        TextButton(onClick = { showErrorDialog = false }) {
                            Text(text = "OK")
                        }
                    }
                )
            }
        }
    }
}