package com.example.week03_taro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShopScreen() {
    val context = LocalContext.current
    val productRows = shopProductList.chunked(2)

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
            Spacer(modifier = Modifier.height(74.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 9.dp, bottom = 16.dp),
                verticalAlignment = Alignment.Top
            ) {
                ShopCategoryTab(
                    text = "전체",
                    selected = true
                )

                Spacer(modifier = Modifier.width(24.dp))

                ShopCategoryTab(
                    text = "Tops & T-Shirts",
                    selected = false
                )

                Spacer(modifier = Modifier.width(24.dp))

                ShopCategoryTab(
                    text = "sale",
                    selected = false
                )
            }
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
                        ShopProductCard(
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

@Composable
private fun ShopCategoryTab(
    text: String,
    selected: Boolean
) {
    val textColor = if (selected) Color.Black else Color(0xFF8E8E8E)

    Column(
        modifier = Modifier.width(IntrinsicSize.Max),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            maxLines = 1,
            modifier = Modifier.padding(horizontal = if (selected) 24.dp else 0.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(if (selected) Color.Black else Color.Transparent)
        )
    }
}