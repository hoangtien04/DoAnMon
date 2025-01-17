package com.example.damon.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.damon.Card.SearchDanhMucCard
import com.example.damon.Navigation.NavItem
import com.example.damon.Navigation.ScreenRoute
import com.example.damon.R
import com.example.damon.ViewModel.SanPhamViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SearchScreen(navController: NavController,viewModel: SanPhamViewModel) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    viewModel.getLoaiSanPham()
    val listLoaiSanPham by viewModel.loaiSanPham.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.71f)
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            items(listLoaiSanPham) {
                SearchDanhMucCard(it, onClick = {
                    navController.navigate(NavItem.ProductList.route)
                })
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(650.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, top = 15.dp, end = 15.dp)
                    .border(0.5.dp, Color.Gray, RoundedCornerShape(100.dp))
                    .height(52.dp)
                    .clickable {
                        navController.navigate(NavItem.ProductList.route)
                    },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, end = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                    ) {
                    Icon(
                        painter = painterResource(R.drawable.search1),
                        contentDescription = "",
                        tint = Color.Gray,
                    )
                    Text(
                        text = "Tìm kiếm sản phẩm",modifier = Modifier.padding(start = 5.dp), color = Color.LightGray
                    )
                }
            }
        }
    }
}
