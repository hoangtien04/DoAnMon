package com.example.damon.Screen

import Product
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.damon.R
import com.example.damon.Navigation.ScreenRoute
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(navController: NavController) {
    val product = Product(R.drawable.anh1, "Miracle Air Quần Dài", "Vải Cotton-like")
    var isFavorite by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack()  }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate(ScreenRoute.Favourite.route) }) {
                        Icon(
                            imageVector = Icons.Rounded.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = Color.Black
                        )
                    }
                    IconButton(onClick = { navController.navigate(ScreenRoute.Cart.route) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.shopping_cart_24dp_5f6368_fill0_wght400_grad0_opsz24),
                            contentDescription = "Cart",
                            tint = Color.Black
                        )
                    }
                },
                modifier = Modifier.drawBehind {
                    val lineHeight = size.height
                    drawLine(
                        color = Color.Gray,
                        start = Offset(0f, lineHeight),
                        end = Offset(size.width, lineHeight),
                        strokeWidth = 2f
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        containerColor = Color.White
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { ProductImage(product.imageResId) }
            item { ProductTitleRow(product.title, isFavorite) { isFavorite = !isFavorite } }
            item { ProductColorSelector() }
            item { ProductSizeSelector() }
            item { ProductPriceAndRating() }
            item { AddToCartButton() }
            item { ProductDescription(product.subtitle) }
        }
    }
}


@Composable
fun ProductImage(imageResId: Int) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = "Product Image",
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ProductTitleRow(title: String, isFavorite: Boolean, onFavoriteClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, style = MaterialTheme.typography.titleLarge, color = Color.Black)
        IconButton(onClick = onFavoriteClick) {
            Icon(
                imageVector = if (isFavorite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                contentDescription = "Favorite",
                tint = if (isFavorite) Color.Red else Color.Black
            )
        }
    }
}

@Composable
fun ProductColorSelector() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Màu sắc:",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            val colors = listOf(Color.Red, Color.Blue, Color.Green, Color.Black, Color.Gray)
            items(colors) { color ->
                Button(
                    onClick = { },
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .padding(4.dp)
                        .clip(CircleShape),
                    colors = ButtonDefaults.buttonColors(containerColor = color),
                    contentPadding = PaddingValues(0.dp)
                ) {}
            }
        }
    }
}


@Composable
fun ProductSizeSelector() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Size:",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            items(listOf("S", "M", "L", "XL", "XXL")) { size ->
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
                ) {
                    Text(text = size, color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun ProductPriceAndRating() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "980,000 VND", style = MaterialTheme.typography.titleLarge, color = Color.Black)
        Text(text = "★★★★½ (134)", style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
    }
}

@Composable
fun AddToCartButton() {
    Button(
        onClick = {  },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
    ) {
        Text(text = "Thêm vào giỏ hàng", style = MaterialTheme.typography.bodyLarge, color = Color.White)
    }
}

@Composable
fun ProductDescription(subtitle: String) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = "Mô tả sản phẩm:", style = MaterialTheme.typography.titleMedium, color = Color.Black)
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            textAlign = TextAlign.Justify
        )
    }
}
