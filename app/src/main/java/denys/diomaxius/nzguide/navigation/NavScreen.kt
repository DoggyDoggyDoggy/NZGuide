package denys.diomaxius.nzguide.navigation

sealed class NavScreen(val route: String) {
    object Home : NavScreen("home")
    object City : NavScreen("city/{cityId}") {
        fun createRoute(cityId: Int) : String = "city/$cityId"
    }
    object Event : NavScreen("event/{eventId}") {
        fun createRoute(eventId: String): String = "event/$eventId"
    }
}