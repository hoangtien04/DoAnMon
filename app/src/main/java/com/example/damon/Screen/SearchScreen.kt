package com.example.damon.Screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.unit.dp
import com.example.damon.Card.SearchDanhMucCard
import com.example.damon.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SearchSceen(){
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeigh = configuration.screenHeightDp.dp
    var searchText = remember{mutableStateOf("")}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 68.dp),
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
                .height(550.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp,top = 15.dp, end = 15.dp)
                    .border(0.5.dp, Color.LightGray, RoundedCornerShape(100.dp))
                    .padding(start = 9.dp)
                ,
                value = searchText.value,
                onValueChange = {searchText.value = it},
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.search1),contentDescription = null,modifier = Modifier.size(45.dp))
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                shape = RoundedCornerShape(100.dp),
                placeholder = {
                    Text(text = "Tìm kiếm sản phẩm",color = Color.LightGray)
                }
            )
        }
    }

}