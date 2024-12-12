import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.damon.R

data class Product(
    val imageResId: Int,
    val title: String,
    val subtitle: String
)


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FullScreenProductList() {
    val productList = listOf(
        Product(R.drawable.a1b33e32e8301949b5b770865289c90b, "Áo len nam", "Thời trang thu đông"),
        Product(R.drawable.a1b33e32e8301949b5b770865289c90b, "Áo hoodie", "Phong cách trẻ trung"),
        Product(R.drawable.a1b33e32e8301949b5b770865289c90b, "Áo khoác dạ", "Thời thượng và ấm áp"),
        Product(R.drawable.a1b33e32e8301949b5b770865289c90b, "Áo sơ mi", "Lịch sự, sang trọng")
    )

    val pagerState = rememberPagerState { productList.size }

    Box(modifier = Modifier.fillMaxSize()) {
        VerticalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState
        ) { page ->
            val product = productList[page]
            ProductFullScreenCard(product)
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /* Handle home button click */ },
                modifier = Modifier.size(48.dp).border(3.dp, color = Color.Black).clip(CircleShape)
            ) {
                Icon(Icons.Filled.Home, contentDescription = "Home", modifier = Modifier.size(32.dp))
            }
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(
                onClick = { /* Handle search button click */ },
                modifier = Modifier.size(48.dp).border(3.dp, color = Color.Black).clip(CircleShape)
            ) {
                Icon(Icons.Filled.Search, contentDescription = "Search", modifier = Modifier.size(32.dp))
            }
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(
                onClick = { /* Handle profile button click */ },
                modifier = Modifier.size(48.dp).border(3.dp, color = Color.Black).clip(CircleShape)
            ) {
                Icon(Icons.Filled.Person, contentDescription = "Profile", modifier = Modifier.size(32.dp))
            }
        }
    }
}

@Composable
fun ProductFullScreenCard(product: Product) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = product.imageResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = product.title,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = product.subtitle,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.LightGray
                )
            )
        }
    }
}