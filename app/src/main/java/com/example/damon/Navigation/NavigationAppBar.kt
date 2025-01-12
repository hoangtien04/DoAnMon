package com.example.damon.Navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavigationAppBar(navController: NavHostController){

    val items = listOf(
        NavItem.Home,
        NavItem.Search,
        NavItem.Manager,
    )
    NavigationBar(
        containerColor = Color(0xFFFFFFFF),
    ){

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination
        items.forEach { item ->
            NavigationBarItem(
                modifier = Modifier.padding(bottom = 12.dp),
                icon = {
                    Box(
                    modifier = Modifier.size(56.dp).background(color = Color.White, shape = CircleShape),
                    ) {
                        Icon(item.icon, contentDescription = "", modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color.Transparent
                ),
                selected = currentRoute?.hierarchy?.any(){
                    it.route == item.route
                } == true,
                onClick = {
                    navController.navigate(item.route){
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it){
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )

        }

    }
}