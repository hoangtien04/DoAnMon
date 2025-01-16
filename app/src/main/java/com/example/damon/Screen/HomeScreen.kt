import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.damon.DataClass.SanPhamCard
//import com.example.damon.Card.ProductFullScreenCard
//import com.example.damon.DataClass.SanPhamMain
import com.example.damon.Navigation.NavItem
import com.example.damon.R
import com.example.damon.Navigation.ScreenRoute
import com.example.damon.ViewModel.AllViewModel
//
//data class Product(
//    val imageResId: Int,
//    val title: String,
//    val subtitle: String
//)


//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun FullScreenProductList(navRootController: NavHostController,viewModel: AllViewModel) {
//    viewModel.getAllSanPham()
//    val listSanPhamMain by viewModel.listSanPham.collectAsState()
//
//    val pagerState = rememberPagerState { listSanPhamMain.size }
//    Box(modifier = Modifier.fillMaxSize().background(Color(0xffF2F2F2))) {
//        VerticalPager(
//            modifier = Modifier.fillMaxSize(),
//            state = pagerState
//        ) {
////            ProductFullScreenCard(listSanPhamMain[it], onClickCard = {navRootController.navigate(ScreenRoute.ProductDetail.route)})
//        }
//    }
//}