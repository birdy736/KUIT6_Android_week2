package com.kuit.kuit6android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kuit.kuit6android.ui.theme.CoupangEatsTheme

@Composable
fun CoupangEatsRoundedButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    backgroundColor: androidx.compose.ui.graphics.Color,
    borderColor: androidx.compose.ui.graphics.Color?
) {
    Button(
        modifier = modifier
            .width(131.dp)
            .height(43.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 0.dp),
        border = borderColor?.let { BorderStroke(1.dp, it) }
    ) {
        Text(
            text = buttonText,
            style = CoupangEatsTheme.typography.head_03_B_16,
            color = CoupangEatsTheme.colors.black
        )
    }
}