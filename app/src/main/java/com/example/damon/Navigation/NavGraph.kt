package com.example.damon.Navigation

import FullScreenProductList
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.damon.Screen.*

sealed class ScreenRoute(val route: String) {
    object Main : ScreenRoute("main_screen")
    object EditProfile : ScreenRoute("editprofile_screen")
    object Member : ScreenRoute("member_screen")
    object Register : ScreenRoute("register_screen")
    object Login : ScreenRoute("login_screen")
    object ProductDetail : ScreenRoute("productdetail_screen")
    object Cart : ScreenRoute("cart_screen")
    object Favourite : ScreenRoute("favourite_screen")
    object Oder : ScreenRoute("oder_screen/{selectedTab}") {
        fun createRoute(selectedTab: Int) = "oder_screen/$selectedTab"
    }

    object WaitingForConfirmation : ScreenRoute("waiting_for_confirmation_screen")
    object WaitingForPickup : ScreenRoute("waiting_for_pickup_screen")
    object WaitingForDelivery : ScreenRoute("waiting_for_delivery_screen")
    object Rating : ScreenRoute("rating_screen")
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
        composable(
            route = ScreenRoute.Oder.route,
            arguments = listOf(navArgument("selectedTab") { type = NavType.IntType })
        ) { backStackEntry ->
            val selectedTab = backStackEntry.arguments?.getInt("selectedTab") ?: 0
            OrderScreen(navController = navController, initialTab = selectedTab)
        }


        composable(route = ScreenRoute.WaitingForConfirmation.route) {
            WaitingForConfirmationScreen(navController = navController)
        }
        composable(route = ScreenRoute.WaitingForPickup.route) {
            WaitingForPickupScreen(navController = navController)
        }
        composable(route = ScreenRoute.WaitingForDelivery.route) {
            WaitingForDeliveryScreen(navController = navController)
        }
        composable(route = ScreenRoute.Rating.route) {
            RatingScreen(navController = navController)
        }
    }
}

sealed class NavItem(val icon: ImageVector, val route: String) {
    object Home : NavItem(Icons.Default.Home, "home_screen")
    object Search : NavItem(Icons.Default.Search, "search_screen")
    object Manager : NavItem(Icons.Default.Person, "manager_screen")
}

@Composable
fun NavigationBarGraph(navItemController: NavHostController, navRootController: NavHostController) {
    NavHost(navController = navItemController, startDestination = NavItem.Home.route) {
        composable(route = NavItem.Home.route) {
            FullScreenProductList(navRootController = navRootController)
        }
        composable(route = NavItem.Search.route) {
            SearchScreen(navController = navRootController)
        }
        composable(route = NavItem.Manager.route) {
            ManagerScreen(navController = navRootController)
        }
    }
}
