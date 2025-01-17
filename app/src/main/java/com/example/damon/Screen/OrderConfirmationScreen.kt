package com.example.damon.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.damon.Card.OrderConfirmationCard
import com.example.damon.DataClass.DonHang
import com.example.damon.R
import com.example.damon.Navigation.ScreenRoute
import com.example.damon.ViewModel.AllViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderConfirmationScreen(navController: NavController, viewModel: AllViewModel) {
    viewModel.getAllDonHang()
    var listDonHang: List<DonHang> = viewModel.listDonHang
    val expanded = remember { mutableStateOf(false) }
    val selectedFilter = remember { mutableStateOf("All") }

    val filteredList by remember {
        derivedStateOf {
            when (selectedFilter.value) {
                "Chờ xác nhận" -> listDonHang.filter { it.TrangThaiDH == 1 }
                "Chờ lấy hàng" -> listDonHang.filter { it.TrangThaiDH == 2 }
                "Chờ giao hàng" -> listDonHang.filter { it.TrangThaiDH == 3 }
                "Đánh giá" -> listDonHang.filter { it.TrangThaiDH == 4 }
                "Hủy đơn hàng" -> listDonHang.filter { it.TrangThaiDH == 5 }
                else -> listDonHang
            }
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        modifier = Modifier.size(65.dp).clip(CircleShape),
                        onClick = {
                            navController.navigate(ScreenRoute.Main.route)
                        },
                    ) {
                        Icon(painter = painterResource(id = R.drawable.user_group_solid),
                            contentDescription = "Thoát ra chế độ người dùng",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                },
                title = {
                    Text(
                        "Admin",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                actions = {
                    Box(
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        IconButton(
                            modifier = Modifier.size(65.dp).clip(CircleShape),
                            onClick = {
                                expanded.value = !expanded.value
                            },
                        ) {
                            Icon(painter = painterResource(id = R.drawable.filter_solid),
                                contentDescription = "Lọc",
                                modifier = Modifier.size(32.dp)
                            )
                        }

                        if (expanded.value) {
                            DropdownMenu(
                                expanded = expanded.value,
                                onDismissRequest = { expanded.value = false },
                                modifier = Modifier
                                    .align(Alignment.TopStart)
                                    .padding(8.dp)
                                    .width(200.dp)
                            ) {
                                DropdownMenuItem(onClick = {
                                    selectedFilter.value = "Chờ xác nhận"
                                    expanded.value = false
                                }) {
                                    Text("Chờ xác nhận")
                                }
                                DropdownMenuItem(onClick = {
                                    selectedFilter.value = "Chờ lấy hàng"
                                    expanded.value = false
                                }) {
                                    Text("Chờ lấy hàng")
                                }
                                DropdownMenuItem(onClick = {
                                    selectedFilter.value = "Chờ giao hàng"
                                    expanded.value = false
                                }) {
                                    Text("Chờ giao hàng")
                                }
                                DropdownMenuItem(onClick = {
                                    selectedFilter.value = "Đánh giá"
                                    expanded.value = false
                                }) {
                                    Text("Đánh giá")
                                }
                                DropdownMenuItem(onClick = {
                                    selectedFilter.value = "Hủy đơn hàng"
                                    expanded.value = false
                                }) {
                                    Text("Hủy đơn hàng")
                                }
                                // Option to show all orders
                                DropdownMenuItem(onClick = {
                                    selectedFilter.value = "All"
                                    expanded.value = false
                                }) {
                                    Text("Tất cả đơn hàng")
                                }
                            }
                        }
                    }
                }
            )
        }
    ) { padding ->
        // LazyColumn to show the filtered list
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(filteredList) {
                OrderConfirmationCard(donHang = it, {
                    navController.navigate(
                        ScreenRoute.DetailDonHang.route + "?id=${it.MaDH}"
                    )
                },
                    viewModel
                )
            }
        }
    }
}
