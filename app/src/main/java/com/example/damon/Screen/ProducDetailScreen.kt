package com.example.damon.Screen

import Product
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.damon.R
import com.example.damon.Navigation.ScreenRoute


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(navController: NavController) {
    val product = Product(R.drawable.anh1, "Áo khoác dù", "Thời trang thu đông")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate(ScreenRoute.Favourite.route) }) {
                        Icon(
                            imageVector = Icons.Rounded.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = Color.Black
                        )
                    }
                    IconButton(onClick = { navController.navigate(ScreenRoute.Cart.route)}) {
                        Icon(
                            painter = painterResource(id = R.drawable.shopping_cart_24dp_5f6368_fill0_wght400_grad0_opsz24),
                            contentDescription = "Cart",
                            tint = Color.Black
                        )
                    }
                },
                modifier = Modifier.drawBehind {
                    val lineHeight = size.height
                    drawLine(
                        color = Color.Gray,
                        start = Offset(0f, lineHeight),
                        end = Offset(size.width, lineHeight),
                        strokeWidth = 2f
                    )
                },
                colors = androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        containerColor = Color.White // Nền trắng
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding() // Tạo không gian tổng thể
            ) {
                // Hình ảnh sản phẩm
                Image(
                    painter = painterResource(id = product.imageResId),
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .fillMaxWidth() // Full chiều rộng
                        .padding(bottom = 16.dp),
                    contentScale = ContentScale.Crop // Cắt để vừa khung
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp,0.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically// This will ensure that items are spaced out
                    ) {
                        // Tên sản phẩm bên trái
                        Text(
                            text = product.title,
                            color = Color.Black,
                            fontSize = 29.sp,
                            modifier = Modifier.weight(1f) // Ensures it takes all available space to the left
                        )

                        // Nút thích bên phải
                        IconButton(onClick = { /* Thêm vào yêu thích */ }) {
                            Icon(
                                modifier = Modifier.size(28.dp),
                                imageVector = Icons.Rounded.FavoriteBorder,
                                contentDescription = "Favorite",
                                tint = Color.Black
                            )
                        }
                    }

                    Row(

                    ){
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(32.dp)
                                .clickable {
                                }
                                .background(Color.Transparent)
                                .border(0.5.dp,Color.Black, RoundedCornerShape(100.dp)),
                            contentAlignment = Alignment.Center
                        ){
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(30.dp)
                                    .clickable {
                                    }
                                    .background(Color.Red),
                            ) { }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(32.dp)
                                .clickable {
                                }
                                .background(Color.Transparent),
                            contentAlignment = Alignment.Center
                        ){
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(30.dp)
                                    .clickable {
                                    }
                                    .background(Color.Green),
                            ) { }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(32.dp)
                                .clickable {
                                }
                                .background(Color.Transparent),
                            contentAlignment = Alignment.Center
                        ){
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(30.dp)
                                    .clickable {
                                    }
                                    .background(Color.Gray),
                            ) { }
                        }
                        Spacer(modifier = Modifier.width(8.dp))

                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(32.dp)
                                .clickable {
                                }
                                .background(Color.Transparent),
                            contentAlignment = Alignment.Center
                        ){

                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(

                    ){
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clickable {
                                }
                                .background(Color.Transparent)
                                .height(20.dp)
                                .width(50.dp)
                                .border(0.5.dp,Color.Black)
                                .padding(0.5.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Box(
                                modifier = Modifier
                                    .clickable {
                                    }
                                    .fillMaxSize()
                                    .padding(2.dp)
                                    .background(Color.Black),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "XS",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clickable {
                                }
                                .background(Color.Transparent)
                                .height(20.dp)
                                .width(50.dp)
//                                .border(0.5.dp,Color.Black)
                                .padding(0.5.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Box(
                                modifier = Modifier
                                    .clickable {
                                    }
                                    .fillMaxSize()
                                    .padding(2.dp)
                                    .border(0.5.dp,Color.Black)
                                    .background(Color.White),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "S",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clickable {
                                }
                                .background(Color.Transparent)
                                .height(20.dp)
                                .width(50.dp)
//                                .border(0.5.dp,Color.Black)
                                .padding(0.5.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Box(
                                modifier = Modifier
                                    .clickable {
                                    }
                                    .fillMaxSize()
                                    .padding(2.dp)
                                    .border(0.5.dp,Color.Black)
                                    .background(Color.White),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "L",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                    // Mô tả sản phẩm (căn đều)
                    Text(
                        text = product.subtitle,
                        color = Color.Gray,
                        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp), // Tạo khoảng cách dưới
                        textAlign = TextAlign.Justify // Căn đều
                    )

                    // Thêm nút "Thêm vào giỏ hàng"
                    Button(
                        onClick = { /* Xử lý thêm vào giỏ hàng */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp) // Khoảng cách trên nút
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                    ) {
                        Text(
                            text = "Thêm vào giỏ hàng",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyLarge // Adjusted text style
                        )
                    }
                }

            }
        }
    }
}
