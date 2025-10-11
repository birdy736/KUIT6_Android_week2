package com.kuit.kuit6android.ui.orderhistory.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kuit.kuit6android.R
import com.kuit.kuit6android.ui.orderhistory.component.CartBottomBar
import com.kuit.kuit6android.ui.orderhistory.component.CartTopBar
import com.kuit.kuit6android.ui.orderhistory.component.CheckPrice
import com.kuit.kuit6android.ui.orderhistory.component.GetMethod
import com.kuit.kuit6android.ui.orderhistory.component.MenuItem
import com.kuit.kuit6android.ui.orderhistory.component.RestautantBar
import com.kuit.kuit6android.ui.orderhistory.component.WithMenuItem
import com.kuit.kuit6android.ui.orderhistory.data.CartMenuData
import com.kuit.kuit6android.ui.orderhistory.data.CartWithMenuData
import com.kuit.kuit6android.ui.orderhistory.data.GetMethodHow
import com.kuit.kuit6android.ui.orderhistory.data.OptionData
import com.kuit.kuit6android.ui.theme.CoupangEatsTheme

@Composable
fun Cart(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val menuList = listOf(
        CartMenuData(
            menuName = "BBQ 소스",
            orderPrice = 500,
            option = listOf(
                OptionData(
                    option = "소스 선택",
                    optionDetail = "BBQ양념치킨소스(25g)"
                )
            ),
            imageId = R.drawable.bbq_source
        ),
        CartMenuData(
            menuName = "황금올리브치킨",
            orderPrice = 24000,
            option = listOf(
                OptionData(
                    option = "음료 추가선택",
                    optionDetail = "서비스 음료 미제공"
                )
            ),
            imageId = R.drawable.gold_olive
        ),
        CartMenuData(
            menuName = "[황.양.반] 황올 반+양념 반",
            orderPrice = 24000,
            option = listOf(
                OptionData(
                    option = "음료 추가선택",
                    optionDetail = "코카콜라"
                )
            ),
            imageId = R.drawable.half
        )
    )
    val withMenuList = listOf(
        CartWithMenuData(
            menuName = "황금올리브치킨 핫크리스피",
            price = 24500,
            imageId = R.drawable.gold_olive_hotcrispy
        ),
        CartWithMenuData(
            menuName = "제로콜라",
            price = 2000,
            imageId = R.drawable.zero_cola
        ),
        CartWithMenuData(
            menuName = "BBQ 떡볶이",
            price = 8000,
            imageId = R.drawable.bbq_tteokbbokki
        ),
        CartWithMenuData(
            menuName = "BBQ볼(5개)",
            price = 5000,
            imageId = R.drawable.bbq_ball
        )
    )

    var counts by rememberSaveable {
        mutableStateOf(List(menuList.size) { 1 })
    }

    val totalPrice by remember(counts) {
        derivedStateOf {
            menuList.indices.sumOf { i -> counts[i] * menuList[i].orderPrice }
        }
    }

    Scaffold(
        containerColor = Color.White,
        modifier = Modifier.fillMaxSize().padding(top = 30.dp),
        topBar = { CartTopBar(Modifier, navController) },
        bottomBar = { CartBottomBar(Modifier, totalPrice) }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(horizontal = 20.dp),
        ) {
            item { RestautantBar(Modifier, "BBQ 건대점", R.drawable.bbq) }

            // 메뉴
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .border(1.dp, CoupangEatsTheme.colors.gray300, RoundedCornerShape(20.dp))
                        .padding(top = 20.dp)
                ) {
                    menuList.forEachIndexed { index, menu ->
                        val key = menu.menuName

                        key(key){
                            // 내부 컴포넌트 호출 (onChange 함수 전달)
                            MenuItem(
                                menuData = menu,
                                count = counts[index],
                                // 콜백 함수 전달
                                onCountChange = { newCount ->
                                    val next = counts.toMutableList()
                                    next[index] = newCount.coerceAtLeast(0)
                                    counts = next
                                }
                            )
                        }

                        if (index != menuList.lastIndex) {
                            HorizontalDivider(
                                modifier = Modifier.padding(top = 25.dp).padding(horizontal = 20.dp),
                                thickness = 1.dp,
                                color = CoupangEatsTheme.colors.gray300
                            )
                        }
                    }
                    HorizontalDivider(
                        Modifier.padding(top = 25.dp),
                        1.dp,
                        CoupangEatsTheme.colors.gray300
                    )
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.add_button),
                            contentDescription = "add",
                            tint = CoupangEatsTheme.colors.black,
                            modifier = modifier
                                .size(20.dp)
                                .padding(end = 11.dp),

                            )
                        Text(
                            text = "메뉴 추가",
                            style = CoupangEatsTheme.typography.head_03_B_16,
                            color = CoupangEatsTheme.colors.black
                        )
                    }
                }
            }

            // 추천 메뉴
            item {
                Spacer(Modifier.padding(top = 20.dp))
                Text(
                    text = "함께 먹으면 좋아요",
                    style = CoupangEatsTheme.typography.head_03_B_16,
                    color = CoupangEatsTheme.colors.black,
                    modifier = modifier.padding(bottom = 20.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .border(1.dp, CoupangEatsTheme.colors.gray300, RoundedCornerShape(20.dp))
                ) {
                    withMenuList.forEachIndexed { index, menu ->
                        // 내부 컴포넌트 호출
                        WithMenuItem(withMenu = menu)

                        if (index != withMenuList.lastIndex) {
                            HorizontalDivider(
                                thickness = 1.dp,
                                color = CoupangEatsTheme.colors.gray300
                            )
                        }
                    }
                }
            }

            // 수령 방법 선택
            item {
                // 가게배달/픽업 선택
                var selected by rememberSaveable { mutableStateOf(GetMethodHow.DELIVERY) }
                Spacer(Modifier.padding(bottom = 20.dp))
                Text(
                    text = "수령방법을 선택해주세요",
                    style = CoupangEatsTheme.typography.head_03_B_16,
                    color = CoupangEatsTheme.colors.black,
                    modifier = modifier.padding(bottom = 10.dp)
                )

                Spacer(Modifier.padding(bottom = 10.dp))
                // 내부 컴포넌트 호출
                GetMethod(
                    Modifier,
                    isSelected = (selected == GetMethodHow.DELIVERY),
                    "가게배달", 22, 37,
                    onClick = { selected = GetMethodHow.DELIVERY })
                Spacer(Modifier.padding(bottom = 10.dp))
                GetMethod(
                    Modifier,
                    isSelected = (selected == GetMethodHow.PICKUP),
                    "픽업", 14, 24,
                    onClick = { selected = GetMethodHow.PICKUP })
            }

            // 결제금액확인
            item {
                Spacer(Modifier.padding(top = 20.dp))
                Text(
                    text = "결제금액을 확인해주세요",
                    style = CoupangEatsTheme.typography.head_03_B_16,
                    color = CoupangEatsTheme.colors.black,
                    modifier = modifier.padding(bottom = 10.dp)
                )
                CheckPrice(Modifier, totalPrice, 0)
                Spacer(Modifier.padding(bottom = 50.dp))
            }
        }
    }
}