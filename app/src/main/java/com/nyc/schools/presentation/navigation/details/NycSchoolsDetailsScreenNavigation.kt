package com.nyc.schools.presentation.navigation.details

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nyc.schools.presentation.navigation.NycSchoolsRoute

fun NavGraphBuilder.nycSchoolDetailsScreen(
    navController: NavController,
) {
    composable(
        route = NycSchoolsRoute.DETAILS.route,
        enterTransition = { EnterTransition.None},
        exitTransition = { ExitTransition.None},
        popEnterTransition = { EnterTransition.None},
        popExitTransition = { ExitTransition.None},
    ) {
        NycSchoolDetailsScreenNavEntry(navController)
    }
}