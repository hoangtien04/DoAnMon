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
    }
}