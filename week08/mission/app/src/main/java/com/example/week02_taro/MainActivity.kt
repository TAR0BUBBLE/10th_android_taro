package com.example.week03_taro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
            ShoppingBottomBar(
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
            modifier = Modifier.fillMaxSize()
        ) {
            composable(BottomTab.Home.route) {
                HomeScreen(innerPadding = innerPadding)
            }

            composable(BottomTab.Shop.route) {
                ShopScreen(innerPadding = innerPadding)
            }

            composable(BottomTab.Wishlist.route) {
                WishlistScreen(innerPadding = innerPadding)
            }

            composable(BottomTab.Cart.route) {
                CartScreen(
                    innerPadding = innerPadding,
                    onMoveToShopClick = {
                        navController.navigateBottomTab(BottomTab.Shop)
                    }
                )
            }

            composable(BottomTab.Profile.route) {
                ProfileScreen(innerPadding = innerPadding)
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
private fun ShoppingBottomBar(
    currentRoute: String,
    onTabClick: (BottomTab) -> Unit
) {
    NavigationBar(
        containerColor = Color.White
    ) {
        bottomTabs.forEach { tab ->
            NavigationBarItem(
                selected = currentRoute == tab.route,
                onClick = { onTabClick(tab) },
                icon = {
                    Icon(
                        imageVector = tab.icon,
                        contentDescription = tab.label
                    )
                },
                label = {
                    Text(text = tab.label)
                }
            )
        }
    }
}