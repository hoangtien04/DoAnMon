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
import com.example.damon.Navigation.ScreenRoute
import com.example.damon.R

@Composable
fun ManagerScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Set background color to white
    ) {
        AccountHeader()
        // Adding the graphical interface at the top
        PurchaseStatusHeader(navController)

        val menuItems = listOf(
            "Hồ sơ" to {navController.navigate(ScreenRoute.Member.route)},
            "Lịch sử đơn hàng" to {},
            "Lịch sử mua hàng" to {},
            "Mã giảm giá (Yêu cầu đăng nhập)" to {},
            "Đăng nhập" to {navController.navigate(ScreenRoute.Login.route)},
            "Admin" to {}
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
fun PurchaseStatusHeader(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White) // Nền trắng
            .padding(vertical = 16.dp), // Thêm khoảng cách trên và dưới
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), // Thêm khoảng cách hai bên
            horizontalArrangement = Arrangement.SpaceEvenly // Căn đều các phần tử
        ) {
            // Các trạng thái
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
        onClick = onClickCard, // Hành động khi nhấn
        modifier = Modifier
            .size(80.dp) // Kích thước Card (button)
            .padding(8.dp) // Khoảng cách giữa các Card
            .clip(RoundedCornerShape(12.dp)), // Thêm bo góc cho Card
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White) // Đảm bảo nền trắng trong từng Card
                .padding(8.dp), // Khoảng cách nội dung trong Card
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier.size(24.dp) // Kích thước biểu tượng nhỏ hơn
            )
            Spacer(modifier = Modifier.height(4.dp)) // Khoảng cách giữa icon và text
            Text(
                text = label,
                color = Color.Black, // Màu chữ đen
                fontSize = 10.sp, // Kích thước chữ nhỏ hơn
                fontWeight = FontWeight.Normal, // Font bình thường
                textAlign = TextAlign.Center // Căn giữa chữ
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
            .background(Color.Cyan, shape = RoundedCornerShape(16.dp)) // Rounded corners for the background
            .padding(horizontal = 16.dp, vertical = 12.dp), // Internal padding
        verticalAlignment = Alignment.Bottom // Align everything to the bottom
    ) {
        // Profile section
        Column(
            horizontalAlignment = Alignment.CenterHorizontally // Align icon and text centrally
        ) {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp) // Slightly larger icon for better visual balance
            )
            Spacer(modifier = Modifier.height(8.dp)) // Space between the icon and text
            Text(
                text = "Tên Tài Khoản",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold // Make the text bold for better visibility
            )
        }

        Spacer(modifier = Modifier.weight(1f)) // Fill the space between profile section and address section

        // Address section aligned to the right and at the bottom
        Column(
            horizontalAlignment = Alignment.End, // Align the content to the right
            verticalArrangement = Arrangement.Bottom // Align the content to the bottom
        ) {
            Icon(
                painter = painterResource(id = R.drawable.location_dot_solid),
                contentDescription = null,
                tint = Color.Black, // Set icon color to black
                modifier = Modifier
                    .size(20.dp) // Adjust icon size if needed
                    .padding(end = 8.dp) // Add some space from the right
            )
            Spacer(modifier = Modifier.height(4.dp)) // Space between icon and text
            Text(
                text = "Địa chỉ",
                color = Color.Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal // Light text to differentiate from the title
            )
        }
    }
}
