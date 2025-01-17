package com.example.damon.Card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.damon.DataClass.MauSac
import com.example.damon.DataClass.SanPhamCard
import com.example.damon.R
import com.example.damon.ViewModel.SanPhamViewModel
import org.jetbrains.annotations.Async

@Composable
fun ProductListCard(
    sanPham:SanPhamCard,
    onClick: () -> Unit,
){
    Card(
        modifier = Modifier.fillMaxSize().clickable {
            onClick()
        },
    ) {
        Column() {
            AsyncImage(
                model = sanPham.DuongDan,
                contentDescription = "",
                modifier = Modifier.fillMaxWidth()
                    .fillMaxSize()
            )

            Row(modifier = Modifier.fillMaxWidth().padding(top = 8.dp, start = 10.dp)) {
//                listMauSac.forEach { colorHex ->
//                    Box(
//                        modifier = Modifier
//                            .padding(4.dp)
//                            .size(41.dp)
//                            .clip(CircleShape)
//                            .background(Color(android.graphics.Color.parseColor(colorHex.MauHex))),
//                    )
//                }
                Icon(imageVector = Icons.Filled.FavoriteBorder
                    , contentDescription = "",
                    modifier = Modifier.padding(start = 250.dp)
                )
            }
            Text(
                text = sanPham.TenSP,
                modifier = Modifier
                    .padding(10.dp,top = 10.dp, bottom = 3.dp),
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Column(modifier = Modifier.fillMaxWidth().padding(start = 10.dp,bottom = 10.dp)) {
                Text("${sanPham.TenLoai}", fontSize = 13.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text("${sanPham.DonGia} VND",
                    fontSize = 18.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                    )
            }
        }
    }
}