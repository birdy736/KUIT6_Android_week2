package com.kuit.kuit6android.ui.orderhistory

data class HistoryRestaurantData(
    val date : String,
    val restaurantName : String,
    val isFavorite : Boolean,
    val orderPrice : Int,
    val salePrice : Int,
    val menu : List<MenuData>,
    val isClosed : Boolean,
    val imageId : Int
)

data class MenuData(
    val menuName : String,
    val menuCount : Int,
    val menuDetail : String
)