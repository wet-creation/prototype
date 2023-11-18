package com.misha.prototype.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.misha.prototype.Const

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    object Home: BottomBarScreen(
        route = Const.home,
        title = "Home",
        selectedIcon = Icons.Outlined.Home,
        unselectedIcon = Icons.Outlined.Home
    )
    object Search: BottomBarScreen(
        route = Const.search,
        title = "Search",
        selectedIcon = Icons.Outlined.Search,
        unselectedIcon = Icons.Outlined.Search
    )
    object Favorite: BottomBarScreen(
        route = Const.favorite,
        title = "Favorite",
        selectedIcon = Icons.Outlined.FavoriteBorder,
        unselectedIcon = Icons.Filled.FavoriteBorder
    )
}
