package com.example.damon.Screen


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
@OptIn(ExperimentalMaterial3Api::class)
fun EditProfile() {
    val scrollState = rememberScrollState()
    var lsGenders = mutableListOf("Nam", "Nữ", "Khác")
    var selection by remember {mutableStateOf(lsGenders[0])}
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Chỉnh sửa hồ sơ ") },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
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
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)
            .fillMaxWidth()
            .background(color = Color(0xFFF5F5F5))
            .verticalScroll(rememberScrollState())
        ) {
            Text(text = "Địa chỉ email",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.padding(start = 10.dp, end = 10.dp).fillMaxWidth().border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
            )

            Text(text = "Tên",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.padding(start = 10.dp, end = 10.dp).fillMaxWidth().border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
            )

            Text(text = "Họ",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.padding(start = 10.dp, end = 10.dp).fillMaxWidth().border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
            )

            Text(text = "Tỉnh/Thành phố",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.padding(start = 10.dp, end = 10.dp).fillMaxWidth().border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
            )

            Text(text = "Quận/Huyện",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.padding(start = 10.dp, end = 10.dp).fillMaxWidth().border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
            )

            Text(text = "Xã/Phường",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.padding(start = 10.dp, end = 10.dp).fillMaxWidth().border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
            )

            Text(text = "Chi tiết địa chỉ",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.padding(start = 10.dp, end = 10.dp).fillMaxWidth().border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
            )
            Text(text = "Số điện thoại",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.padding(start = 10.dp, end = 10.dp).fillMaxWidth().border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Column(modifier = Modifier.padding(start = 10.dp)){
                Text(text = "Giới tính",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
                lsGenders.forEach{
                        gender -> Row(
                    modifier = Modifier.fillMaxWidth()
                ){
                    RadioButton(
                        selected = gender == selection,
                        onClick = {selection = gender},
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Black,
                        )
                    )
                    Text(text = gender, modifier = Modifier.padding(start = 5.dp, top = 15.dp))
                }
                }
            }
            Button(onClick = {},
                modifier = Modifier
                    .padding(20.dp)
                    .width(250.dp)
                    .height(55.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Lưu",  fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

        }
    }

}