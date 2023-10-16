package com.nyc.schools.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.nyc.schools.presentation.navigation.details.nycSchoolDetailsScreen
import com.nyc.schools.presentation.navigation.landing.nycSchoolsLandingScreen

@Composable
fun NycSchoolsRouteNavHost(
    startDestination: NycSchoolsRoute = NycSchoolsRoute.LANDING
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination.route
    ) {
        nycSchoolsLandingScreen(
            navController,
        )
        nycSchoolDetailsScreen(
            navController
        )
    }
}
