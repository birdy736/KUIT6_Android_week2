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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.kuit6android.R
import com.kuit.kuit6android.extension.toDateFormat
import com.kuit.kuit6android.extension.toDecimalFormat
import com.kuit.kuit6android.ui.components.CoupangEatsRoundedButton
import com.kuit.kuit6android.ui.orderhistory.HistoryRestaurantData
import com.kuit.kuit6android.ui.orderhistory.MenuData
import com.kuit.kuit6android.ui.theme.CoupangEatsTheme

@Composable
fun HistoryRestaurantItem(modifier: Modifier = Modifier,restaurantData: HistoryRestaurantData) {
    var isFavorite by rememberSaveable { mutableStateOf(restaurantData.isFavorite) }

    Column(
        modifier = Modifier
            .border(
                1.dp,
                color = CoupangEatsTheme.colors.gray300,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(all = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = restaurantData.date.toDateFormat(),
                style = CoupangEatsTheme.typography.body_01_M_14,
                color = CoupangEatsTheme.colors.gray500
            )
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = CoupangEatsTheme.colors.gray200
                ),
                modifier = Modifier.height(28.dp)
            ) {
                Text(
                    text = "주문 상세",
                    style = CoupangEatsTheme.typography.body_02_SB_12,
                    color = CoupangEatsTheme.colors.black
                )
            }
        }
        Row(
            modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(restaurantData.imageId),
                    contentDescription = "restaurant image",
                    modifier = modifier
                        .padding(end = 10.dp)
                        .size(50.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Text(
                    text = restaurantData.restaurantName,
                    style = CoupangEatsTheme.typography.head_03_B_16,
                    color = CoupangEatsTheme.colors.black,
                    modifier = modifier.padding(end = 5.dp)
                )
                Icon(
                    painter = painterResource(R.drawable.ic_right),
                    contentDescription = "arrow right",
                    tint = CoupangEatsTheme.colors.black,
                    modifier = modifier.size(14.dp)
                )
            }
            Icon(
                painter = painterResource(id = if (isFavorite) R.drawable.fill_like else R.drawable.empty_like),
                contentDescription = "heart icon",
                modifier = Modifier.size(30.dp).clickable { isFavorite = !isFavorite }.padding(0.dp),
                tint = Color.Unspecified
            )
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = modifier.padding(bottom = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = restaurantData.menu.firstOrNull()?.menuName ?: "",
                    style = CoupangEatsTheme.typography.body_01_M_14,
                    color = CoupangEatsTheme.colors.black
                )
                Text(
                    text = "${restaurantData.menu.firstOrNull()?.menuCount ?: ""}개",
                    style = CoupangEatsTheme.typography.body_01_M_14,
                    color = CoupangEatsTheme.colors.gray400
                )
            }
            Text(
                text = "⦁  ${restaurantData.menu.firstOrNull()?.menuDetail ?: ""}",
                style = CoupangEatsTheme.typography.body_02_SB_12,
                color = CoupangEatsTheme.colors.gray500,
                modifier = modifier.padding(start = 5.dp)
            )
        }

        HorizontalDivider(thickness = 1.dp, color = CoupangEatsTheme.colors.gray300)

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "결제금액",
                style = CoupangEatsTheme.typography.head_03_B_16,
                color = CoupangEatsTheme.colors.black
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = restaurantData.orderPrice.toDecimalFormat() + "원",
                    style = CoupangEatsTheme.typography.head_04_SB_14,
                    color = CoupangEatsTheme.colors.gray400,
                    textDecoration = TextDecoration.LineThrough
                )
                Text(
                    text = restaurantData.salePrice.toDecimalFormat() + "원",
                    style = CoupangEatsTheme.typography.head_03_B_16,
                    color = CoupangEatsTheme.colors.black
                )
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.End)
                .background(
                    color = CoupangEatsTheme.colors.lavender,
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(shape = RoundedCornerShape(20.dp))
                .padding(vertical = 8.dp)
                .padding(horizontal = 13.21.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(R.drawable.thunder),
                contentDescription = "thunder icon",
                tint = CoupangEatsTheme.colors.purple,
                modifier = Modifier
                    .size(10.dp)
                    .padding(start = 1.dp)
            )
            Spacer(modifier = Modifier.padding(end = 4.dp))
            Text(
                text = "${(restaurantData.orderPrice - restaurantData.salePrice).toDecimalFormat()}원 할인이 적용됐어요",
                color = CoupangEatsTheme.colors.purple,
                style = CoupangEatsTheme.typography.body_02_SB_12,
            )
        }
        if (restaurantData.isClosed) {
            Row(
                modifier = modifier.padding(top = 34.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                CoupangEatsRoundedButton(
                    Modifier,
                    "같은 메뉴 담기",
                    CoupangEatsTheme.colors.white,
                    CoupangEatsTheme.colors.gray300
                )
                CoupangEatsRoundedButton(Modifier, "바로 주문", CoupangEatsTheme.colors.mint, null)
            }
        } else {
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                shape = RoundedCornerShape(10.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = CoupangEatsTheme.colors.white
                ),
                contentPadding = PaddingValues(vertical = 12.dp),
                border = BorderStroke(1.dp, CoupangEatsTheme.colors.gray300)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                ) {
                    Text(
                        text = "같은 메뉴 담기",
                        style = CoupangEatsTheme.typography.head_02_B_20,
                        color = CoupangEatsTheme.colors.gray300
                    )
                    Text(
                        text = "오픈 전 가게예요",
                        style = CoupangEatsTheme.typography.head_05_B_10,
                        color = CoupangEatsTheme.colors.gray300
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun HistoryRestaurantItemPreview() {
    HistoryRestaurantItem(
        restaurantData = HistoryRestaurantData(
            date = "10-4-토",
            isFavorite = true,
            restaurantName = "신전떡볶이 중곡역점",
            orderPrice = 10000,
            salePrice = 2000,
            menu = listOf(
                MenuData("1인세트",1,"떡볶이 1인분, 모듬튀김, 쥬시쿨")
            ),
            isClosed = true,
            imageId = R.drawable.sinjeon
        )
    )
}