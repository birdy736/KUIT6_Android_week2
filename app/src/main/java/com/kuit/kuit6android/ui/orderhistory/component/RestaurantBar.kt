package com.kuit.kuit6android.ui.orderhistory.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
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
import com.kuit.kuit6android.ui.theme.CoupangEatsTheme

@Composable
fun RestautantBar(
    modifier: Modifier = Modifier,
    restaurantName: String,
    restaurantImageId: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 23.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(restaurantImageId),
            contentDescription = "bbq",
            modifier = modifier
                .size(30.dp)
                .clip(RoundedCornerShape(5.dp))
        )
        Text(
            text = restaurantName,
            style = CoupangEatsTheme.typography.head_03_B_16,
            color = CoupangEatsTheme.colors.black,
            modifier = modifier.padding(start = 10.dp)
        )
        Icon(
            painter = painterResource(R.drawable.ic_right),
            contentDescription = "arrow right",
            modifier = modifier
                .padding(start = 7.dp)
                .size(16.dp)
        )
    }
}