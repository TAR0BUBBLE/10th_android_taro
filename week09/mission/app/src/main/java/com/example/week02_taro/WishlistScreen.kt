package com.example.week03_taro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WishlistScreen() {
    val context = LocalContext.current
    val productRows = wishlistProductList.chunked(2)

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        contentPadding = PaddingValues(
            start = 14.dp,
            end = 14.dp,
            bottom = 12.dp
        )
    ) {
        item {
            Spacer(modifier = Modifier.height(78.dp))

            Text(
                text = "위시리스트",
                color = Color.Black,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 16.dp, end = 10.dp, bottom = 16.dp)
            )
        }

        items(
            items = productRows,
            key = { row ->
                row.joinToString(separator = "|") { product -> product.stableKey() }
            }
        ) { row ->
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                row.forEach { product ->
                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        WishlistProductCard(
                            product = product,
                            onClick = {
                                context.openProductDetail(product)
                            }
                        )
                    }
                }

                if (row.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}