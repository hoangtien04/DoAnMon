package com.example.damon.Screen

import Product
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.damon.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun OrderDetailAdminScreen(/*product: Product, customerName: String, customerPhone: String, customerAddress: String, orderStatus: String*/) {
    val product = Product(
        imageResId = R.drawable.anh1,
        title = "Áo len nam",
        subtitle = "Thời trang thu đông"
    )

    val customerName = "Nguyễn Văn A"
    val customerPhone = "0123456789"
    val customerAddress = "123 Đường ABC, Quận XYZ"
    val orderStatus = "Đang vận chuyển"

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        modifier = Modifier.size(65.dp).clip(CircleShape),
                        onClick = {
                        },
                    ){
                        Icon(Icons.Filled.ArrowBack,"")
                    }
                },
                actions = {
                },
                title = {
                    Text(
                        "Chi tiết đơn hàng",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
            )

        }
    ) {padding->
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            // Title
            Text(
                text = "Chi tiết đơn hàng",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = painterResource(id = product.imageResId),
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Sản phẩm: ${product.title}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            // Product Description
            Text(
                text = "Mô tả: ${product.subtitle}",
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Customer Information Section with padding and better spacing
            Text(
                text = "Người đặt: $customerName",
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Số điện thoại: $customerPhone",
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                text = "Địa chỉ: $customerAddress",
                fontSize = 16.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Order Status Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Trạng thái đơn hàng: $orderStatus",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                // Button only shown when status is "Chờ xác thực"
                if (orderStatus == "Chờ xác thực") {
                    Button(
                        onClick = {
                        },
                        modifier = Modifier
                            .height(48.dp)
                            .width(160.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4CAF50), // Green color for confirmation
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Xác nhận đơn hàng",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
