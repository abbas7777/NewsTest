package ir.ahe.abbas.newstest.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ir.ahe.abbas.newstest.R

sealed class ScreenItem(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val drawableRes: Int
) {

    object Home : ScreenItem("home", R.string.bnav_home, R.drawable.ic_home_24dp)
    object Category : ScreenItem("category", R.string.bnav_cat, R.drawable.ic_cat_24dp)
}