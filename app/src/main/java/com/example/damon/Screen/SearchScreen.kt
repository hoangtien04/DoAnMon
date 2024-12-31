package com.example.damon.Screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ScrollState
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.damon.Card.SearchDanhMucCard
import com.example.damon.R
import com.example.damon.ScreenRoute
import kotlinx.coroutines.launch

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SearchSceen(navController: NavController){
    val homeSize = remember { Animatable(54f) }
    val searchSize = remember { Animatable(65f) }
    val profileSize = remember { Animatable(54f) }
    val scope = rememberCoroutineScope()
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
            Row(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(bottom = 32.dp)
                    .height(70.dp),
                horizontalArrangement = Arrangement.spacedBy(65.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(homeSize.value.dp)
                        .clickable{
                            scope.launch {
                                if(homeSize.value == 65f){

                                }
                                else{
                                    // Thu nhỏ Box
                                    homeSize.animateTo(65f, animationSpec = tween(100)) // Thu nhỏ lại 100.dp
                                    searchSize.animateTo(54f, animationSpec = tween(100))
                                    profileSize.animateTo(54f, animationSpec = tween(100))
                                    navController.navigate(ScreenRoute.Home.route)
                                }
                            }
                        }
                        .background(Color.White)


                ){
                    Icon(Icons.Default.Home, contentDescription = "Search", modifier = Modifier.align(Alignment.Center).size(32.dp))
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clip(CircleShape)
                        .size(searchSize.value.dp)
                        .clickable{
                            scope.launch {
                                if(searchSize.value == 65f){

                                }
                                else{
                                    // Thu nhỏ Box
                                    homeSize.animateTo(54f, animationSpec = tween(100)) // Thu nhỏ lại 100.dp
                                    searchSize.animateTo(65f, animationSpec = tween(100))
                                    profileSize.animateTo(54f, animationSpec = tween(100))
                                }
                            }
                        }
                        .background(Color.White)
                ){
                    Icon(painter = painterResource(id = R.drawable.baseline_search_24), contentDescription = "Search", modifier = Modifier.align(Alignment.Center).size(32.dp))
                }
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(profileSize.value.dp)
                        .clickable{
                            scope.launch {
                                if(profileSize.value == 65f){

                                }
                                else{
                                    // Thu nhỏ Box
                                    homeSize.animateTo(54f, animationSpec = tween(100)) // Thu nhỏ lại 100.dp
                                    searchSize.animateTo(54f, animationSpec = tween(100))
                                    profileSize.animateTo(65f, animationSpec = tween(100))
                                    navController.navigate(ScreenRoute.Manager.route)
                                }
                            }
                        }
                        .background(Color.White)
                ){
                    Icon(Icons.Default.Person, contentDescription = "Search", modifier = Modifier.align(Alignment.Center).size(32.dp))
                }
            }
        }

    }

}