package com.example.damon.Screen


import android.annotation.SuppressLint
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
import com.example.damon.Navigation.ScreenRoute


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun LoginScreen(navController: NavController,){
    var TaiKhoan by remember { mutableStateOf<String>("") }
    var MatKhau by remember { mutableStateOf<String>("") }
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
            Text(text = "Quên mật khẩu?",
                modifier = Modifier
                    .clickable { /*TODO*/ },
                color = Color.Blue
            )
            Text(text = "Tạo Tài Khoản",
                modifier = Modifier
                    .clickable { navController.navigate(ScreenRoute.Register.route) },
                color = Color.Blue
            )
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier
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
}