package com.example.damon.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.damon.R

@Composable
fun ManagerScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Set background color to white
    ) {
        // Adding the graphical interface at the top
        PurchaseStatusHeader()

        val menuItems = listOf(
            "Hồ sơ" to {},
            "Lịch sử đơn hàng" to {},
            "Lịch sử mua hàng" to {},
            "Mã giảm giá (Yêu cầu đăng nhập)" to {},
            "Lưu bảng câu hỏi khảo sát dịch vụ" to {},
            "Cài đặt ứng dụng" to {}
        )

        Column(modifier = Modifier.fillMaxWidth()) {
            menuItems.forEach { (title, action) ->
                Text(
                    text = title,
                    color = Color.Black, // Set text color to black
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

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun PurchaseStatusHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .background(Color.White), // Ensure background is white here too
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            PurchaseStatusItem(iconResId = R.drawable.box_archive_solid, label = "Chờ xác nhận",{})
            PurchaseStatusItem(iconResId = R.drawable.box_solid, label = "Chờ lấy hàng",{})
            PurchaseStatusItem(iconResId = R.drawable.truck_solid, label = "Chờ giao hàng",{})
            PurchaseStatusItem(iconResId = R.drawable.star_solid, label = "Đánh giá",{})
        }
    }
}

@Composable
fun PurchaseStatusItem(iconResId: Int, label: String,onClickCard :()->Unit) {
    Card(onClick = onClickCard) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = label,
                color = Color.Black, // Set text color to black
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
