package com.example.week03_taro

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CartScreen(
    innerPadding: PaddingValues,
    onMoveToShopClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(innerPadding)
            .padding(horizontal = 24.dp, vertical = 40.dp)
            .clickable(onClick = onMoveToShopClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Outlined.ShoppingBag,
            contentDescription = "장바구니",
            tint = Color.Black
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "장바구니가 비어있습니다.",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "화면을 누르면 구매하기 탭으로 이동합니다.",
            color = Color(0xFF767676),
            fontSize = 14.sp
        )
    }
}

@Composable
fun ProfileScreen(
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(innerPadding)
            .padding(horizontal = 24.dp, vertical = 40.dp)
    ) {
        Icon(
            imageVector = Icons.Outlined.PersonOutline,
            contentDescription = "프로필",
            tint = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "프로필",
            color = Color.Black,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "TARO",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Compose Migration 진행 중",
            color = Color(0xFF767676),
            fontSize = 14.sp
        )
    }
}