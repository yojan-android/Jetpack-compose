package com.yojan.learning.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationRoutesModel {
    @Serializable
    object LauncherScreenNav : NavigationRoutesModel()
    @Serializable
    object RoleTypeScreenNav : NavigationRoutesModel() {
    }
    @Serializable
    object SettingsScreenNav : NavigationRoutesModel()
    @Serializable
    object NotificationScreenNav : NavigationRoutesModel()
    @Serializable
    object RecentPlayScreenNav : NavigationRoutesModel()
    @Serializable
    data class ArtistScreenNav(val artistName : String? = null) : NavigationRoutesModel()
    @Serializable
    object SpotifyWrappedScreenNav : NavigationRoutesModel() {

    }

    @Serializable
    object TopSongsAndArtist : NavigationRoutesModel()
    @Serializable
    data class EditorsPicksNav(val name : String? = null) : NavigationRoutesModel()
    @Serializable
    object HomeScreenNav : NavigationRoutesModel()
    @Serializable
    object SearchScreenNav : NavigationRoutesModel()
    @Serializable
    object LibraryScreenNav : NavigationRoutesModel() {
    }

}
