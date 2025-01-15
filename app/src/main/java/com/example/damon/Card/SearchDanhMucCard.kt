package com.example.damon.Card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.damon.R

@Composable
fun SearchDanhMucCard() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeigh = configuration.screenHeightDp.dp
    Card(
        modifier = Modifier
            .padding(7.dp, bottom = 0.dp, top = 0.dp)
            .width(screenWidth * 0.47f)
            .height(60.dp),
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().background(Color(0xFFf2f2f2)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = painterResource(R.drawable.anh1), contentDescription = null)
            Text(
                text = "ÁO KHOÁC LEN DAIF TAY",
                modifier = Modifier.padding(end = 7.dp),
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 15.sp
            )
        }

    }
}