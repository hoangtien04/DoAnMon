package com.example.damon.Screen

import Product
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
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.damon.Card.FavouriteCard
import com.example.damon.R
import com.example.damon.Navigation.ScreenRoute


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteScreen(navController: NavController){
    val homeSize = remember { Animatable(65f) }
    val searchSize = remember { Animatable(54f) }
    val profileSize = remember { Animatable(54f) }
    val scope = rememberCoroutineScope()
    val productList = listOf(
        Product(R.drawable.anh1, "Áo len nam", "Thời trang thu đông"),
        Product(R.drawable.anh1, "Áo hoodie", "Phong cách trẻ trung"),
        Product(R.drawable.anh1, "Áo khoác dạ", "Thời thượng và ấm áp"),
        Product(R.drawable.anh1, "Áo sơ mi", "Lịch sự, sang trọng")
    )
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        modifier = Modifier.size(65.dp).clip(CircleShape),
                        onClick = {
                            navController.popBackStack()
                        },
                    ){
                        Icon(Icons.Filled.ArrowBack,"")
                    }
                },
                actions = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ){

                        IconButton(
                            modifier = Modifier.size(65.dp).clip(CircleShape),
                            onClick = {
                            },
                        ){
                            Icon(Icons.Filled.FavoriteBorder,"")
                        }
                        IconButton(
                            modifier = Modifier.size(65.dp).clip(CircleShape),
                            onClick = {
                                navController.navigate(ScreenRoute.Cart.route)
                            },
                        ){
                            Icon(painter = painterResource(R.drawable.shopping_cart_24dp_5f6368_fill0_wght400_grad0_opsz24),"")
                        }
                    }
                },
                title = {},
            )

        }
    ) {padding->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(productList){
                FavouriteCard(product =it)
            }
        }
        Row(
            modifier = Modifier
                .padding(bottom = 32.dp)
                .height(70.dp),
            horizontalArrangement = Arrangement.spacedBy(65.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

        }
    }
}