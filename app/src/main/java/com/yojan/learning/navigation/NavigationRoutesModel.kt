package com.yojan.learning.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationRoutesModel {
    @Serializable
    object LauncherScreenNav : NavigationRoutesModel()
    @Serializable
    object RoleTypeScreenNav : NavigationRoutesModel() {
    }

}
