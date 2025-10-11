package com.kuit.kuit6android.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data object Search : Route

    @Serializable
    data class SearchResult(
        val searchKeyword: String,
    ) : Route

    @Serializable
    data object SearchNestedGraphRoute : Route

    @Serializable
    data object Favorite : Route

    @Serializable
    data class DetailInfo(
        val imageId: Int,
        val name: String,
        val time: Int,
        val rating: Double,
        val reviewCount: String
    ) : Route

    @Serializable
    data object OrderHistory : Route

    @Serializable
    data object Cart: Route

    @Serializable
    data object MyEats : Route

    @Serializable
    data object MyEatsFavorite : Route

    @Serializable
    data object MyEatsNestedGraphRoute : Route
}

