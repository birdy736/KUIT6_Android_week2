package com.kuit.kuit6android.ui.orderhistory.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kuit.kuit6android.R
import com.kuit.kuit6android.extension.toDecimalFormat
import com.kuit.kuit6android.ui.orderhistory.data.CartWithMenuData
import com.kuit.kuit6android.ui.theme.CoupangEatsTheme

@Composable
fun WithMenuItem(
    modifier: Modifier = Modifier,
    withMenu : CartWithMenuData
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(withMenu.imageId),
            contentDescription = "menu image",
            modifier = modifier
                .clip(RoundedCornerShape(10.dp))
                .size(50.dp)
        )
        Column(
            modifier = modifier.weight(1f).padding(start = 8.dp)
        ) {
            Text(
                text = withMenu.menuName,
                style = CoupangEatsTheme.typography.head_04_SB_14,
                color = CoupangEatsTheme.colors.black
            )
            Spacer(Modifier.padding(bottom = 5.dp))
            Text(
                text = withMenu.price.toDecimalFormat() + "원",
                style = CoupangEatsTheme.typography.body_02_R_12,
                color = CoupangEatsTheme.colors.black
            )
        }
        Column(
            modifier = modifier
                .size(30.dp)
                .clip(RoundedCornerShape(15.dp))
                .border(1.dp, CoupangEatsTheme.colors.gray300, RoundedCornerShape(15.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.add_button),
                contentDescription = "add",
                modifier = modifier.size(15.dp),
                tint = CoupangEatsTheme.colors.black
            )
        }
    }
}