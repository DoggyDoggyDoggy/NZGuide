package denys.diomaxius.nzguide.navigation

sealed class NavScreen(val route: String) {
    object Home : NavScreen("home")
    object City : NavScreen("city/{cityId}") {
        fun createRoute(cityId: Int): String = "city/$cityId"
    }

    object Event : NavScreen("event/{eventId}") {
        fun createRoute(eventId: String): String = "event/$eventId"
    }

    object CityPlaces : NavScreen("cityplaces/{cityId}") {
        fun createRoute(cityId: Int): String = "cityplaces/$cityId"
    }

    object CityHistory : NavScreen("cityhistory/{cityId}") {
        fun createRoute(cityId: Int): String = "cityhistory/$cityId"
    }
}