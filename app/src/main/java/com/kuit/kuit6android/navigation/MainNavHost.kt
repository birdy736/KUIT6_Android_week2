package com.kuit.kuit6android.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.kuit.kuit6android.ui.favorite.screen.DetailInfo
import com.kuit.kuit6android.ui.favorite.screen.FavoriteScreen
import com.kuit.kuit6android.ui.favorite.screen.MyEatFavorite
import com.kuit.kuit6android.ui.home.data.RestaurantData
import com.kuit.kuit6android.ui.home.screen.HomeScreen
import com.kuit.kuit6android.ui.myeats.screen.MyEatsScreen
import com.kuit.kuit6android.ui.orderhistory.HistoryRestaurantData
import com.kuit.kuit6android.ui.orderhistory.MenuData
import com.kuit.kuit6android.ui.orderhistory.screen.Cart
import com.kuit.kuit6android.ui.orderhistory.screen.OrderHistoryScreen
import com.kuit.kuit6android.ui.search.screen.SearchResultScreen
import com.kuit.kuit6android.ui.search.screen.SearchScreen

@Composable
fun MainNavHost(
    padding: PaddingValues,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Route.Home,
    ) {
        composable<Route.Home> {
            HomeScreen(
                padding = padding,
            )
        }

        navigation<Route.SearchNestedGraphRoute>(
            startDestination = Route.Search
        ){
            composable<Route.Search> {
                SearchScreen(
                    padding = padding,
                    {
                        navController.navigate(Route.SearchResult(searchKeyword = it))
                    }
                )
            }

            composable<Route.SearchResult> { navBackStackEntry ->
                val keyword = navBackStackEntry.toRoute<Route.SearchResult>().searchKeyword
                SearchResultScreen(
                    padding = padding,
                    searchKeyword = keyword
                )
            }
        }

        composable<Route.Favorite> {
            FavoriteScreen(
                padding = padding,
                onNavigateToRestaurantDetail = { restaurant ->
                    navController.navigate(
                        Route.DetailInfo(
                            imageId = restaurant.imageId,
                            name = restaurant.name,
                            time = restaurant.time,
                            rating = restaurant.rating,
                            reviewCount = restaurant.reviewCount
                        )
                    )
                }
            )
        }

        composable<Route.DetailInfo> { backStackEntry ->
            val args = backStackEntry.toRoute<Route.DetailInfo>() // 넘겨 받은 인자 args에 저장
            val restaurant = RestaurantData(
                imageId = args.imageId,
                name = args.name,
                time = args.time,
                rating = args.rating,
                reviewCount = args.reviewCount
            )
            DetailInfo(restaurantInfo = restaurant, navController = navController)
        }

        composable<Route.OrderHistory> {
            OrderHistoryScreen(
                padding = padding,
                onNavigateToCart = {
                    navController.navigate(Route.Cart)
                }
            )
        }

        composable<Route.Cart> {
            Cart(navController = navController)
        }

        navigation<Route.MyEatsNestedGraphRoute>(
            startDestination = Route.MyEats
        ) {
            composable<Route.MyEats> {
                MyEatsScreen(
                    padding = padding,
                    onNavigateToFavorite = {
                        navController.navigate(Route.MyEatsFavorite)
                    }
                )
            }

            composable<Route.MyEatsFavorite> {
                MyEatFavorite(
                    padding = padding,
                    onNavigateToDetailPage = { restaurant ->
                        navController.navigate(
                            Route.DetailInfo(
                                imageId = restaurant.imageId,
                                name = restaurant.name,
                                time = restaurant.time,
                                rating = restaurant.rating,
                                reviewCount = restaurant.reviewCount
                            )
                        )
                    },
                    navController = navController
                )
            }
        }
    }
}