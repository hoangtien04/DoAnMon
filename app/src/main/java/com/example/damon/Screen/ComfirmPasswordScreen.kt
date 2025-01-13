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

@Composable
fun ComfirmPasswordScreen(navController: NavHostController){
    var MatKhauCu by remember { mutableStateOf<String>("") }
    var MatKhauMoi by remember { mutableStateOf<String>("") }
    var NhapLaiMatKhauMoi by remember { mutableStateOf<String>("") }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text ="ĐỔI MẬT KHẨU", fontSize = 35.sp, fontWeight = FontWeight.Bold)

        TextField(value = MatKhauCu,
            onValueChange = {MatKhauCu = it},
            modifier = Modifier.fillMaxWidth().padding(top = 50.dp, start = 15.dp, end = 15.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.LightGray
            ),
            label = { Text(text = "Mật khẩu cũ")},
            shape = RoundedCornerShape(12.dp)

        )
        TextField(value = MatKhauMoi,
            onValueChange = {MatKhauMoi = it},
            modifier = Modifier.fillMaxWidth().padding(top = 15.dp, start = 15.dp, end = 15.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.LightGray
            ),
            label = { Text(text = "Mật khẩu mới")},
            shape = RoundedCornerShape(12.dp)

        )
        TextField(value = NhapLaiMatKhauMoi,
            onValueChange = {NhapLaiMatKhauMoi = it},
            modifier = Modifier.fillMaxWidth().padding(top = 15.dp, start = 15.dp, end = 15.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.LightGray
            ),
            label = { Text(text = "Nhập lại mật khẩu mới")},
            shape = RoundedCornerShape(12.dp)
        )
        Button(onClick = { /*TODO*/ },
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
    }
}