package com.kuit.kuit6android.ui.orderhistory.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.kuit.kuit6android.extension.toDecimalFormat
import com.kuit.kuit6android.ui.theme.CoupangEatsTheme

@Composable
fun CheckPrice(
    modifier: Modifier = Modifier,
    totalPrice: Int,
    deliveryTip: Int) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .border(1.dp, CoupangEatsTheme.colors.gray300, RoundedCornerShape(20.dp))
            .padding(vertical = 20.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "메뉴 금액",
                style = CoupangEatsTheme.typography.body_02_SB_12,
                color = CoupangEatsTheme.colors.black
            )
            Text(
                text = totalPrice.toDecimalFormat() + "원",
                style = CoupangEatsTheme.typography.body_02_SB_12,
                color = CoupangEatsTheme.colors.black
            )
        }
        Spacer(Modifier.padding(bottom = 10.dp))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "배달팁",
                style = CoupangEatsTheme.typography.body_02_SB_12,
                color = CoupangEatsTheme.colors.black
            )
            Text(
                text = deliveryTip.toDecimalFormat() +"원",
                style = CoupangEatsTheme.typography.body_02_SB_12,
                color = CoupangEatsTheme.colors.black
            )
        }
        HorizontalDivider(
            Modifier.padding(bottom = 15.dp),
            1.dp,
            CoupangEatsTheme.colors.gray300
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "결제예정금액",
                style = CoupangEatsTheme.typography.head_04_SB_14,
                color = CoupangEatsTheme.colors.black
            )
            Text(
                text = (totalPrice-deliveryTip).toDecimalFormat() + "원",
                style = CoupangEatsTheme.typography.head_04_SB_14,
                color = CoupangEatsTheme.colors.black
            )
        }
    }
}