package com.nyc.schools.presentation.navigation.landing

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nyc.schools.presentation.navigation.NycSchoolsRoute

fun NavGraphBuilder.nycSchoolsLandingScreen(
    navController: NavController,
) {
    composable(
        route = NycSchoolsRoute.LANDING.route,
        enterTransition = { EnterTransition.None},
        exitTransition = { ExitTransition.None},
        popEnterTransition = { EnterTransition.None},
        popExitTransition = { ExitTransition.None},
    ) {
        NycSchoolsLandingScreenNavEntry(navController)
    }
}