package com.client.vivekwolf.android.ui_utils.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.client.vivekwolf.android.ui_utils.ui.md_theme_light_error

@Composable
fun LinearProgressBar(
    modifier: Modifier = Modifier
) {
    LinearProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .height(2.dp),
        color = md_theme_light_error
    )
}
