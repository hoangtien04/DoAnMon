package com.example.damon.Screen

import Product
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Equalizer
import androidx.compose.material.icons.filled.FilterDrama
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.damon.Card.ProductListCard
import com.example.damon.R

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductList() {
    // Trạng thái của từng menu
    var expandedKM by remember { mutableStateOf(false) } // Menu "Chương trình khuyến mãi"
    var expandedKC by remember { mutableStateOf(false) } // Menu "Kích cỡ"
    var selectedOptionKM by remember { mutableStateOf("Khuyến mãi") }
    var selectedOptionKC by remember { mutableStateOf("Kích Cỡ") }

    val itemsKhuyenMai = listOf( "Giảm 50%", "Giảm 10%")
    val itemsKichCo = listOf("S", "X", "M")
    val productList = listOf(
        Product(R.drawable.anh1, "Áo len nam", "Thời trang thu đông"),
        Product(R.drawable.anh1, "Áo hoodie", "Phong cách trẻ trung"),
        Product(R.drawable.anh1, "Áo khoác dạ", "Thời thượng và ấm áp"),
        Product(R.drawable.anh1, "Áo sơ mi", "Lịch sự, sang trọng"),
        Product(R.drawable.anh1, "Áo len nam", "Thời trang thu đông"),
        Product(R.drawable.anh1, "Áo hoodie", "Phong cách trẻ trung"),
        Product(R.drawable.anh1, "Áo khoác dạ", "Thời thượng và ấm áp"),
        Product(R.drawable.anh1, "Áo len nam", "Thời trang thu đông"),
        Product(R.drawable.anh1, "Áo hoodie", "Phong cách trẻ trung"),
        Product(R.drawable.anh1, "Áo khoác dạ", "Thời thượng và ấm áp"),

    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Equalizer,
                    contentDescription = "Lọc sản phẩm"
                )
            }

            // Spinner cho "Chương trình khuyến mãi"
            ExposedDropdownMenuBox(
                expanded = expandedKM,
                onExpandedChange = { expandedKM = !expandedKM }
            ) {
                TextField(
                    value = selectedOptionKM,
                    onValueChange = {},
                    readOnly = true, // Chỉ đọc
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedKM)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .width(150.dp)
                        .height(40.dp),
                    shape = RoundedCornerShape(50.dp),
                    textStyle = TextStyle(fontSize = 11.sp),
                    colors = TextFieldDefaults.colors(
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                    )
                )

                ExposedDropdownMenu(
                    expanded = expandedKM,
                    onDismissRequest = { expandedKM = false } // Đóng menu khi click ra ngoài
                ) {
                    itemsKhuyenMai.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item) },
                            onClick = {
                                selectedOptionKM = item // Cập nhật mục đã chọn
                                expandedKM = false // Đóng menu
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Spinner cho "Kích cỡ"
            ExposedDropdownMenuBox(
                expanded = expandedKC,
                onExpandedChange = { expandedKC = !expandedKC }
            ) {
                TextField(
                    value = selectedOptionKC,
                    onValueChange = {},
                    readOnly = true, // Chỉ đọc
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedKC)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .width(150.dp)
                        .height(40.dp),
                    shape = RoundedCornerShape(50.dp),
                    textStyle = TextStyle(fontSize = 10.sp),
                    maxLines = 1,
                    colors = TextFieldDefaults.colors(
                        unfocusedIndicatorColor = Color.Transparent,

                    )
                )

                ExposedDropdownMenu(
                    expanded = expandedKC,
                    onDismissRequest = { expandedKC = false } // Đóng menu khi click ra ngoài
                ) {
                    itemsKichCo.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item) },
                            onClick = {
                                selectedOptionKC = item // Cập nhật mục đã chọn
                                expandedKC = false // Đóng menu
                            }
                        )
                    }
                }
            }
        }
        Box(modifier = Modifier.fillMaxWidth()){
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(productList){
                    ProductListCard()
                }
            }
        }
    }
}
