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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.damon.Navigation.NavItem
import com.example.damon.Navigation.NavigationAppBar
import com.example.damon.Navigation.NavigationBarGraph
import com.example.damon.Navigation.ScreenRoute
import com.example.damon.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navRootController: NavHostController, modifier: Modifier = Modifier) {
    val navItemController = rememberNavController()
    val currentBackStackEntry by navItemController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    // Kiểm tra xem trang hiện tại có phải là Manager hay không
    val isManagerRoute = currentRoute == NavItem.Manager.route

    // Khởi tạo navItemController


    Scaffold(
        topBar = {
            // Kiểm tra nếu route hiện tại là Manager thì không hiển thị TopAppBar
            if (!isManagerRoute) {
                TopAppBar(
                    actions = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            // Nút yêu thích
                            IconButton(
                                modifier = Modifier.size(65.dp).clip(CircleShape),
                                onClick = {
                                    navRootController.navigate(ScreenRoute.Favourite.route)
                                },
                            ) {
                                Icon(Icons.Filled.FavoriteBorder, "")
                            }
                            // Nút giỏ hàng
                            IconButton(
                                modifier = Modifier.size(65.dp).clip(CircleShape),
                                onClick = {
                                    navRootController.navigate(ScreenRoute.Cart.route)
                                },
                            ) {
                                Icon(painter = painterResource(R.drawable.shopping_cart_24dp_5f6368_fill0_wght400_grad0_opsz24), "")
                            }
                        }
                    },
                    title = {},
                )
            }
        },
        bottomBar = {
            Column {
                // Thanh điều hướng dưới
                NavigationAppBar(navController = navItemController)
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            // Nội dung của NavigationBarGraph
            NavigationBarGraph(
                navItemController = navItemController,
                navRootController = navRootController
            )
        }
    }
}


