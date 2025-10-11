package com.kuit.kuit6android.ui.orderhistory.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kuit.kuit6android.R
import com.kuit.kuit6android.ui.theme.CoupangEatsTheme

@Composable
fun CartTopBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_back_arrow),
            contentDescription = "back arrow",
            tint = Color(0xFF666668),
            modifier = modifier.size(24.dp)
                .clickable { navController.popBackStack() }
        )
        Text(
            text = "장바구니",
            style = CoupangEatsTheme.typography.head_02_B_20,
            color = CoupangEatsTheme.colors.black
        )
        Icon(
            painter = painterResource(R.drawable.person_add),
            contentDescription = "person add",
            tint = CoupangEatsTheme.colors.black,
            modifier = modifier.size(24.dp)
        )
    }
}