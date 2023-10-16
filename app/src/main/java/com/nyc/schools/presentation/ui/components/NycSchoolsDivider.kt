package com.nyc.schools.presentation.ui.components

import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource

@Composable
fun NycSchoolsDivider(
    modifier: Modifier = Modifier,
) {
    Divider(
        modifier = modifier,
        color = Color.Gray
    )

}