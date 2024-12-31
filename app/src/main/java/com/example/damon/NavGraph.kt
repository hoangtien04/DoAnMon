package com.example.damon

import FullScreenProductList
import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.damon.Screen.CartScreen
import com.example.damon.Screen.EditProfile
import com.example.damon.Screen.LoginScreen
import com.example.damon.Screen.ManagerScreen
import com.example.damon.Screen.MemberScreen
import com.example.damon.Screen.ProductDetailScreen
import com.example.damon.Screen.RegisterScreen
import com.example.damon.Screen.SearchSceen

sealed class ScreenRoute(val route:String){
    object Home:ScreenRoute("home_screen")
    object Search:ScreenRoute("Search_screen")
    object EditProfile:ScreenRoute("editprofile_screen")
    object Manager:ScreenRoute("manager_screen")
    object Member:ScreenRoute("member_screen")
    object Register:ScreenRoute("register_screen")
    object Login:ScreenRoute("login_screen")
    object ProductDetail:ScreenRoute("productdetail_screen")
    object Cart:ScreenRoute("cart_screen")
}

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = ScreenRoute.Home.route) {
        composable(
            route = ScreenRoute.Home.route
        ){
            FullScreenProductList(navController=navController)
        }
        composable(
            route = ScreenRoute.Search.route
        ){
            SearchSceen(navController=navController)
        }
        composable(
            route = ScreenRoute.EditProfile.route
        ){
            EditProfile()
        }
        composable(
            route = ScreenRoute.Manager.route
        ){
            ManagerScreen(navController=navController)
        }
        composable(
            route = ScreenRoute.Member.route
        ){
            MemberScreen()
        }
        composable(
            route = ScreenRoute.Register.route
        ){
            RegisterScreen()
        }
        composable(
            route = ScreenRoute.Login.route
        ){
            LoginScreen()
        }
        composable(
            route = ScreenRoute.ProductDetail.route
        ){
            ProductDetailScreen(navController=navController)
        }
        composable(
            route = ScreenRoute.Cart.route
        ){
            CartScreen(navController=navController)
        }
    }
}