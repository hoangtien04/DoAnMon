package com.example.damon.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Equalizer
import androidx.compose.material.icons.filled.FilterDrama
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.damon.Card.ProductListCard
import com.example.damon.DataClass.SanPhamCard
import com.example.damon.Navigation.ScreenRoute
import com.example.damon.R
import com.example.damon.ViewModel.AllViewModel
import com.example.damon.ViewModel.SanPhamViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductList(navController: NavController, viewModel: SanPhamViewModel,searchText:String = "") {
    var expandedKM by remember { mutableStateOf(false) }
    var expandedKC by remember { mutableStateOf(false) }
    var selectedOptionKM by remember { mutableStateOf("Loại sản phẩm") }
    var selectedOptionKC by remember { mutableStateOf("Kích Cỡ") }
    val itemsKhuyenMai = listOf( "Áo dệt kim", "Quần áo nỉ")
    val itemsKichCo = listOf("S", "X", "M")

    viewModel.getAllSanPham()
    val listSanPham by viewModel.listSanPham.collectAsState()

    val filteredSanPham by viewModel.filteredSanPham.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    SearchBar(onSearch = {
                            query ->
                        viewModel.searchSanPham(query)
                    })
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 45.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Row(modifier = Modifier.fillMaxWidth().padding(start = 7.dp)) {

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
                            .width(165.dp)
                            .height(48.dp),
                        shape = RoundedCornerShape(50.dp),
                        textStyle = TextStyle(fontSize = 14.sp),
                        colors = TextFieldDefaults.colors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
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

                Spacer(modifier = Modifier.width(7.dp))

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
                            .width(165.dp)
                            .height(48.dp),
                        shape = RoundedCornerShape(50.dp),
                        textStyle = TextStyle(fontSize = 14.sp),
                        maxLines = 1,
                        colors = TextFieldDefaults.colors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,

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
            Box(modifier = Modifier.fillMaxWidth()) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(filteredSanPham) {
                        ProductListCard(
                            sanPham = it,
                            onClick = {
                                navController.navigate(ScreenRoute.ProductDetail.route + "?MaSP=${it.MaSP}")
                            },
                        )
                    }
                }
            }
        }
    }
}
