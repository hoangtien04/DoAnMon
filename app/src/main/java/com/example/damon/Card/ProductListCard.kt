package com.example.damon.Card

import Product
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.damon.R

@Preview
@Composable
fun ProductListCard(){
    Card(modifier = Modifier.fillMaxSize()) {
        Column() {
            Image(
                painter = painterResource(R.drawable.anh1),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth()
                    .fillMaxSize()
            )
            Row(modifier = Modifier.fillMaxWidth().padding(top = 30.dp, start = 10.dp)) {

                Box(
                    modifier = Modifier
                        .clip(CircleShape).size(22  .dp)
                        .background(color = Color.Red)

                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .clip(CircleShape).size(22.dp)
                        .background(color = Color.Blue)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .clip(CircleShape).size(22.dp)
                        .background(color = Color.Yellow)
                )
                Icon(imageVector = Icons.Filled.FavoriteBorder
                    , contentDescription = "",
                    modifier = Modifier.padding(start = 250.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier.fillMaxWidth().padding(start = 10.dp)) {
                Text("UNISEX S-XL")
                Text("KAWS + Warhoi Quần Nỉ")
                Spacer(modifier = Modifier.height(10.dp))
                Text("784.000 VND ",
                    fontSize = 25.sp )
            }
        }
    }
}