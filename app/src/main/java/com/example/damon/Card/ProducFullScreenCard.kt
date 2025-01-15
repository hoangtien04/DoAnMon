package com.example.damon.Card

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

//
//@SuppressLint("InvalidColorHexValue")
//@Composable
//fun ProductFullScreenCard(onClickCard:()->Unit) {
//    Card(onClick = onClickCard) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            AsyncImage(
//                model = product.DuongDan,
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxSize()
//            )
//            Column(
//                modifier = Modifier
//                    .fillMaxSize(),
//                verticalArrangement = Arrangement.Bottom,
//                horizontalAlignment = Alignment.Start
//            ) {
//                Text(
//                    text = product.TenSP,
//                    style = TextStyle(
//                        fontSize = 27.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.Black
//                    ),
//                    modifier = Modifier.background(Color(0x74FFFFFF)).padding(8.dp).fillMaxWidth()
//                )
//                Text(
//                    text = product.TenLoai,
//                    style = TextStyle(
//                        fontSize = 19.sp,
//                        color = Color(0xFF1F1F1F)
//                    ),
//                    modifier = Modifier.background(Color(0x74FFFFFF)).padding(8.dp).fillMaxWidth()
//                )
//            }
//        }
//    }
//}