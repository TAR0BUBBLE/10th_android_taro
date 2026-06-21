package com.example.week03_taro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(
                colorScheme = lightColorScheme(
                    background = Color.White,
                    surface = Color.White
                )
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    ShoppingApp()
                }
            }
        }
    }
}

private sealed class BottomTab(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    data object Home : BottomTab("home", "홈", Icons.Outlined.Home)
    data object Shop : BottomTab("shop", "구매하기", Icons.Outlined.Search)
    data object Wishlist : BottomTab("wishlist", "위시리스트", Icons.Outlined.FavoriteBorder)
    data object Cart : BottomTab("cart", "장바구니", Icons.Outlined.ShoppingBag)
    data object Profile : BottomTab("profile", "프로필", Icons.Outlined.PersonOutline)
}

private val bottomTabs = listOf(
    BottomTab.Home,
    BottomTab.Shop,
    BottomTab.Wishlist,
    BottomTab.Cart,
    BottomTab.Profile
)

@Composable
private fun ShoppingApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: BottomTab.Home.route

    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            TaroBottomBar(
                currentRoute = currentRoute,
                onTabClick = { tab ->
                    navController.navigateBottomTab(tab)
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomTab.Home.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(BottomTab.Home.route) {
                HomeScreen()
            }

            composable(BottomTab.Shop.route) {
                ShopScreen()
            }

            composable(BottomTab.Wishlist.route) {
                WishlistScreen()
            }

            composable(BottomTab.Cart.route) {
                CartScreen(
                    onMoveToShopClick = {
                        navController.navigateBottomTab(BottomTab.Shop)
                    }
                )
            }

            composable(BottomTab.Profile.route) {
                ProfileScreen()
            }
        }
    }
}

private fun NavHostController.navigateBottomTab(tab: BottomTab) {
    navigate(tab.route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

@Composable
private fun TaroBottomBar(
    currentRoute: String,
    onTabClick: (BottomTab) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .windowInsetsPadding(WindowInsets.navigationBars),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        bottomTabs.forEach { tab ->
            val selected = currentRoute == tab.route
            val color = if (selected) Color.Black else Color(0xFF767676)

            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onTabClick(tab) },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = tab.icon,
                    contentDescription = tab.label,
                    tint = color,
                    modifier = Modifier.size(24.dp)
                )

                Text(
                    text = tab.label,
                    color = color,
                    fontSize = 10.sp,
                    fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
}