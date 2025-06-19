package denys.diomaxius.nzguide.data.repository

import denys.diomaxius.nzguide.domain.model.app.City
import denys.diomaxius.nzguide.domain.repository.CityRepository

class CityRepositoryImpl : CityRepository {
    private val allCities = listOf(
        City(42,  "Hamilton", listOf("hamilton/1.jpg", "hamilton/2.jpg", "hamilton/3.jpg")),
        City(363, "Wellington", listOf("wellington/1.jpg", "wellington/2.jpg", "wellington/3.jpg")),
        City(110, "Christchurch", listOf("christchurch/1.jpg", "christchurch/2.jpg", "christchurch/3.jpg")),
        City(126, "Dunedin", listOf("dunedin/1.jpg", "dunedin/2.jpg", "dunedin/3.jpg")),
        City(137, "Invercargill", listOf("invercargill/1.jpg", "invercargill/2.jpg", "invercargill/3.jpg")),
        City(130, "Queenstown", listOf("queenstown/1.jpg", "queenstown/2.jpg", "queenstown/3.jpg")),
        City(2, "Auckland", listOf("auckland/1.jpg", "auckland/2.jpg", "auckland/3.jpg")),
        City(57, "Rotorua", listOf("rotorua/1.jpg", "rotorua/2.jpg", "rotorua/3.jpg")),
        City(7051, "Whangarei", listOf("whangarei/1.jpg", "whangarei/2.jpg", "whangarei/3.jpg")),
        City(6, "Gisborne", listOf("gisborne/1.jpg", "gisborne/2.jpg", "gisborne/3.jpg")),
        City(83, "Palmerston North", listOf("palmerstonnorth/1.jpg", "palmerstonnorth/2.jpg", "palmerstonnorth/3.jpg")),
        City(67, "Napier", listOf("napier/1.jpg", "napier/2.jpg", "napier/3.jpg")),
        City(58, "Taupo", listOf("taupo/1.jpg", "taupo/2.jpg", "taupo/3.jpg")),
        City(59, "Tauranga", listOf("tauranga/1.jpg", "tauranga/2.jpg", "tauranga/3.jpg")),
        City(72, "New Plymouth", listOf("newplymouth/1.jpg", "newplymouth/2.jpg", "newplymouth/3.jpg"))
    )

    override fun getAllCities(): List<City> = allCities

    override fun getCityById(id: Int): City = allCities.find { it.id == id }!!
}

/*
WAIKATO 3
FAR NORTH 22
Bay of Plenty 4
Manawatu 9
Taranaki 7
Wellington Region 11
North Shore 34
Wānaka 133
NELSON 12
West Coast 14
Marlborough 13
Canterbury 15
OTAGO 17
Southland 18
*/