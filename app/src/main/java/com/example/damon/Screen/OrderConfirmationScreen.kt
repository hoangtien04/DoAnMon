package com.example.damon.Screen

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.damon.DataClass.Product
import com.example.damon.DataClass.YeuThich
import com.example.damon.R
import com.example.damon.Navigation.ScreenRoute
import com.example.damon.ViewModel.AllViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderConfirmationScreen(navController: NavController, viewModel: AllViewModel){
    viewModel.getAllDonHang()
    var listDonHang: List<DonHang> = viewModel.listDonHang
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        modifier = Modifier.size(65.dp).clip(CircleShape),
                        onClick = {
                            navController.navigate(ScreenRoute.Main.route)
                        },
                    ){
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
                    IconButton(
                        modifier = Modifier.size(65.dp).clip(CircleShape),
                        onClick = {

                        },
                    ){
                        Icon(painter = painterResource(id = R.drawable.filter_solid),
                            contentDescription = "Lọc",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            )
        }
    ) {padding->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(listDonHang){
                OrderConfirmationCard(donHang = it,{
                    navController.navigate(
                        ScreenRoute.DetailDonHang.route + "?id=${it.MaDH}"
                    )
                })
            }
        }
    }
}