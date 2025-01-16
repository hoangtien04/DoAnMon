package com.example.damon.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.damon.DataClass.NguoiDung
import com.example.damon.Navigation.ScreenRoute
import com.example.damon.R
import com.example.damon.ViewModel.AllViewModel

@Composable
fun ManagerScreen(navController: NavController, viewModel: AllViewModel) {
    var menuItems = listOf(
        "Hồ sơ" to { navController.navigate(ScreenRoute.Member.route) },
        "Admin" to {}
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        AccountHeader()
        PurchaseStatusHeader(navController)


        Column(modifier = Modifier.fillMaxWidth()) {
            menuItems.forEach { (title, action) ->
                Text(
                    text = title,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(horizontal = 15.dp, vertical = 10.dp)
                        .clickable(onClick = action)
                        .fillMaxWidth()
                        .drawBehind {
                            val lineHeight = 1.dp.toPx()
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = lineHeight
                            )
                        },
                    fontSize = 18.sp
                )
            }
        }
        viewModel.kiemtratrangthai()
        var trangthai:Boolean = viewModel.trangthaiDangNhap
        if(!trangthai) {
            Text(
                text = "Đăng nhập",
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 10.dp)
                    .clickable(onClick = {
                        navController.navigate(ScreenRoute.Login.route)
                    })
                    .fillMaxWidth()
                    .drawBehind {
                        val lineHeight = 1.dp.toPx()
                        drawLine(
                            color = Color.LightGray,
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                            strokeWidth = lineHeight
                        )
                    },
                fontSize = 18.sp
            )
        }else{
            Text(
                text = "Đăng xuất",
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 10.dp)
                    .clickable(onClick = {
                        viewModel.trangthaiDangNhap = false
                        viewModel.nguoidungtaikhoan = NguoiDung(0,"",0,"","","","","",0)
                    })
                    .fillMaxWidth()
                    .drawBehind {
                        val lineHeight = 1.dp.toPx()
                        drawLine(
                            color = Color.LightGray,
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                            strokeWidth = lineHeight
                        )
                    },
                fontSize = 18.sp
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun PurchaseStatusHeader(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            PurchaseStatusItem(
                iconResId = R.drawable.box_archive_solid,
                label = "Chờ xác nhận",
                onClickCard = {navController.navigate(ScreenRoute.Oder.createRoute(0))}
            )
            PurchaseStatusItem(
                iconResId = R.drawable.box_solid,
                label = "Chờ lấy hàng",
                onClickCard = {navController.navigate(ScreenRoute.Oder.createRoute(1))}
            )
            PurchaseStatusItem(
                iconResId = R.drawable.truck_solid,
                label = "Chờ giao hàng",
                onClickCard = {navController.navigate(ScreenRoute.Oder.createRoute(2))}
            )
            PurchaseStatusItem(
                iconResId = R.drawable.star_solid,
                label = "Đánh giá",
                onClickCard = {navController.navigate(ScreenRoute.Oder.createRoute(3))}
            )
        }
    }
}

@Composable
fun PurchaseStatusItem(iconResId: Int, label: String, onClickCard: () -> Unit) {
    Card(
        onClick = onClickCard,
        modifier = Modifier
            .size(80.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label,
                color = Color.Black,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Composable
fun AccountHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Cyan, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Tên Tài Khoản",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            Icon(
                painter = painterResource(id = R.drawable.location_dot_solid),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(20.dp)
                    .padding(end = 8.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Địa chỉ",
                color = Color.Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}
