package com.example.damon.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.damon.DataClass.HinhAnhSanPham
import com.example.damon.DataClass.MauSac
import com.example.damon.DataClass.SanPhamDetail
import com.example.damon.DataClass.SizeDetail
import com.example.damon.DataClass.ThemSanPhamYeuThich
import com.example.damon.ViewModel.AllViewModel
import com.example.damon.ViewModel.SanPhamViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import retrofit2.http.Query


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(navController: NavController,MaSP:String = "",viewModel: SanPhamViewModel,viewModelAll: AllViewModel) {
    val sanPhamDetail by viewModel.sanPhamDetail.collectAsState()
    val NguoiDung = viewModelAll.nguoidungdangnhap

    LaunchedEffect(MaSP) {
        viewModel.getSanPhamDetailByID(maSP = MaSP.toInt())
    }



    viewModel.getSanPhamDetailByID(MaSP.toInt())
    viewModel.getMauSacByID(MaSP.toInt())
    viewModel.getSizeByID(MaSP.toInt())
    viewModel.getKiemTraSPYeuThich(NguoiDung.MaND,MaSP.toInt())

    val listMauSac by viewModel.listMauSac.collectAsState()
    val listSize by viewModel.sizeDetail.collectAsState()
    val isFavorite by viewModel.kiemTraSPYeuThich.collectAsState()
    val hinhAnhSanPham by viewModel.danhSachHinhAnh.collectAsState()



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
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            item { FullWidthImageCarousel(hinhAnhSanPham) }
            item { ProductTitleRow(sanPhamDetail.TenSP, isFavorite) {
                if(NguoiDung.MaND == 0){
                    navController.navigate(ScreenRoute.Login.route)
                }
                else{
                    if (isFavorite) {
                        viewModel.deleteSPYeuThich(NguoiDung.MaND, MaSP.toInt())
                    } else {
                        viewModel.addSanPhamYeuThich(ThemSanPhamYeuThich(NguoiDung.MaND, MaSP.toInt()))
                    }
                }

            }}
            item { ProductColorSelector(listMauSac) { maMau ->
                viewModel.getHinhAnhTheoMaSPVaMaMau(MaSP.toInt(), maMau)
            }  }
            item { ProductSizeSelector(listSize) }
            item { ProductPriceAndRating(sanPhamDetail.DonGia) }
            item { QuantitySelector() }
            item { AddToCartButton() }
            item { ProductDescription(sanPhamDetail.MoTa) }
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun FullWidthImageCarousel(imageUrls: List<HinhAnhSanPham>) {
    val pagerState = rememberPagerState()
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp // Chiều ngang màn hình

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        if (imageUrls.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screenWidth * 1.35f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Không có hình ảnh", color = Color.Gray)
            }
        } else {
            HorizontalPager(
                count = imageUrls.size,
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screenWidth * 1.35f)
            ) { page ->
                Image(
                    painter = rememberAsyncImagePainter(imageUrls[page].DuongDan),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                activeColor = Color.Gray,
                inactiveColor = Color.LightGray
            )
        }
    }
}

@Composable
fun ImageItem(imageUrl: String) {
    Image(
        painter = rememberAsyncImagePainter(imageUrl),
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
            .background(Color.LightGray)
            .fillMaxWidth()
            .height(735.dp)
    )
}

@Composable
fun ProductTitleRow(
    title: String,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, style = MaterialTheme.typography.titleLarge, color = Color.Black)
        IconButton(
            onClick =  onFavoriteClick) {
            Icon(
                imageVector = if (isFavorite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                contentDescription = "Favorite",
                tint = if (isFavorite) Color.Red else Color.Black
            )
        }
    }
}

@Composable
fun ProductColorSelector(listMauSac: List<MauSac>, onColorSelected: (Int) -> Unit) {
    var selectedMaMau by remember { mutableStateOf(listMauSac.firstOrNull()?.MaMau) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Màu sắc:",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
            modifier = Modifier.padding(start = 16.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            listMauSac.forEach { colorHex ->
                Box(
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            color = if (selectedMaMau == colorHex.MaMau) Color.Black else Color.Transparent,
                            shape = RoundedCornerShape(50.dp)
                        )
                        .padding(4.dp)
                        .size(41.dp)
                        .clip(CircleShape)
                        .clickable {
                            selectedMaMau = colorHex.MaMau
                            onColorSelected(colorHex.MaMau) // Gọi callback để lọc hình ảnh
                        }
                        .background(
                            try {
                                hexToColor(colorHex.MauHex)
                            } catch (e: IllegalArgumentException) {
                                Color.Gray // Màu mặc định nếu lỗi
                            }
                        ),
                )
            }
        }
    }
}


@Composable
fun ProductSizeSelector(listSize:List<SizeDetail>) {
    val defaultSize = remember(listSize) { listSize.firstOrNull()?.Size ?: "" }

    // State cho kích thước được chọn, luôn làm mới khi danh sách thay đổi
    var selectedSize by remember { mutableStateOf(defaultSize) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Size:",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp,start = 16.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .horizontalScroll(rememberScrollState()),
        ) {
            listSize.forEach { size ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .border(0.2.dp,Color.Black)
                        .height(35.dp)
                        .width(50.dp)
                        .clickable { selectedSize = size.Size }
                        .background(if (selectedSize == size.Size) Color.Black else Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = size.Size,color = if (selectedSize == size.Size) Color.White else Color.Black)
                }
            }
        }
    }
}

@Composable
fun ProductPriceAndRating(DonGia:Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "${DonGia} VND", style = MaterialTheme.typography.titleLarge, color = Color.Red,fontSize = 27.sp, fontWeight = FontWeight.Bold)
        Text(text = "★★★★½ (134)", style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
    }
}

@Composable
fun AddToCartButton() {
    Button(
        onClick = {  },
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(horizontal = 16.dp)
            .padding(vertical = 11.dp)
        ,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
    ) {
        Text(text = "Thêm vào giỏ hàng", style = MaterialTheme.typography.bodyLarge, color = Color.White)
    }
}

@Composable
fun ProductDescription(subtitle: String) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Mô tả",
            style = MaterialTheme.typography.titleLarge, color = Color.Black,
            modifier = Modifier.padding(bottom = 6.dp)
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun QuantitySelector() {
    // State lưu số lượng hiện tại
    var quantity by remember { mutableStateOf(1) }

    // Container chứa nút tăng giảm
    Row(
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 16.dp,top = 10.dp,bottom = 7.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(16.dp)) // Bo góc toàn bộ
            .background(Color.White, RoundedCornerShape(16.dp))
            ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Nút giảm
        Button(
            onClick = { if (quantity > 1) quantity-- },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("-",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black,
                fontSize = 20.sp)
        }

        // Hiển thị số lượng
        Text(
            text = "$quantity",
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Nút tăng
        Button(
            onClick = { quantity++ }, // Tăng số lượng
            shape = RoundedCornerShape(16.dp), // Bo góc nút phải
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("+",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black,
                fontSize = 20.sp)
        }
    }
}

fun hexToColor(hex: String): Color {
    return Color(android.graphics.Color.parseColor(hex))
}