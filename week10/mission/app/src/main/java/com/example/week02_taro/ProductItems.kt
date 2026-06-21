package com.example.week03_taro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeProductCard(
    product: Product,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(314.dp)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = product.imageResId),
            contentDescription = product.title,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(314.dp)
                .background(Color(0xFFEFEFEF))
                .padding(12.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = product.title,
            color = Color.Black,
            fontSize = 17.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = product.price,
            color = Color(0xFF7B7B7B),
            fontSize = 17.sp
        )
    }
}

@Composable
fun ShopProductCard(
    product: Product,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .background(Color(0xFFEFEFEF))
        ) {
            Image(
                painter = painterResource(id = product.imageResId),
                contentDescription = product.title,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            )

            Text(
                text = if (product.isFavorite) "♥" else "♡",
                color = if (product.isFavorite) Color.Red else Color.Black,
                fontSize = 22.sp,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(10.dp)
            )
        }

        if (product.badge.isNotBlank()) {
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = product.badge,
                color = Color(0xFFF26B1D),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        } else {
            Spacer(modifier = Modifier.height(10.dp))
        }

        Text(
            text = product.title,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        if (product.subtitle.isNotBlank()) {
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = product.subtitle,
                color = Color(0xFF8A8A8A),
                fontSize = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

        if (product.colorCount.isNotBlank()) {
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = product.colorCount,
                color = Color(0xFF8A8A8A),
                fontSize = 14.sp,
                maxLines = 1
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = product.price,
            color = Color.Black,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun WishlistProductCard(
    product: Product,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = product.imageResId),
            contentDescription = product.title,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .background(Color(0xFFEFEFEF))
                .padding(12.dp)
                .clipToBounds()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = product.title,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        if (product.subtitle.isNotBlank()) {
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = product.subtitle,
                color = Color(0xFF8A8A8A),
                fontSize = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

        if (product.colorCount.isNotBlank()) {
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = product.colorCount,
                color = Color(0xFF8A8A8A),
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = product.price,
            color = Color.Black,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))
    }
}