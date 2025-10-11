package com.kuit.kuit6android.ui.orderhistory.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.kuit.kuit6android.ui.theme.CoupangEatsTheme

@Composable
fun GetMethod(
    modifier : Modifier = Modifier,
              isSelected : Boolean,
              method : String,
              deliveryTime1 : Int,
              deliveryTime2 : Int,
              onClick: () -> Unit
) {
    val borderColor =
        if (isSelected) CoupangEatsTheme.colors.black
        else CoupangEatsTheme.colors.gray300

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .border(1.dp, borderColor, RoundedCornerShape(20.dp))
            .clickable { onClick() }
            .padding(20.dp)
    ) {
        Text(
            text = method,
            style = CoupangEatsTheme.typography.head_03_B_16,
            color = CoupangEatsTheme.colors.black
        )
        Spacer(Modifier.padding(bottom = 9.dp))
        Text(
            text = "${deliveryTime1}~${deliveryTime2}분 후 도착",
            style = CoupangEatsTheme.typography.head_04_SB_14,
            color = CoupangEatsTheme.colors.black
        )
    }
}