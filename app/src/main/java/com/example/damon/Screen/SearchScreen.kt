package com.example.damon.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.damon.Card.SearchDanhMucCard
import com.example.damon.R
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SearchScreen(navController: NavController){
    val configuration = LocalConfiguration.current
    val screenHeigh = configuration.screenHeightDp.dp
    var searchText = remember{mutableStateOf("")}
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeigh * 0.71f)
        ) {
            items(10){
            FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp),
                ){
                    SearchDanhMucCard()
                    SearchDanhMucCard()
                }
            }
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(650.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp,top = 15.dp, end = 15.dp)
                    .border(0.5.dp, Color.LightGray, RoundedCornerShape(100.dp))
                    .clickable {
                            navController.navigate("search2_screen")
                    }
                    .height(52.dp),
                contentAlignment = Alignment.Center
                )
            {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.search1),
                        contentDescription = null,
                        modifier = Modifier.size(45.dp).padding(start = 10.dp),
                        tint = Color(0xFF676767)
                    )
                    Text(
                        text = "Tìm kiếm sản phẩm",
                        color = Color(0xFFA4A4A4),
                        modifier = Modifier.padding(start = 10.dp,top = 10.dp),
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}