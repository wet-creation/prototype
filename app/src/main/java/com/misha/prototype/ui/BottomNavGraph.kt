package com.misha.prototype.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.misha.prototype.Const
import com.misha.prototype.Favorite
import com.misha.prototype.Home
import com.misha.prototype.Search

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(BottomBarScreen.Home.route) {
            Home()
        }
        composable(BottomBarScreen.Search.route) {
            Search()
        }
        composable(BottomBarScreen.Favorite.route) {
            Favorite()
        }
    }
}