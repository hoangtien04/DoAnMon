package com.example.damon.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.damon.Card.OderCard
import com.example.damon.Card.OrderConfirmationCard
import com.example.damon.DataClass.DonHang
import com.example.damon.Navigation.ScreenRoute
import com.example.damon.R
import com.example.damon.ViewModel.AllViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.*
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OrderScreen(navController: NavController, initialTab: Int = 0, viewModel: AllViewModel) {
    var selectedTab by remember { mutableStateOf(initialTab) }
    val tabs = listOf("Chờ xác nhận", "Chờ lấy hàng", "Chờ giao hàng", "Đánh giá", "Hủy đơn hàng")

    val pagerState = rememberPagerState(initialPage = initialTab)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Header(navController = navController)

        TabRow(
            selectedTabIndex = pagerState.currentPage,
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    text = { Text(tab, fontSize = 14.sp) },
                    selected = index == pagerState.currentPage,
                    onClick = {
                        selectedTab = index
                    }
                )
            }
        }

        LaunchedEffect(pagerState.currentPage) {
            val status = when (pagerState.currentPage) {
                0 -> 1 // Chờ xác nhận
                1 -> 2 // Chờ lấy hàng
                2 -> 3 // Chờ giao hàng
                3 -> 4 // Đánh giá
                4 -> 5 // Hủy đơn hàng
                else -> 1
            }
            viewModel.clearDonHangList()
            viewModel.getDonHangUserStatus(viewModel.nguoidungtaikhoan.MaND, status)
        }

        HorizontalPager(
            count = tabs.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { pageIndex ->
            when (pageIndex) {
                0 -> WaitingForConfirmationScreen(navController, viewModel)
                1 -> WaitingForPickupScreen(navController, viewModel)
                2 -> WaitingForDeliveryScreen(navController, viewModel)
                3 -> RatingScreen(navController, viewModel)
                4 -> CancelOrderScreen(navController, viewModel)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}




@Composable
fun Header(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Đơn đã mua",
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}

@Composable
fun EmptyStateMessage(message: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_empty_order),
            contentDescription = "Empty Order Icon",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = message,
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun WaitingForConfirmationScreen(navController: NavController, viewModel: AllViewModel) {
    var listDonHang: List<DonHang> = viewModel.listDonHang
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        if (listDonHang.isEmpty()) {
            EmptyStateMessage("Bạn chưa có đơn hàng nào đang chờ xác nhận.")
        } else {
            LazyColumn(modifier = Modifier.padding()) {
                items(listDonHang) {
                    OderCard(donHang = it,
                        {navController.navigate(ScreenRoute.DetailDonHang.route + "?id=${it.MaDH}")},
                        viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun WaitingForPickupScreen(navController: NavController, viewModel: AllViewModel) {
    var listDonHang: List<DonHang> = viewModel.listDonHang
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        if (listDonHang.isEmpty()) {
            EmptyStateMessage("Bạn chưa có đơn hàng nào đang chờ lấy hàng.")
        } else {
            LazyColumn(modifier = Modifier.padding()) {
                items(listDonHang) {
                    OderCard(donHang = it,
                        {navController.navigate(ScreenRoute.DetailDonHang.route + "?id=${it.MaDH}")},
                        viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun WaitingForDeliveryScreen(navController: NavController, viewModel: AllViewModel) {
    var listDonHang: List<DonHang> = viewModel.listDonHang
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        if (listDonHang.isEmpty()) {
            EmptyStateMessage("Bạn chưa có đơn hàng nào đang chờ giao hàng.")
        } else {
            LazyColumn(modifier = Modifier.padding()) {
                items(listDonHang) {
                    OderCard(donHang = it,
                        {navController.navigate(ScreenRoute.DetailDonHang.route + "?id=${it.MaDH}")},
                        viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun RatingScreen(navController: NavController, viewModel: AllViewModel) {
    var listDonHang: List<DonHang> = viewModel.listDonHang
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        if (listDonHang.isEmpty()) {
            EmptyStateMessage("Bạn chưa có đơn hàng nào đang chờ đánh giá.")
        } else {
            LazyColumn(modifier = Modifier.padding()) {
                items(listDonHang) {
                    OderCard(donHang = it,
                        {navController.navigate(ScreenRoute.DetailDonHang.route + "?id=${it.MaDH}")},
                        viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun CancelOrderScreen(navController: NavController, viewModel: AllViewModel) {
    var listDonHang: List<DonHang> = viewModel.listDonHang
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        if (listDonHang.isEmpty()) {
            EmptyStateMessage("Bạn chưa có đơn hàng nào đã bị hủy.")
        } else {
            LazyColumn(modifier = Modifier.padding()) {
                items(listDonHang) {
                    OderCard(donHang = it,
                        {navController.navigate(ScreenRoute.DetailDonHang.route + "?id=${it.MaDH}")},
                        viewModel
                    )
                }
            }
        }
    }
}