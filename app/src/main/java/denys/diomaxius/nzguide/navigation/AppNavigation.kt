package denys.diomaxius.nzguide.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import denys.diomaxius.nzguide.ui.screen.event.EventDetailsScreen
import denys.diomaxius.nzguide.ui.screen.city.CityScreen
import denys.diomaxius.nzguide.ui.screen.cityhistory.CityHistoryScreen
import denys.diomaxius.nzguide.ui.screen.home.HomeScreen
import denys.diomaxius.nzguide.ui.screen.cityplaces.CityPlacesScreen

val LocalNavController = compositionLocalOf<NavHostController> {
    error("NavController not initialized")
}

@Composable
fun AppNavigation(
    navHostController: NavHostController = rememberNavController()
) {
    CompositionLocalProvider(LocalNavController provides navHostController) {
        NavHost(
            navController = navHostController,
            startDestination = NavScreen.Home.route
        ) {
            composable(NavScreen.Home.route) {
                HomeScreen()
            }

            composable(
                route = NavScreen.City.route,
                enterTransition = {
                    slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(500)) + fadeIn()
                },
                exitTransition = {
                    slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(500)) + fadeOut()
                },
                popEnterTransition = {
                    slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(500)) + fadeIn()
                },
                popExitTransition = {
                    slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(500)) + fadeOut()
                }
            ) {
                CityScreen()
            }

            composable(NavScreen.Event.route) {
                EventDetailsScreen()
            }

            composable(
                route = NavScreen.CityPlaces.route,
                arguments = listOf(
                    navArgument("cityPlacesJsonPath") {
                        type = NavType.StringType
                    },
                    navArgument("cityName") {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val cityName = backStackEntry.arguments
                    ?.getString("cityName")
                    .orEmpty()
                CityPlacesScreen(cityName = cityName)
            }

            composable(NavScreen.CityHistory.route) {
                CityHistoryScreen()
            }
        }
    }
}