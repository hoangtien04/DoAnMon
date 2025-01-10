package com.example.damon.Screen

import android.annotation.SuppressLint
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
@OptIn(ExperimentalMaterial3Api::class)
fun SearchScreen4() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFF5F5F5))
    ){
        Row(modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = "ao",
                    onValueChange = {},
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    trailingIcon = {
                        IconButton(onClick = {}) {
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
                )
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .drawBehind {
                val lineHeight = size.height
                drawLine(
                    color = Color.Black,
                    start = Offset(0f, lineHeight), // bắt đầu từ bên trái
                    end = Offset(size.width, lineHeight), // đến hết bên phải
                    strokeWidth = 2f,
                )
            },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Text(text = "Tất cả", style = TextStyle(fontSize = 18.sp))
            Text(text = "Danh mục", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp))

        }
        Row(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 10.dp)
            .clickable(onClick = { /*TODO*/ })
            .height(70.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Column(modifier = Modifier){
                Text(text = "ÁO SƠ MI & ÁO KIỂU", modifier = Modifier
                    .fillMaxWidth(),
                    fontSize = 20.sp
                )
                Text(text = "NỮ",modifier = Modifier.padding(top = 10.dp), color = Color.LightGray, fontSize = 17.sp)
            }
        }
        Row(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 10.dp)
            .clickable(onClick = { /*TODO*/ })
            .height(70.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Column(modifier = Modifier){
                Text(text = "ÁO SƠ MI & ÁO KIỂU", modifier = Modifier
                    .fillMaxWidth(),
                    fontSize = 20.sp
                )
                Text(text = "NỮ",modifier = Modifier.padding(top = 10.dp), color = Color.LightGray, fontSize = 17.sp)
            }
        }
        Row(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 10.dp)
            .clickable(onClick = { /*TODO*/ })
            .height(70.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Column(modifier = Modifier){
                Text(text = "ÁO SƠ MI & ÁO KIỂU", modifier = Modifier
                    .fillMaxWidth(),
                    fontSize = 20.sp
                )
                Text(text = "NỮ",modifier = Modifier.padding(top = 10.dp), color = Color.LightGray, fontSize = 17.sp)
            }
        }
        Row(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 10.dp)
            .clickable(onClick = { /*TODO*/ })
            .height(70.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Column(modifier = Modifier){
                Text(text = "ÁO SƠ MI & ÁO KIỂU", modifier = Modifier
                    .fillMaxWidth(),
                    fontSize = 20.sp
                )
                Text(text = "NỮ",modifier = Modifier.padding(top = 10.dp), color = Color.LightGray, fontSize = 17.sp)
            }
        }
        Row(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 10.dp)
            .clickable(onClick = { /*TODO*/ })
            .height(70.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Column(modifier = Modifier){
                Text(text = "ÁO SƠ MI & ÁO KIỂU", modifier = Modifier
                    .fillMaxWidth(),
                    fontSize = 20.sp
                )
                Text(text = "NỮ",modifier = Modifier.padding(top = 10.dp), color = Color.LightGray, fontSize = 17.sp)
            }
        }
        Row(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 10.dp)
            .clickable(onClick = { /*TODO*/ })
            .height(70.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Column(modifier = Modifier){
                Text(text = "ÁO SƠ MI & ÁO KIỂU", modifier = Modifier
                    .fillMaxWidth(),
                    fontSize = 20.sp
                )
                Text(text = "NỮ",modifier = Modifier.padding(top = 10.dp), color = Color.LightGray, fontSize = 17.sp)
            }
        }
        Row(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 10.dp)
            .clickable(onClick = { /*TODO*/ })
            .height(70.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Column(modifier = Modifier){
                Text(text = "ÁO SƠ MI & ÁO KIỂU", modifier = Modifier
                    .fillMaxWidth(),
                    fontSize = 20.sp
                )
                Text(text = "NỮ",modifier = Modifier.padding(top = 10.dp), color = Color.LightGray, fontSize = 17.sp)
            }
        }
        Row(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 10.dp)
            .clickable(onClick = { /*TODO*/ })
            .height(70.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Column(modifier = Modifier){
                Text(text = "ÁO SƠ MI & ÁO KIỂU", modifier = Modifier
                    .fillMaxWidth(),
                    fontSize = 20.sp
                )
                Text(text = "NỮ",modifier = Modifier.padding(top = 10.dp), color = Color.LightGray, fontSize = 17.sp)
            }
        }
    }
}