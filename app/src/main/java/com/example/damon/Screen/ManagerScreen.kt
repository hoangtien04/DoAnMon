package com.example.damon.Screen


import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.damon.R
import com.example.damon.ScreenRoute
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ManagerScreen(navController: NavController){
    val homeSize = remember { Animatable(54f) }
    val searchSize = remember { Animatable(54f) }
    val profileSize = remember { Animatable(65f) }
    val scope = rememberCoroutineScope()
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
            Text(text = "Quản lý sản phẩm", modifier = Modifier
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
            Text(text = "Quản lý đơn hàng", modifier = Modifier
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
            Text(text = "Quản lý phân loại", modifier = Modifier
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

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(bottom = 32.dp)
                    .height(70.dp),
                horizontalArrangement = Arrangement.spacedBy(65.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(homeSize.value.dp)
                        .clickable{
                            scope.launch {
                                if(homeSize.value == 65f){

                                }
                                else{
                                    // Thu nhỏ Box
                                    homeSize.animateTo(65f, animationSpec = tween(100)) // Thu nhỏ lại 100.dp
                                    searchSize.animateTo(54f, animationSpec = tween(100))
                                    profileSize.animateTo(54f, animationSpec = tween(100))
                                    navController.navigate(ScreenRoute.Home.route)
                                }
                            }
                        }
                        .background(Color.White)


                ){
                    Icon(Icons.Default.Home, contentDescription = "Search", modifier = Modifier.align(Alignment.Center).size(32.dp))
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clip(CircleShape)
                        .size(searchSize.value.dp)
                        .clickable{
                            scope.launch {
                                if(searchSize.value == 65f){

                                }
                                else{
                                    // Thu nhỏ Box
                                    homeSize.animateTo(54f, animationSpec = tween(100)) // Thu nhỏ lại 100.dp
                                    searchSize.animateTo(65f, animationSpec = tween(100))
                                    profileSize.animateTo(54f, animationSpec = tween(100))
                                    navController.navigate(ScreenRoute.Search.route)
                                }
                            }
                        }
                        .background(Color.White)
                ){
                    Icon(painter = painterResource(id = R.drawable.baseline_search_24), contentDescription = "Search", modifier = Modifier.align(Alignment.Center).size(32.dp))
                }
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(profileSize.value.dp)
                        .clickable{
                            scope.launch {
                                if(profileSize.value == 65f){

                                }
                                else{
                                    // Thu nhỏ Box
                                    homeSize.animateTo(54f, animationSpec = tween(100)) // Thu nhỏ lại 100.dp
                                    searchSize.animateTo(54f, animationSpec = tween(100))
                                    profileSize.animateTo(65f, animationSpec = tween(100))

                                }
                            }
                        }
                        .background(Color.White)
                ){
                    Icon(Icons.Default.Person, contentDescription = "Search", modifier = Modifier.align(Alignment.Center).size(32.dp))
                }
            }
        }
    }
}