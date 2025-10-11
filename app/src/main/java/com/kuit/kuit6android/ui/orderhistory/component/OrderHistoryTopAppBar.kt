package com.kuit.kuit6android.ui.orderhistory.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.kuit6android.R
import com.kuit.kuit6android.ui.theme.CoupangEatsTheme

@Composable
fun OrderHistoryTopAppBar(
    modifier: Modifier = Modifier,
    onNavigateToCartPage: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    )
    {
        Text(text = "주문내역", color = CoupangEatsTheme.colors.black, style = CoupangEatsTheme.typography.head_02_B_20)
        Icon(painter = painterResource(id = R.drawable.ic_shopping_cart), contentDescription = "cart", modifier = modifier.size(30.dp).clickable{onNavigateToCartPage()}, tint = CoupangEatsTheme.colors.black)
        
    }
}