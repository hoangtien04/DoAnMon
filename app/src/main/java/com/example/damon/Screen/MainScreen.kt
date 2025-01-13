package com.example.damon.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navRootController: NavHostController, modifier: Modifier = Modifier) {
    val navItemController = rememberNavController()
    val currentRoute = navItemController.currentBackStackEntryAsState().value?.destination?.route

    val isHomeRoute = currentRoute == NavItem.Home.route

    Scaffold(
        topBar = {
            if (currentRoute !in listOf(NavItem.Home.route, NavItem.Manager.route)) {
                TopAppBar(
                    title = {},
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White
                    ),
                    actions = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            IconButton(onClick = { navRootController.navigate(ScreenRoute.Favourite.route) }) {
                                Icon(Icons.Filled.FavoriteBorder, contentDescription = null, tint = Color.Black)
                            }
                            IconButton(onClick = { navRootController.navigate(ScreenRoute.Cart.route) }) {
                                Icon(painter = painterResource(R.drawable.shopping_cart_24dp_5f6368_fill0_wght400_grad0_opsz24), contentDescription = null, tint = Color.Black)
                            }
                        }
                    }
                )
            }
        },
        bottomBar = { NavigationAppBar(navController = navItemController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(if (isHomeRoute) Color.LightGray else Color.White)
        ) {
            NavigationBarGraph(navItemController, navRootController)

            if (isHomeRoute) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, end = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(
                        modifier = Modifier.size(48.dp),
                        onClick = { navRootController.navigate(ScreenRoute.Favourite.route) }
                    ) {
                        Icon(Icons.Filled.FavoriteBorder, contentDescription = null, tint =Color.White)
                    }
                    IconButton(
                        modifier = Modifier.size(48.dp),
                        onClick = { navRootController.navigate(ScreenRoute.Cart.route) }
                    ) {
                        Icon(painter = painterResource(R.drawable.shopping_cart_24dp_5f6368_fill0_wght400_grad0_opsz24), contentDescription = null, tint = Color.White)
                    }
                }
            }
        }
    }
}
