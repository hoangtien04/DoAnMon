package com.example.damon.Screen



import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MemberScreen(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Thông tin",)
                },
                actions = {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ExitToApp, contentDescription = "",
                        modifier = Modifier.padding(end = 10.dp),
                        tint = Color.Red
                    )
                },
                modifier = Modifier.drawBehind {
                    val lineHeight = size.height
                    drawLine(
                        color = Color.Black,
                        start = Offset(0f, lineHeight), // bắt đầu từ bên trái
                        end = Offset(size.width, lineHeight), // đến hết bên phải
                        strokeWidth = 4f,
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(tonalElevation = 0.dp ) {
                Row (modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "",
                            tint = Color.Black
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            tint = Color.Black
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "",
                            tint = Color.Black
                        )
                    }
                }
            }
        }
    ){
        Column(modifier = Modifier.fillMaxSize().padding(it)) {
            Text(text = "Chỉnh sửa hồ sơ", modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 20.dp)
                .clickable(onClick = { /*TODO*/ })
                .fillMaxWidth()
                .drawBehind {
                    val lineHeight = 30.dp.toPx()
                    drawLine(
                        color = Color.LightGray,
                        start = Offset(0f, lineHeight), // bắt đầu từ bên trái
                        end = Offset(size.width, lineHeight), // đến hết bên phải
                        strokeWidth = 4f,
                    )
                },
                fontSize = 20.sp
            )

            Text(text = "Thay đổi mật khẩu", modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 20.dp)
                .clickable(onClick = { /*TODO*/ })
                .fillMaxWidth()
                .drawBehind {
                    val lineHeight = 30.dp.toPx()
                    drawLine(
                        color = Color.LightGray,
                        start = Offset(0f, lineHeight), // bắt đầu từ bên trái
                        end = Offset(size.width, lineHeight), // đến hết bên phải
                        strokeWidth = 4f,
                    )
                },
                fontSize = 20.sp
            )

            Text(text = "Danh sách địa chỉ", modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 20.dp)
                .clickable(onClick = { /*TODO*/ })
                .fillMaxWidth()
                .drawBehind {
                    val lineHeight = 30.dp.toPx()
                    drawLine(
                        color = Color.LightGray,
                        start = Offset(0f, lineHeight), // bắt đầu từ bên trái
                        end = Offset(size.width, lineHeight), // đến hết bên phải
                        strokeWidth = 4f,
                    )
                },
                fontSize = 20.sp
            )

            Text(text = "Lịch sử đơn hàng", modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 20.dp)
                .clickable(onClick = { /*TODO*/ })
                .fillMaxWidth()
                .drawBehind {
                    val lineHeight = 30.dp.toPx()
                    drawLine(
                        color = Color.LightGray,
                        start = Offset(0f, lineHeight), // bắt đầu từ bên trái
                        end = Offset(size.width, lineHeight), // đến hết bên phải
                        strokeWidth = 4f,
                    )
                },
                fontSize = 20.sp
            )

            Text(text = "Lịch sử mua hàng", modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 20.dp)
                .clickable(onClick = { /*TODO*/ })
                .fillMaxWidth()
                .drawBehind {
                    val lineHeight = 30.dp.toPx()
                    drawLine(
                        color = Color.LightGray,
                        start = Offset(0f, lineHeight), // bắt đầu từ bên trái
                        end = Offset(size.width, lineHeight), // đến hết bên phải
                        strokeWidth = 4f,
                    )
                },
                fontSize = 20.sp
            )

            Text(text = "Đánh giá", modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 20.dp)
                .clickable(onClick = { /*TODO*/ })
                .fillMaxWidth()
                .drawBehind {
                    val lineHeight = 30.dp.toPx()
                    drawLine(
                        color = Color.LightGray,
                        start = Offset(0f, lineHeight), // bắt đầu từ bên trái
                        end = Offset(size.width, lineHeight), // đến hết bên phải
                        strokeWidth = 4f,
                    )
                },
                fontSize = 20.sp
            )
        }

    }
}