package com.yojan.learning.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.yojan.learning.ui.launcher.LauncherScreen
import com.yojan.learning.ui.roleType.RoleTypeScreen
import com.yojan.learning.ui.spotifyUI.bottomMenu.LibraryScreenUI
import com.yojan.learning.ui.spotifyUI.bottomMenu.SearchScreenUI
import com.yojan.learning.ui.spotifyUI.bottomMenu.SpotifyHome
import com.yojan.learning.ui.spotifyUI.topArtist.TopArtistScreenUI
import com.yojan.learning.ui.spotifyUI.topMenu.NotificationScreenUI
import com.yojan.learning.ui.spotifyUI.topMenu.RecentlyPlayedScreenUI
import com.yojan.learning.ui.spotifyUI.topMenu.SettingsScreenUI

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RestrictedApi")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val showBottomNav =
        currentDestination?.hasRoute<NavigationRoutesModel.HomeScreenNav>() == true ||
                currentDestination?.hasRoute<NavigationRoutesModel.SearchScreenNav>() == true ||
                currentDestination?.hasRoute<NavigationRoutesModel.LibraryScreenNav>() == true

    Scaffold(
        bottomBar = {
            if(showBottomNav) {
                NavigationBar {
                    NavigationBarItem(
                        selected = currentDestination.hasRoute<NavigationRoutesModel.HomeScreenNav>(),
                        onClick = {
                            navController.navigate(NavigationRoutesModel.HomeScreenNav) {
                                popUpTo(NavigationRoutesModel.HomeScreenNav) { inclusive = false }
                                launchSingleTop = true
                            }
                        },
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                        label = { Text("Home") }
                    )
                    NavigationBarItem(
                        selected = currentDestination.hasRoute<NavigationRoutesModel.SearchScreenNav>(),
                        onClick = {
                            navController.navigate(NavigationRoutesModel.SearchScreenNav) {
                                popUpTo(NavigationRoutesModel.HomeScreenNav) { inclusive = false }
                                launchSingleTop = true
                            }
                        },
                        icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                        label = { Text("Search") }
                    )
                    NavigationBarItem(
                        selected = currentDestination.hasRoute<NavigationRoutesModel.LibraryScreenNav>(),
                        onClick = {
                            navController.navigate(NavigationRoutesModel.LibraryScreenNav) {
                                popUpTo(NavigationRoutesModel.HomeScreenNav) { inclusive = false }
                                launchSingleTop = true
                            }
                        },
                        icon = { Icon(Icons.Default.LibraryMusic, contentDescription = "Library") },
                        label = { Text("Library") }
                    )
                }
            }
        }
    ) { innerPadding->
        NavHost(modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = NavigationRoutesModel.HomeScreenNav
        ) {
            composable<NavigationRoutesModel.HomeScreenNav> {
                SpotifyHome(navController)
            }
            composable<NavigationRoutesModel.LauncherScreenNav> {
                LauncherScreen(navController)
            }
            composable<NavigationRoutesModel.RoleTypeScreenNav> {
                RoleTypeScreen(navController)
            }
            composable<NavigationRoutesModel.SearchScreenNav> {
                SearchScreenUI(navController)
            }
            composable<NavigationRoutesModel.LibraryScreenNav> {
                LibraryScreenUI(navController)
            }
            composable<NavigationRoutesModel.ArtistScreenNav> { backStackEntry ->
                val args = backStackEntry.toRoute<NavigationRoutesModel.ArtistScreenNav>()
                TopArtistScreenUI(navController = navController,
                    artistName = args.artistName)
            }
            composable<NavigationRoutesModel.SettingsScreenNav> {
                SettingsScreenUI(navController)
            }
            composable<NavigationRoutesModel.RecentPlayScreenNav> {
                RecentlyPlayedScreenUI(navController)
            }
            composable<NavigationRoutesModel.NotificationScreenNav> {
                NotificationScreenUI(navController)
            }
        }
    }
}