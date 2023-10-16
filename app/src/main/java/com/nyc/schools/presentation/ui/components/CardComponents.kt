package com.nyc.schools.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nyc.schools.ui.theme.card_bg

@ExperimentalMaterial3Api
@Composable
fun NycSchoolsCard(
    title: String,
    description: String,
    phoneNumber: String,
    modifier: Modifier = Modifier,
    onNycSchoolPhoneNumberOnClick:((String) -> Unit)? = null
) {

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = card_bg,
        ),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.W700
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.W500

            )
            Spacer(modifier = Modifier.height(24.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    shape = RoundedCornerShape(16),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = Color.White
                    ),
                    onClick = {
                        onNycSchoolPhoneNumberOnClick?.invoke(phoneNumber)
                    }
                ) {
                    Text(
                        text = "Phone # $phoneNumber", fontSize = 14.sp  , style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.W500
                    )

                }
                Spacer(modifier = Modifier.height(24.dp).weight(1.0f))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun NycSchoolsCardPreview() {

    NycSchoolsCard(
        title = "Nyv schoo name",
        description = "Great school",
        phoneNumber = "9090909090",
        modifier = Modifier
    )
}