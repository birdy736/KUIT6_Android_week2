package com.kuit.kuit6android.ui.orderhistory.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.kuit6android.R
import com.kuit.kuit6android.ui.orderhistory.HistoryRestaurantData
import com.kuit.kuit6android.ui.orderhistory.MenuData
import com.kuit.kuit6android.ui.orderhistory.component.FreeDeliveryItem
import com.kuit.kuit6android.ui.orderhistory.component.HistoryRestaurantItem
import com.kuit.kuit6android.ui.orderhistory.component.OrderHistoryDropdownItem
import com.kuit.kuit6android.ui.orderhistory.component.OrderHistoryTextField
import com.kuit.kuit6android.ui.orderhistory.component.OrderHistoryTopAppBar

@Composable
fun OrderHistoryScreen(
    padding: PaddingValues,
    modifier: Modifier = Modifier,
    onNavigateToCart: () -> Unit = {}
) {
    val restaurantList = listOf(
            HistoryRestaurantData(
                date = "10-4-토",
                isFavorite = true,
                restaurantName = "신전떡볶이 중곡역점",
                orderPrice = 10000,
                salePrice = 2000,
                menu = listOf(
                    MenuData("1인세트", 1, "떡볶이 1인분, 모듬튀김, 쥬시쿨")
                ),
                isClosed = true,
                imageId = R.drawable.sinjeon
            ),
            HistoryRestaurantData(
                date = "10-3-금",
                restaurantName = "처갓집양념치킨 중곡역점",
                isFavorite = true,
                orderPrice = 24000,
                salePrice = 20000,
                menu = listOf(
                    MenuData("슈프림양념치킨", 1, "뼈, 토핑떡사리")
                ),
                isClosed = true,
                imageId = R.drawable.cheogga
            ),
            HistoryRestaurantData(
                date = "9-27-토",
                restaurantName = "동대문엽기떡볶이 건대점",
                isFavorite = true,
                orderPrice = 20700,
                salePrice = 18500,
                menu = listOf(
                    MenuData("실속세트", 1, "반반, [엽기] 덜매운맛")
                ),
                isClosed = true,
                imageId = R.drawable.ddongdaemoon
            ),
            HistoryRestaurantData(
                date = "9-22-수",
                restaurantName = "피자나라치킨공주 건대점",
                isFavorite = true,
                orderPrice = 30300,
                salePrice = 28300,
                menu = listOf(
                    MenuData("갈릭스테이크피치세트", 1, "스테이크피자, 순살 쉬림프 치킨")
                ),
                isClosed = true,
                imageId = R.drawable.pizzachicken
            ),
        )
    Column(
        modifier = Modifier.padding(
            padding
        )
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
    ) {
        OrderHistoryTopAppBar(Modifier,onNavigateToCart)
        Spacer(modifier = Modifier.height(25.dp))
        OrderHistoryTextField()
        Row(
            modifier = Modifier.padding(top = 12.dp, bottom = 7.dp)
                .fillMaxWidth()
        ) {
            OrderHistoryDropdownItem(category = "주소")
            Spacer(modifier = Modifier.padding(start = 8.dp))
            OrderHistoryDropdownItem(category = "조회기간")
            Spacer(modifier = Modifier.padding(start = 8.dp))
            OrderHistoryDropdownItem(category = "주문상태/정보")
        }
        HorizontalDivider(
            thickness = 1.dp
        )
        Spacer(modifier = modifier.padding(top = 7.dp))
        FreeDeliveryItem()
        Spacer(modifier = Modifier.height(15.dp))
        LazyColumn(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            items(restaurantList) {
                item->HistoryRestaurantItem(restaurantData = item)
                Spacer(modifier = Modifier.padding(top = 20.dp))
            }
        }
    }
}

@Preview
@Composable
private fun OrderHistoryPreview() {
    OrderHistoryScreen(padding = PaddingValues())
}