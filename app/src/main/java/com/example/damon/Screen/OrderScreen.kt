package com.example.damon.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.example.damon.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OrderScreen(navController: NavController, initialTab: Int = 0) {
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

        LaunchedEffect(selectedTab) {
            pagerState.animateScrollToPage(selectedTab)
        }

        HorizontalPager(
            count = tabs.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { pageIndex ->
            when (pageIndex) {
                0 -> WaitingForConfirmationScreen(navController)
                1 -> WaitingForPickupScreen(navController)
                2 -> WaitingForDeliveryScreen(navController)
                3 -> RatingScreen(navController)
                4 -> CancelOrderScreen(navController)
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
fun WaitingForConfirmationScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        EmptyStateMessage("Bạn chưa có đơn hàng nào đang chờ xác nhận.")
    }
}

@Composable
fun WaitingForPickupScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        EmptyStateMessage("Bạn chưa có đơn hàng nào đang chờ lấy hàng.")
    }
}

@Composable
fun WaitingForDeliveryScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        EmptyStateMessage("Bạn chưa có đơn hàng nào đang chờ giao hàng.")
    }
}

@Composable
fun RatingScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        EmptyStateMessage("Bạn chưa có đơn hàng nào đánh giá")
    }
}

@Composable
fun CancelOrderScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        EmptyStateMessage("Bạn chưa có đơn hàng nào đã bị hủy.") // Message for no cancelled orders
    }
}