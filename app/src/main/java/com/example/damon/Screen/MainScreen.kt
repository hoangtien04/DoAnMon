package com.example.damon.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.damon.Card.ProductListCard
import com.example.damon.Navigation.NavItem
import com.example.damon.Navigation.NavigationAppBar
import com.example.damon.Navigation.NavigationBarGraph
import com.example.damon.Navigation.ScreenRoute
import com.example.damon.R
import com.example.damon.ViewModel.AllViewModel
import com.example.damon.ViewModel.SanPhamViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navRootController: NavHostController,viewModel: AllViewModel,viewModel2: SanPhamViewModel) {
    val navItemController = rememberNavController()
    val currentBackStackEntry by navItemController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    viewModel2.getAllSanPham()
    val listSanPham by viewModel2.listSanPham.collectAsState()
    val nguoiDung = viewModel.nguoidungdangnhap

    val isManagerRoute = currentRoute == NavItem.Manager.route

    Scaffold(
        topBar = {
            if (!isManagerRoute) {
                TopAppBar(
                    actions = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            IconButton(
                                modifier = Modifier.size(65.dp).clip(CircleShape),
                                onClick = {
                                    if(nguoiDung.MaND == 0){
                                        navRootController.navigate(ScreenRoute.Login.route)
                                    }
                                    else{
                                        navRootController.navigate(ScreenRoute.Favourite.route)
                                    }
                                },
                            ) {
                                Icon(Icons.Filled.FavoriteBorder, "")
                            }
                            IconButton(
                                modifier = Modifier.size(65.dp).clip(CircleShape),
                                onClick = {
                                    if(nguoiDung.MaND == 0){
                                        navRootController.navigate(ScreenRoute.Login.route)
                                    }
                                    else{
                                        navRootController.navigate(ScreenRoute.Cart.route)
                                    }
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
                NavigationAppBar(navController = navItemController)
            }
        }
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(it)
        ) {
            items(listSanPham){
                ProductListCard(sanPham = it, onClick = {
                    navRootController.navigate(ScreenRoute.ProductDetail.route + "?MaSP=${it.MaSP}")
                },)
            }
        }
        Box(modifier = Modifier.padding(it)) {
            NavigationBarGraph(
                navItemController = navItemController,
                navRootController = navRootController,
                viewModel = viewModel,
                viewModel2 = viewModel2
            )
        }
    }
}


