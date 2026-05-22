package com.example.week03_taro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
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
fun ShopScreen(
    innerPadding: PaddingValues
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .background(Color.White)
            .padding(innerPadding),
        contentPadding = PaddingValues(
            start = 24.dp,
            end = 24.dp,
            top = 32.dp,
            bottom = 24.dp
        ),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        item {
            ShopCategoryTabs()
        }

        items(
            items = shopProductList,
            key = { product -> product.stableKey() }
        ) { product ->
            ProductListItem(
                product = product,
                showFavoriteIcon = true,
                onClick = {
                    context.openProductDetail(product)
                }
            )
        }
    }
}

@Composable
private fun ShopCategoryTabs() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ShopCategoryTab(text = "전체", selected = true)
        Spacer(modifier = Modifier.width(24.dp))
        ShopCategoryTab(text = "Tops & T-Shirts", selected = false)
        Spacer(modifier = Modifier.width(24.dp))
        ShopCategoryTab(text = "sale", selected = false)
    }
}

@Composable
private fun ShopCategoryTab(
    text: String,
    selected: Boolean
) {
    val textColor = if (selected) Color.Black else Color(0xFF8E8E8E)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 14.sp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(8.dp))

        HorizontalDivider(
            thickness = 2.dp,
            color = if (selected) Color.Black else Color.Transparent
        )
    }
}