package com.example.damon

import FullScreenProductList
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.damon.Screen.CartScreen
import com.example.damon.Screen.EditProfile
import com.example.damon.Screen.FavouriteScreen
import com.example.damon.Screen.LoginScreen
import com.example.damon.Screen.MainScreen
import com.example.damon.Screen.ManagerScreen
import com.example.damon.Screen.MemberScreen
import com.example.damon.Screen.ProductDetailScreen
import com.example.damon.Screen.RegisterScreen
import com.example.damon.Screen.SearchScreen


sealed class ScreenRoute(val route: String) {
    object Main : ScreenRoute("main_screen")
    object EditProfile : ScreenRoute("editprofile_screen")
    object Member : ScreenRoute("member_screen")
    object Register : ScreenRoute("register_screen")
    object Login : ScreenRoute("login_screen")
    object ProductDetail : ScreenRoute("productdetail_screen")
    object Cart : ScreenRoute("cart_screen")
    object Favourite : ScreenRoute("favourite_screen")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ScreenRoute.Main.route) {
        composable(route = ScreenRoute.Main.route) {
            MainScreen(navRootController = navController)
        }
        composable(route = ScreenRoute.EditProfile.route) {
            EditProfile()
        }
        composable(route = ScreenRoute.Member.route) {
            MemberScreen()
        }
        composable(route = ScreenRoute.Register.route) {
            RegisterScreen()
        }
        composable(route = ScreenRoute.Login.route) {
            LoginScreen()
        }
        composable(route = ScreenRoute.ProductDetail.route) {
            ProductDetailScreen(navController = navController)
        }
        composable(route = ScreenRoute.Cart.route) {
            CartScreen(navController = navController)
        }
        composable(route = ScreenRoute.Favourite.route) {
            FavouriteScreen(navController = navController)
        }
    }
}

sealed class NavItem(val icon: ImageVector, val route: String) {
    object Home : NavItem(Icons.Default.Home, "home_screen")
    object Search : NavItem(Icons.Default.Search, "search_screen")
    object Manager : NavItem(Icons.Default.Person, "manager_screen")
}

@Composable
fun NavigationBarGraph(navItemController:NavHostController, navRootController:NavHostController){
    NavHost(
        navItemController,
        startDestination = NavItem.Home.route
    ) {
        composable(route = NavItem.Home.route) {
            FullScreenProductList(navController = navRootController)
        }
        composable(route = NavItem.Search.route) {
            SearchScreen(navController = navRootController)
        }
        composable(route = NavItem.Manager.route) {
            ManagerScreen(navController = navRootController)
        }
    }
}