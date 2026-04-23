package com.tugas3.ppab_03_l0124133_muftifarismurtadho.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tugas3.ppab_03_l0124133_muftifarismurtadho.ui.theme.PlayGreen
import com.tugas3.ppab_03_l0124133_muftifarismurtadho.ui.theme.PlayOnSurfaceVariant

@Composable
fun SectionHeader(
    title: String,
    subtitle: String = "",
    showMoreButton: Boolean = true,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
            if (showMoreButton) {
                TextButton(
                    onClick = {},
                    contentPadding = PaddingValues(horizontal = 4.dp)
                ) {
                    Text(
                        text = "More",
                        color = PlayGreen,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
        if (subtitle.isNotEmpty()) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = PlayOnSurfaceVariant,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}
