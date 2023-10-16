package com.nyc.schools.presentation.ui.details

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.nyc.schools.data.model.details.NycSchoolDetailsScreenStateTO
import com.nyc.schools.data.model.details.SchoolSatScoresTO
import com.nyc.schools.data.model.landing.SchoolListItem
import com.nyc.schools.presentation.ui.components.LoadingIndicator
import com.nyc.schools.presentation.ui.components.NycSchoolsDivider
import com.nyc.schools.ui.theme.NycSchoolsTheme


/**
 * Job: Display a Nyc school details with sat scores.
 *
 * @author Ketan
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NycSchoolDetailsScreen(
    nycSchoolDetailsScreenStateTO: NycSchoolDetailsScreenStateTO,
    onBackHandler: ()-> Unit,
){
    NycSchoolsTheme {
        Scaffold(
            modifier = Modifier.statusBarsPadding(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = stringResource(id = R.string.nyc_schools_details_title),
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.W700
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { onBackHandler() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back navigation"
                            )
                        }
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
            Box(
                modifier = Modifier.fillMaxSize()
                    .padding(it)
            ) {
                when (nycSchoolDetailsScreenStateTO) {
                    is NycSchoolDetailsScreenStateTO.NycSchoolDetailsContentTO -> {
                       NycSchoolDetailsScreenContent(nycSchoolDetailsScreenStateTO = nycSchoolDetailsScreenStateTO)
                    }
                    is NycSchoolDetailsScreenStateTO.Loading -> {
                        LoadingIndicator()
                    }
                    else -> {
                        EmptyResult()
                    }
                }
            }
        }
    }

}

@Composable
private fun NycSchoolDetailsScreenContent(
    nycSchoolDetailsScreenStateTO: NycSchoolDetailsScreenStateTO.NycSchoolDetailsContentTO
) {
    val schoolListItem = nycSchoolDetailsScreenStateTO.schoolListItem
    val schoolSatScoresTO = nycSchoolDetailsScreenStateTO.schoolSatScoresTO
     val scrollState =  rememberScrollState()
    Column(
        Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
            .fillMaxSize()
    ) {

        Text(
            text = schoolListItem.school_name,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.W700,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
        Spacer(modifier = Modifier.height(16.dp))
        AddSatScores(schoolSatScoresTO)
        NycSchoolsDivider(modifier = Modifier.padding(vertical = 16.dp))
        Text(
            text = stringResource(id = R.string.nyc_schools_overview),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.W500,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = schoolListItem.overview_paragraph,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.W400,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
    }

}

@Composable
private fun AddSatScores(schoolSatScoresTO: SchoolSatScoresTO) {
    Column {
        Text(
            text = stringResource(id = R.string.nyc_schools_sat_result),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.W500,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
        NycSchoolsDivider(modifier = Modifier.padding(vertical = 16.dp))
        Text(
            text = stringResource(
                R.string.nyc_schools_sat_reading_scores,
                schoolSatScoresTO.readingAvgScore,
            ),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.W400,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
        Text(
            text = stringResource(
                R.string.nyc_schools_sat_writing_scores,
                schoolSatScoresTO.satWritingAvgScore
            ),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.W400,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
        Text(
            text = stringResource(
                R.string.nyc_schools_sat_math_scores,
                schoolSatScoresTO.satMathAvgScore
            ),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.W400,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
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

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, group="Dark mode")
@Preview(showBackground = true)
@Composable
fun NycSchoolDetailsScreenPreview() {
    val schoolListItem = SchoolListItem(
        school_name = "North point school",
        overview_paragraph = "This school is a really good school. they have many sports events and good teacher."
    )
    val satScoresTO = SchoolSatScoresTO(
        readingAvgScore = "470",
        satWritingAvgScore = "500",
        satMathAvgScore = "600"
    )
    val nycSchoolDetailsScreenStateTO = NycSchoolDetailsScreenStateTO.NycSchoolDetailsContentTO(schoolListItem = schoolListItem, schoolSatScoresTO = satScoresTO)
    NycSchoolDetailsScreen(
        nycSchoolDetailsScreenStateTO = nycSchoolDetailsScreenStateTO,
        onBackHandler = {}
    )
}