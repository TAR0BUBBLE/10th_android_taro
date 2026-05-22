package com.example.week03_taro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeProductItem(
    product: Product,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = product.imageResId),
            contentDescription = product.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .background(Color(0xFFF5F5F5))
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = product.title,
            color = Color.Black,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = product.price,
            color = Color.Black,
            fontSize = 14.sp
        )
    }
}

@Composable
fun ProductListItem(
    product: Product,
    onClick: () -> Unit,
    showFavoriteIcon: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.Top
    ) {
        Image(
            painter = painterResource(id = product.imageResId),
            contentDescription = product.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(140.dp)
                .aspectRatio(1f)
                .background(Color(0xFFF5F5F5))
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            if (product.badge.isNotBlank()) {
                Text(
                    text = product.badge,
                    color = Color(0xFFFF7A00),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))
            }

            Text(
                text = product.title,
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            if (product.subtitle.isNotBlank()) {
                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = product.subtitle,
                    color = Color(0xFF6F6F6F),
                    fontSize = 13.sp
                )
            }

            if (product.colorCount.isNotBlank()) {
                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = product.colorCount,
                    color = Color(0xFF6F6F6F),
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.price,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }

        if (showFavoriteIcon) {
            Icon(
                imageVector = if (product.isFavorite) {
                    Icons.Filled.Favorite
                } else {
                    Icons.Outlined.FavoriteBorder
                },
                contentDescription = "위시리스트",
                tint = if (product.isFavorite) Color.Red else Color.Gray,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(24.dp)
            )
        }
    }
}