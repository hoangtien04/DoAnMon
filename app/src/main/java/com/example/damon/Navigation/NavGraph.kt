package com.example.damon.Navigation

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
import com.example.damon.ViewModel.AllViewModel
import com.example.damon.ViewModel.SanPhamViewModel

sealed class ScreenRoute(val route: String) {
    object Main : ScreenRoute("main_screen")
    object EditProfile : ScreenRoute("editprofile_screen")
    object Member : ScreenRoute("member_screen")
    object Register : ScreenRoute("register_screen")
    object Login : ScreenRoute("login_screen")
    object ProductDetail : ScreenRoute("productdetail_screen")
    object Cart : ScreenRoute("cart_screen")
    object Favourite : ScreenRoute("favourite_screen")
    object ProductList : ScreenRoute("productlist_screen")
    object comfirmPassword:ScreenRoute("comfrimpassword")
    object Oder : ScreenRoute("oder_screen/{selectedTab}") {
        fun createRoute(selectedTab: Int) = "oder_screen/$selectedTab"
    }

    object WaitingForConfirmation : ScreenRoute("waiting_for_confirmation_screen")
    object WaitingForPickup : ScreenRoute("waiting_for_pickup_screen")
    object WaitingForDelivery : ScreenRoute("waiting_for_delivery_screen")
    object Rating : ScreenRoute("rating_screen")
}

@Composable
fun NavGraph(navController: NavHostController,viewModel: AllViewModel,viewModel2: SanPhamViewModel) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.Main.route
    ) {
        composable(route = ScreenRoute.Main.route) {
            MainScreen(navRootController = navController,viewModel = viewModel ,viewModel2 = viewModel2)
        }
        composable(route = ScreenRoute.EditProfile.route) {
            EditProfile(navController = navController, viewModel = viewModel)
        }
        composable(route = ScreenRoute.Member.route) {
            MemberScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = ScreenRoute.Register.route) {
            RegisterScreen(navController = navController)
        }
        composable(route = ScreenRoute.Login.route) {
            LoginScreen(navController = navController, viewModel = viewModel)
        }
        composable(
            route = ScreenRoute.ProductDetail.route + "?MaSP={MaSP}",
            arguments = listOf(navArgument("MaSP"){nullable = true})
        ) {
            var MaSP = it.arguments?.getString("MaSP")
            if(MaSP!=null)
            ProductDetailScreen(navController = navController,MaSP,viewModel2)
        }
        composable(route = ScreenRoute.Cart.route) {
            CartScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = ScreenRoute.Favourite.route) {
            FavouriteScreen(navController = navController, viewModel = viewModel2,viewModelAll = viewModel)
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
        composable(route = NavItem.Search2.route) {
            SearchScreen2(navController = navController,viewModel = viewModel2)
        }
        composable(route = ScreenRoute.ProductList.route) {
            ProductList(navController,viewModel2)
        }
    }
}

sealed class NavItem(val icon: ImageVector, val route: String) {
    object Home : NavItem(Icons.Default.Home, "home_screen")
    object Search : NavItem(Icons.Default.Search, "search_screen")
    object Manager : NavItem(Icons.Default.Person, "manager_screen")
    object Search2 : NavItem(Icons.Default.Search, "search2_screen")
    object ProductList : ScreenRoute("productlist_screen")

}

@Composable
fun NavigationBarGraph(
    navItemController: NavHostController, navRootController: NavHostController,
    viewModel: AllViewModel,
    viewModel2: SanPhamViewModel
) {
    NavHost(navController = navItemController, startDestination = NavItem.Home.route) {
        composable(route = NavItem.Home.route) {
//            ProductList(navItemController,viewModel)
        }
        composable(route = NavItem.Search.route) {
            SearchScreen(navController = navRootController,viewModel2)
        }
        composable(route = NavItem.Manager.route) {
            ManagerScreen(navController = navRootController, viewModel = viewModel)
        }

    }

}
