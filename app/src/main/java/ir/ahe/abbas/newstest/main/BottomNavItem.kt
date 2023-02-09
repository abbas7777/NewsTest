package ir.ahe.abbas.newstest.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ir.ahe.abbas.newstest.R

sealed class BottomNavItem(
    val route: String,
    @StringRes val label: Int,
    @DrawableRes val drawableRes: Int
) {

    object Home : BottomNavItem("home", R.string.bnav_home, R.drawable.ic_home_24dp)
    object Category : BottomNavItem("category", R.string.bnav_cat, R.drawable.ic_cat_24dp)
}