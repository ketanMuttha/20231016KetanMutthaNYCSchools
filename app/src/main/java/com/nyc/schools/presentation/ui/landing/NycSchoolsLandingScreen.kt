package com.nyc.schools.presentation.ui.landing

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nyc.schools.R
import com.nyc.schools.data.model.landing.NycSchoolsLandingScreenStateTO
import com.nyc.schools.data.model.landing.SchoolListItem
import com.nyc.schools.presentation.ui.components.LoadingIndicator
import com.nyc.schools.presentation.ui.components.NycSchoolsCard
import com.nyc.schools.ui.theme.NycSchoolsTheme

/**
 * Job: Display Nyc schools list.
 *
 * @author Ketan
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NycSchoolsLandingScreen(
    nycSchoolsLandingScreenStateTO: NycSchoolsLandingScreenStateTO?,
    onNycSchoolListItemOnClick: (schoolListItem: SchoolListItem) -> Unit,
    onNycSchoolPhoneNumberOnClick: (phoneNumber: String) -> Unit,
) {
    NycSchoolsTheme {
        Scaffold(
            modifier = Modifier.statusBarsPadding(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = stringResource(id = R.string.nyc_schools_landing_title),
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.W700
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            },
            containerColor = colorResource(id = R.color.nyc_schools_background),
        ) {
            when (nycSchoolsLandingScreenStateTO) {
                is NycSchoolsLandingScreenStateTO.NycSchoolsContentTO -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        val schoolListItems = nycSchoolsLandingScreenStateTO.schoolListItem
                        NycSchoolsLandingScreenContent(
                            schoolListItems = schoolListItems,
                            onNycSchoolListItemOnClick = onNycSchoolListItemOnClick,
                            onNycSchoolPhoneNumberOnClick = onNycSchoolPhoneNumberOnClick,
                        )
                    }
                }

                is NycSchoolsLandingScreenStateTO.Loading -> {
                    LoadingIndicator()
                }

                else -> {
                    EmptyResult()
                }
            }

        }
    }
}

@Composable
private fun EmptyResult() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.nyc_schools_landing_result),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
    }

}

@Composable
private fun NycSchoolsLandingScreenContent(
    schoolListItems: List<SchoolListItem>,
    onNycSchoolListItemOnClick: (schoolListItem: SchoolListItem) -> Unit,
    onNycSchoolPhoneNumberOnClick: (phoneNumber: String) -> Unit,
) {
    val lazyListState = rememberLazyListState()
    LazyColumn(
        state = lazyListState,
    ) {
        val lastItemIndex = schoolListItems.size - 1
        schoolListItems.forEachIndexed { index, schoolListItem ->
            item {
                NycSchoolsListItem(
                    schoolListItem = schoolListItem,
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .clickable {
                            onNycSchoolListItemOnClick(schoolListItem)
                        },
                    onNycSchoolPhoneNumberOnClick = {
                        onNycSchoolPhoneNumberOnClick( it )
                    }
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NycSchoolsListItem(
    schoolListItem: SchoolListItem,
    modifier: Modifier,
    onNycSchoolPhoneNumberOnClick: (phoneNumber: String) -> Unit,
) {
    NycSchoolsCard(
        title = schoolListItem.school_name,
        description = schoolListItem.primary_address_line_1,
        phoneNumber = schoolListItem.phone_number,
        modifier = modifier,
        onNycSchoolPhoneNumberOnClick = onNycSchoolPhoneNumberOnClick
    )
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, group="Dark mode")
@Preview(showBackground = true)
@Composable
fun NycSchoolLandingScreenPreview() {
    val schoolListItem = SchoolListItem(
        school_name = "North point school",
        overview_paragraph = "This school is a really good school. they have many sports events and good teacher."
    )
    val schoolListItems = listOf(
        schoolListItem
    )
    val nycSchoolsLandingScreenStateTO = NycSchoolsLandingScreenStateTO.NycSchoolsContentTO(schoolListItems)
     NycSchoolsLandingScreen(
            nycSchoolsLandingScreenStateTO = nycSchoolsLandingScreenStateTO,
            onNycSchoolListItemOnClick = {},
            onNycSchoolPhoneNumberOnClick = {},
         )
}