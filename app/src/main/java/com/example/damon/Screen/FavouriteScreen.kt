package com.example.damon.Screen

import Product
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.damon.Card.FavouriteCard
import com.example.damon.Navigation.ScreenRoute
import com.example.damon.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteScreen(navController: NavController) {
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
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape),
                        onClick = { navController.popBackStack()  }
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape),
                        onClick = {  }
                    ) {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Favorite",
                            tint = Color.Red
                        )
                    }
                    IconButton(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape),
                        onClick = { navController.navigate(ScreenRoute.Cart.route) }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.shopping_cart_24dp_5f6368_fill0_wght400_grad0_opsz24),
                            contentDescription = "Cart"
                        )
                    }
                },
                title = { Text(text = "Yêu thích", style = MaterialTheme.typography.titleLarge) },
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(productList) { product ->
                FavouriteCard(product = product)
            }
        }
    }
}
