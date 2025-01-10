import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.damon.Card.ProductFullScreenCard
import com.example.damon.Navigation.NavItem
import com.example.damon.R
import com.example.damon.Navigation.ScreenRoute
import kotlinx.coroutines.launch

data class Product(
    val imageResId: Int,
    val title: String,
    val subtitle: String
)


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FullScreenProductList(navRootController: NavHostController) {
    val productList = listOf(
        Product(R.drawable.anh1, "Áo len nam", "Thời trang thu đông"),
        Product(R.drawable.anh1, "Áo hoodie", "Phong cách trẻ trung"),
        Product(R.drawable.anh1, "Áo khoác dạ", "Thời thượng và ấm áp"),
        Product(R.drawable.anh1, "Áo sơ mi", "Lịch sự, sang trọng")
    )
    var navItemController = rememberNavController()
    val items = listOf(
        NavItem.Home,NavItem.Search,NavItem.Manager
    )
    val pagerState = rememberPagerState { productList.size }
    Box(modifier = Modifier.fillMaxSize().background(Color(0xffF2F2F2))) {
        VerticalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState
        ) {
            ProductFullScreenCard(productList[it], onClickCard = {navRootController.navigate(ScreenRoute.ProductDetail.route)})
        }
        /*
        {
//        val homeSize = remember { Animatable(65f) }
//        val searchSize = remember { Animatable(54f) }
//        val profileSize = remember { Animatable(54f) }
//        val scope = rememberCoroutineScope()
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(top = 24.dp),
//            verticalArrangement = Arrangement.SpaceBetween,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            // Hàng trên cùng với các nút yêu thích và giỏ hàng
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(60.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.End
//            ) {
//
//                Spacer(modifier = Modifier.width(2.dp))
//                IconButton(
//                    modifier = Modifier.size(56.dp),
//                    onClick = { navRootController.navigate(ScreenRoute.Cart.route) }
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.shopping_cart_24dp_5f6368_fill0_wght400_grad0_opsz24),
//                        contentDescription = "Cart",
//                        modifier = Modifier.size(30.dp)
//                    )
//                }
//                Spacer(modifier = Modifier.width(12.dp))
//            }
//
//            // Hàng dưới cùng với các biểu tượng điều hướng chính
//            Row(
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .padding(bottom = 32.dp)
//                    .height(70.dp),
//                horizontalArrangement = Arrangement.spacedBy(65.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                // Biểu tượng Home
//                Box(
//                    modifier = Modifier
//                        .clip(CircleShape)
//                        .size(homeSize.value.dp)
//                        .clickable {
//                            scope.launch {
//                                if (homeSize.value != 65f) {
//                                    homeSize.animateTo(65f, animationSpec = tween(100))
//                                    searchSize.animateTo(54f, animationSpec = tween(100))
//                                    profileSize.animateTo(54f, animationSpec = tween(100))
//                                    navRootController.navigate(NavItem.Home.route)
//                                }
//                            }
//                        }
//                        .background(Color.White)
//                ) {
//                    Icon(
//                        Icons.Default.Home,
//                        contentDescription = "Home",
//                        modifier = Modifier
//                            .align(Alignment.Center)
//                            .size(32.dp)
//                    )
//                }
//
//                Box(
//                    modifier = Modifier
//                        .clip(CircleShape)
//                        .size(searchSize.value.dp)
//                        .clickable {
//                            scope.launch {
//                                if (searchSize.value != 65f) {
//                                    homeSize.animateTo(54f, animationSpec = tween(100))
//                                    searchSize.animateTo(65f, animationSpec = tween(100))
//                                    profileSize.animateTo(54f, animationSpec = tween(100))
//                                    navRootController.navigate(NavItem.Search.route)
//                                }
//                            }
//                        }
//                        .background(Color.White)
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.baseline_search_24),
//                        contentDescription = "Search",
//                        modifier = Modifier
//                            .align(Alignment.Center)
//                            .size(32.dp)
//                    )
//                }
//
//                // Biểu tượng Profile
//                Box(
//                    modifier = Modifier
//                        .clip(CircleShape)
//                        .size(profileSize.value.dp)
//                        .clickable {
//                            scope.launch {
//                                if (profileSize.value != 65f) {
//                                    homeSize.animateTo(54f, animationSpec = tween(100))
//                                    searchSize.animateTo(54f, animationSpec = tween(100))
//                                    profileSize.animateTo(65f, animationSpec = tween(100))
//                                    navRootController.navigate(NavItem.Manager.route)
//                                }
//                            }
//                        }
//                        .background(Color.White)
//                ) {
//                    Icon(
//                        Icons.Default.Person,
//                        contentDescription = "Profile",
//                        modifier = Modifier
//                            .align(Alignment.Center)
//                            .size(32.dp)
//                    )
//                }
//            }
//        }
        }
        */
    }
}