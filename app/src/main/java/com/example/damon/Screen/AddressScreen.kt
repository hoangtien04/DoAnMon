package com.example.damon.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.tooling.preview.Preview


@Preview
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddressScreen(onBackClick: () -> Unit = {}) {
    val addresses = listOf(
        Address(
            name = "Vương Tâm",
            phone = "(+84)90******30",
            address = "...",
            isDefault = true
        ),
        Address(
            name = "Vương Tâm",
            phone = "(+84)90******30",
            address = "30 Hoàng Diệu, Long Khánh, Xuân Thanh, Long Khánh, Tỉnh Đồng Nai, Việt Nam",
            isDefault = false
        ),
        Address(
            name = "Vương Tâm",
            phone = "(+84)09******30",
            address = "Số nhà 85 đường 52 Khu phố 2 P An Phú, An Phú, Quận 2, Thành phố Hồ Chí Minh, Việt Nam",
            isDefault = false
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Địa chỉ của bạn", fontSize = 18.sp) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {

            AddAddressButton {}


            addresses.forEach { address ->
                AddressCard(address = address, onEditClick = {  })
            }
        }
    }
}

@Composable
fun AddAddressButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
    ) {
        Text(text = "+ Thêm địa chỉ", fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun AddressCard(address: Address, onEditClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .background(Color.White),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = address.name,
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black), // Giảm kích thước font
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                    Text(
                        text = address.phone,
                        color = Color.Gray,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                    Text(
                        text = address.address,
                        color = Color.Black,
                        fontSize = 12.sp,
                        maxLines = 2
                    )
                    if (address.isDefault) {
                        Text(
                            "Mặc định",
                            color = Color.Gray,
                            fontSize = 10.sp,
                            modifier = Modifier.padding(top = 5.dp)
                        )
                    }
                }
                Text(
                    text = "Chỉnh sửa",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .clickable(onClick = onEditClick)
                )
            }
        }
    }
}


data class Address(
    val name: String,
    val phone: String,
    val address: String,
    val isDefault: Boolean
)
