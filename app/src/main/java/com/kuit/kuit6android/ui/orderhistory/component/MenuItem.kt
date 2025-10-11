package com.kuit.kuit6android.ui.orderhistory.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.kuit.kuit6android.ui.orderhistory.data.CartMenuData
import com.kuit.kuit6android.ui.theme.CoupangEatsTheme

@Composable
fun MenuItem(
    menuData: CartMenuData,
    count: Int,
    onCountChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth(),
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                modifier = modifier
                    .padding(top = 20.dp)
                    .weight(1f)
            ) {
                Text(
                    text = menuData.menuName,
                    style = CoupangEatsTheme.typography.head_03_B_16,
                    color = CoupangEatsTheme.colors.black
                )
                Text(
                    text = "가격 : " + menuData.orderPrice.toDecimalFormat() + "원",
                    style = CoupangEatsTheme.typography.body_02_SB_12,
                    color = CoupangEatsTheme.colors.gray500
                )
                Text(
                    text = menuData.option.firstOrNull()?.option + " : " + menuData.option.firstOrNull()?.optionDetail,
                    style = CoupangEatsTheme.typography.body_02_SB_12,
                    color = CoupangEatsTheme.colors.gray500
                )
            }

            Column(
                modifier = modifier
            ) {
                Image(
                    modifier = modifier
                        .align(Alignment.End)
                        .size(50.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .border(1.dp, CoupangEatsTheme.colors.gray200, RoundedCornerShape(10.dp)),
                    painter = painterResource(menuData.imageId),
                    contentDescription = "menu image"
                )
            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(31.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Spacer(Modifier.weight(1f))
            Button(
                modifier = modifier,
                shape = RoundedCornerShape(10.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = CoupangEatsTheme.colors.white),
                border = BorderStroke(1.dp, CoupangEatsTheme.colors.gray300) ,
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 10.dp),
            ) {
                Text(
                    text = "옵션 변경",
                    style = CoupangEatsTheme.typography.body_02_R_12,
                    color = CoupangEatsTheme.colors.black
                )
            }
            Row(
                modifier = modifier
                    .width(89.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(CoupangEatsTheme.colors.white)
                    .border(1.dp, CoupangEatsTheme.colors.gray300, RoundedCornerShape(10.dp))
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Icon(
                    painter = painterResource(R.drawable.trash),
                    contentDescription = "delete",
                    modifier = modifier.size(10.dp),
                    tint = CoupangEatsTheme.colors.black
                )
                Text(
                    text = count.toString(),
                    style = CoupangEatsTheme.typography.caption_01_R_10,
                    color = CoupangEatsTheme.colors.black
                )

                // State Less: 콜백 함수
                Icon(
                    painter = painterResource(R.drawable.add_button),
                    contentDescription = "add",
                    modifier = modifier
                        .size(10.dp)
                        .clickable { onCountChange(count + 1) },
                    tint = CoupangEatsTheme.colors.black
                )
            }
        }
    }
}