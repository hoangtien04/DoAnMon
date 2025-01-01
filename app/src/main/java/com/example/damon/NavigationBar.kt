package com.example.damon

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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@Composable
fun NavigationBar(navRootController: NavHostController, navItemController:NavHostController){
    val homeSize = remember { Animatable(65f) }
    val searchSize = remember { Animatable(54f) }
    val profileSize = remember { Animatable(54f) }
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Hàng trên cùng với các nút yêu thích và giỏ hàng
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                modifier = Modifier.size(45.dp),
                onClick = { navRootController.navigate(ScreenRoute.Favourite.route) }
            ) {
                Icon(
                    Icons.Rounded.FavoriteBorder,
                    contentDescription = "Favourite",
                    modifier = Modifier.size(30.dp)
                )
            }
            Spacer(modifier = Modifier.width(2.dp))
            IconButton(
                modifier = Modifier.size(56.dp),
                onClick = { navRootController.navigate(ScreenRoute.Cart.route) }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.shopping_cart_24dp_5f6368_fill0_wght400_grad0_opsz24),
                    contentDescription = "Cart",
                    modifier = Modifier.size(30.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
        }

        // Hàng dưới cùng với các biểu tượng điều hướng chính
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 32.dp)
                .height(70.dp),
            horizontalArrangement = Arrangement.spacedBy(65.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Biểu tượng Home
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(homeSize.value.dp)
                    .clickable {
                        scope.launch {
                            if (homeSize.value != 65f) {
                                homeSize.animateTo(65f, animationSpec = tween(100))
                                searchSize.animateTo(54f, animationSpec = tween(100))
                                profileSize.animateTo(54f, animationSpec = tween(100))
                                navItemController.navigate(NavItem.Home.route)
                            }
                        }
                    }
                    .background(Color.White)
            ) {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Home",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(32.dp)
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(searchSize.value.dp)
                    .clickable {
                        scope.launch {
                            if (searchSize.value != 65f) {
                                homeSize.animateTo(54f, animationSpec = tween(100))
                                searchSize.animateTo(65f, animationSpec = tween(100))
                                profileSize.animateTo(54f, animationSpec = tween(100))
                                navItemController.navigate(NavItem.Search.route)
                            }
                        }
                    }
                    .background(Color.White)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = "Search",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(32.dp)
                )
            }

            // Biểu tượng Profile
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(profileSize.value.dp)
                    .clickable {
                        scope.launch {
                            if (profileSize.value != 65f) {
                                homeSize.animateTo(54f, animationSpec = tween(100))
                                searchSize.animateTo(54f, animationSpec = tween(100))
                                profileSize.animateTo(65f, animationSpec = tween(100))
                                navItemController.navigate(NavItem.Manager.route)
                            }
                        }
                    }
                    .background(Color.White)
            ) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(32.dp)
                )
            }
        }
    }
}