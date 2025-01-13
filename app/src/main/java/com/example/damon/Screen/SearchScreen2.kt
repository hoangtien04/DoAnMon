package com.example.damon.Screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SearchScreen2(navController: NavController){
    var timKiem by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFF5F5F5))
    ) {
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = timKiem,
                    onValueChange = {timKiem = it},
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    trailingIcon = {
                        IconButton(onClick = {

                        }) {
                            Icon(Icons.Default.Close, contentDescription = "Clear")
                        }
                    },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = Color(0xFFE3E3E3),
                        unfocusedContainerColor = Color(0xFFE3E3E3)
                    ),
                    shape = RoundedCornerShape(12.dp),
                    placeholder = {
                        Text(text = "Bạn đang tìm kiếm sản phẩm gì?")
                    }
                )
            }

        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                val lineHeight = 70.dp.toPx()
                drawLine(
                    color = Color.LightGray,
                    start = Offset(0f, lineHeight), // bắt đầu từ bên trái
                    end = Offset(size.width, lineHeight), // đến hết bên phải
                    strokeWidth = 5f,
                )
            }
            .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
            ){
            Text(text = "Lịch sử tìm kiếm", style = TextStyle(
                fontSize = 18.sp,
            ))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "")
            }
        }
    }
}