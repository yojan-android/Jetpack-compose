package com.yojan.learning.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yojan.learning.ui.launcher.LauncherScreen
import com.yojan.learning.ui.roleType.RoleTypeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationRoutesModel.LauncherScreenNav
    ) {
        composable<NavigationRoutesModel.LauncherScreenNav> {
            LauncherScreen(navController)
        }
        composable<NavigationRoutesModel.RoleTypeScreenNav> {
            RoleTypeScreen(navController)
        }
    }
}