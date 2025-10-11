package com.kuit.kuit6android.ui.orderhistory.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kuit.kuit6android.extension.toDecimalFormat
import com.kuit.kuit6android.ui.components.CoupangEatsRoundedButton
import com.kuit.kuit6android.ui.theme.CoupangEatsTheme

@Composable
fun CartBottomBar(
    modifier: Modifier = Modifier,
    totalPrice: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(CoupangEatsTheme.colors.gray100)
            .navigationBarsPadding()
            .padding(vertical = 14.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = totalPrice.toDecimalFormat() + "원",
                style = CoupangEatsTheme.typography.head_02_B_20,
                color = CoupangEatsTheme.colors.black
            )
            Spacer(Modifier.padding(bottom = 5.dp))
            Text(
                text = "주문 가능",
                style = CoupangEatsTheme.typography.body_01_M_14,
                color = CoupangEatsTheme.colors.black
            )
        }
        CoupangEatsRoundedButton(
            modifier = Modifier,
            "바로 주문",
            CoupangEatsTheme.colors.mint,
            null
        )
    }
}