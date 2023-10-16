package com.nyc.schools.presentation.navigation.details

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.nyc.schools.constant.Constants
import com.nyc.schools.data.model.landing.SchoolListItem
import com.nyc.schools.presentation.viewmodel.details.NycSchoolsDetailsViewModel
import com.nyc.schools.presentation.ui.details.NycSchoolDetailsScreen

@Composable
fun NycSchoolDetailsScreenNavEntry(
    navController: NavController,
){
    val viewModel: NycSchoolsDetailsViewModel = hiltViewModel()
    val previousBackStackEntry =  navController.previousBackStackEntry
    val savedStateHandle =   previousBackStackEntry?.savedStateHandle
    val selectedNycSchoolListItem = savedStateHandle?.get<SchoolListItem>(Constants.NYC_SCHOOL_SELECTED_TO_SHOW_DETAILS)
    val nycSchoolDetailsScreenState = remember { viewModel.initScreen(selectedNycSchoolListItem!!)}

    NycSchoolDetailsScreen(
        nycSchoolDetailsScreenStateTO= nycSchoolDetailsScreenState.value,
        onBackHandler = { onBackHandler(navController) }
    )

    BackHandler {
        onBackHandler(navController)
    }
}

private fun onBackHandler(navController: NavController) {
    navController.popBackStack()
}
