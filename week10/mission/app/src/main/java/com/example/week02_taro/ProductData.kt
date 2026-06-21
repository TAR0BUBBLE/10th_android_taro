package com.example.week03_taro

import android.content.Context
import android.content.Intent

fun Product.stableKey(): String {
    return "$imageResId-$title-$price"
}

fun Intent.putProductExtras(product: Product) {
    putExtra("imageResId", product.imageResId)
    putExtra("title", product.title)
    putExtra("subtitle", product.subtitle)
    putExtra("price", product.price)
    putExtra("colorCount", product.colorCount)
    putExtra("badge", product.badge)
    putExtra("description", product.description)
    putExtra("shownColor", product.shownColor)
    putExtra("styleCode", product.styleCode)
}

fun Context.openProductDetail(product: Product) {
    val intent = Intent(this, ProductDetailActivity::class.java).apply {
        putProductExtras(product)
    }
    startActivity(intent)
}

val homeProductList = listOf(
    Product(
        imageResId = R.drawable.img_product_jordan_black,
        title = "Air Jordan XXXVI",
        price = "US$185"
    ),
    Product(
        imageResId = R.drawable.img_product_jordan_white,
        title = "Air Jordan 1 Low",
        price = "US$145"
    ),
    Product(
        imageResId = R.drawable.img_product_mid,
        title = "Air Jordan 1 Mid",
        price = "US$125"
    )
)

val shopProductList = listOf(
    Product(
        imageResId = R.drawable.img_product_socks,
        title = "Nike Everyday Plus Cushioned",
        subtitle = "Training Ankle Socks (6 Pairs)",
        colorCount = "5 Colours",
        price = "US$10",
        description = "The Nike Everyday Plus Cushioned Socks bring comfort to your workout with extra cushioning under the heel and forefoot and a snug, supportive arch band.\nSweat-wicking power and breathability up top help keep your feet dry and cool to help push you through that extra set.",
        shownColor = "Multi-Color",
        styleCode = "SX6897-965",
        isFavorite = true
    ),
    Product(
        imageResId = R.drawable.img_product_socks2,
        title = "Nike Elite Crew",
        subtitle = "Basketball Socks",
        colorCount = "7 Colours",
        price = "US$16",
        description = "Basketball socks designed for support and comfort during play.",
        shownColor = "White/Black",
        styleCode = "DX1234-100"
    ),
    Product(
        imageResId = R.drawable.img_product_airforce,
        title = "Nike Air Force 1 '07",
        subtitle = "Women's Shoes",
        colorCount = "5 Colours",
        price = "US$115",
        badge = "BestSeller",
        description = "The radiance lives on in the Nike Air Force 1 '07, the basketball original that puts a fresh spin on what you know best.",
        shownColor = "White",
        styleCode = "DD8959-100"
    ),
    Product(
        imageResId = R.drawable.img_product_airforce2,
        title = "Jordan ENike Air Force 1 '07sentials",
        subtitle = "Men's Shoes",
        colorCount = "2 Colours",
        price = "US$115",
        badge = "BestSeller",
        description = "Classic court style with premium materials and everyday comfort.",
        shownColor = "White/Gray",
        styleCode = "HF0001-101"
    )
)

val wishlistProductList = listOf(
    Product(
        imageResId = R.drawable.img_product_mid,
        title = "Air Jordan 1 Mid",
        price = "US$125",
        description = "Inspired by the original AJ1, this mid-top edition maintains the iconic look you love.",
        shownColor = "White",
        styleCode = "DQ8426-100"
    ),
    Product(
        imageResId = R.drawable.img_product_socks,
        title = "Nike Everyday Plus Cushioned",
        subtitle = "Training Ankle Socks (6 Pairs)",
        colorCount = "5 Colours",
        price = "US$10",
        description = "The Nike Everyday Plus Cushioned Socks bring comfort to your workout with extra cushioning under the heel and forefoot and a snug, supportive arch band.",
        shownColor = "Multi-Color",
        styleCode = "SX6897-965"
    )
)