package com.nyc.schools.presentation.navigation.landing

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.nyc.schools.constant.Constants
import com.nyc.schools.data.model.landing.SchoolListItem
import com.nyc.schools.presentation.navigation.NycSchoolsRoute
import com.nyc.schools.presentation.ui.landing.NycSchoolsLandingScreen
import com.nyc.schools.presentation.viewmodel.landing.NycSchoolsLandingViewModel


@Composable
fun NycSchoolsLandingScreenNavEntry(
    navController: NavController,
){
    val context = LocalContext.current
    val viewModel: NycSchoolsLandingViewModel = hiltViewModel()
    val nycSchoolsLandingScreenStateTO = remember { viewModel.state }
    NycSchoolsLandingScreen(
        nycSchoolsLandingScreenStateTO= nycSchoolsLandingScreenStateTO.value,
        onNycSchoolListItemOnClick = { navigationToNycSchoolDetails(context,navController,it) },
        onNycSchoolPhoneNumberOnClick = { makeAPhoneCAllToNycSchool(context, it)}
    )
}

private fun makeAPhoneCAllToNycSchool(context: Context, phoneNumber: String) {
    val intent = Intent(Intent.ACTION_DIAL)
    intent.data = Uri.parse("tel:$phoneNumber")
    context.startActivity(intent)
}

private fun navigationToNycSchoolDetails(context: Context, navController: NavController, schoolListItem: SchoolListItem) {
    val currentBackStackEntry = navController.currentBackStackEntry ?: return
    val savedStateHandle = currentBackStackEntry.savedStateHandle
    savedStateHandle[Constants.NYC_SCHOOL_SELECTED_TO_SHOW_DETAILS] = schoolListItem
    navController.navigate(NycSchoolsRoute.DETAILS.route)
}
