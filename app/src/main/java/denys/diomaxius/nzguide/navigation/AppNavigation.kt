package denys.diomaxius.nzguide.navigation

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
import denys.diomaxius.nzguide.ui.screen.home.HomeScreen
import denys.diomaxius.nzguide.ui.components.cityplaces.CityPlacesScreen

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

            composable(NavScreen.City.route) {
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
        }
    }
}