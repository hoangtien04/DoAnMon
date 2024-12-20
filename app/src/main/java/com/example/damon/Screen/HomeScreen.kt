import android.graphics.ColorSpace.Rgb
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.damon.Card.ProductFullScreenCard
import com.example.damon.R
import com.example.damon.Screen.SearchSceen
import kotlinx.coroutines.launch

data class Product(
    val imageResId: Int,
    val title: String,
    val subtitle: String
)


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FullScreenProductList() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val homeSize = remember { Animatable(65f) }
    val searchSize = remember { Animatable(54f) }
    val profileSize = remember { Animatable(54f) }
    val scope = rememberCoroutineScope()
    val productList = listOf(
        Product(R.drawable.a1b33e32e8301949b5b770865289c90b, "Áo len nam", "Thời trang thu đông"),
        Product(R.drawable.a1b33e32e8301949b5b770865289c90b, "Áo hoodie", "Phong cách trẻ trung"),
        Product(R.drawable.a1b33e32e8301949b5b770865289c90b, "Áo khoác dạ", "Thời thượng và ấm áp"),
        Product(R.drawable.a1b33e32e8301949b5b770865289c90b, "Áo sơ mi", "Lịch sự, sang trọng")
    )

    val pagerState = rememberPagerState { productList.size }

    Box(modifier = Modifier.fillMaxSize().background(Color(0xffF2F2F2))) {
//        VerticalPager(
//            modifier = Modifier.fillMaxSize())
//            state = pagerState
//        ) {
            SearchSceen()
//        }
        Column (
            modifier = Modifier.fillMaxSize().padding(top = 24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                modifier = Modifier.fillMaxWidth().height(60.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ){
                IconButton(
                    modifier = Modifier.size(45.dp),
                    onClick = { /* Handle back button click */ }
                ) {
                    Icon(Icons.Rounded.FavoriteBorder, contentDescription = "Back",modifier = Modifier.size(30.dp))
                }
                Spacer(modifier = Modifier.width(2.dp))
                IconButton(
                    modifier = Modifier.size(56.dp),
                    onClick = {  }
                ) {
                    Icon(painter = painterResource(id = R.drawable.shopping_cart_24dp_5f6368_fill0_wght400_grad0_opsz24), contentDescription = "Back",modifier = Modifier.size(30.dp))
                }
                Spacer(modifier = Modifier.width(12.dp))
            }

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
