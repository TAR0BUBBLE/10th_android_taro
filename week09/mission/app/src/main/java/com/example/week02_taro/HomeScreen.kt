package com.example.week03_taro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(78.dp))

            Text(
                text = "Discover",
                color = Color.Black,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 24.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "9월 4일 목요일",
                color = Color(0xFF767676),
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 24.dp)
            )

            Spacer(modifier = Modifier.height(50.dp))

            Image(
                painter = painterResource(id = R.drawable.img_home_banner),
                contentDescription = "홈 배너",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(520.dp)
                    .padding(horizontal = 17.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "What’s new",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 24.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "나이키 최신 상품",
                color = Color(0xFF7B7B7B),
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 24.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            LazyRow(
                contentPadding = PaddingValues(start = 24.dp, end = 12.dp)
            ) {
                items(
                    items = homeProductList,
                    key = { product -> product.stableKey() }
                ) { product ->
                    HomeProductCard(
                        product = product,
                        onClick = {
                            context.openProductDetail(product)
                        }
                    )

                    Spacer(modifier = Modifier.padding(end = 12.dp))
                }
            }
        }
    }
}