package com.kuit.kuit6android.ui.orderhistory.data

data class CartMenuData(
    val menuName : String,
    val orderPrice : Int,
    val option : List<OptionData>,
    val imageId : Int
)

annotation class OptionData(
    val option : String,
    val optionDetail : String
)
