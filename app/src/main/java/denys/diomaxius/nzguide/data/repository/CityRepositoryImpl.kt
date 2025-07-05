package denys.diomaxius.nzguide.data.repository

import denys.diomaxius.nzguide.data.local.datasource.CityAssetsSource
import denys.diomaxius.nzguide.data.local.mapper.toDomain
import denys.diomaxius.nzguide.domain.model.app.City
import denys.diomaxius.nzguide.domain.model.app.CityHistory
import denys.diomaxius.nzguide.domain.model.app.CityPlaceTopic
import denys.diomaxius.nzguide.domain.repository.CityRepository
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val cityAssetsSource: CityAssetsSource
) : CityRepository {
    private val allCities = listOf(
        City(42,  "Hamilton", listOf("hamilton/1.jpg", "hamilton/2.jpg", "hamilton/3.jpg"), "hamilton/hamilton.json", "hamilton/cityhistory.json"),
        City(363, "Wellington", listOf("wellington/1.jpg", "wellington/2.jpg", "wellington/3.jpg"), "wellington/wellington.json", "wellington/cityhistory.json"),
        City(110, "Christchurch", listOf("christchurch/1.jpg", "christchurch/2.jpg", "christchurch/3.jpg"), "christchurch/christchurch.json", "christchurch/cityhistory.json"),
        City(126, "Dunedin", listOf("dunedin/1.jpg", "dunedin/2.jpg", "dunedin/3.jpg"), "dunedin/dunedin.json", "dunedin/cityhistory.json"),
        City(137, "Invercargill", listOf("invercargill/1.jpg", "invercargill/2.jpg", "invercargill/3.jpg"), "invercargill/invercargill.json", "invercargill/cityhistory.json"),
        City(130, "Queenstown", listOf("queenstown/1.jpg", "queenstown/2.jpg", "queenstown/3.jpg"), "queenstown/queenstown.json", "queenstown/cityhistory.json"),
        City(2, "Auckland", listOf("auckland/1.jpg", "auckland/2.jpg", "auckland/3.jpg"), "auckland/auckland.json", "auckland/cityhistory.json"),
        City(57, "Rotorua", listOf("rotorua/1.jpg", "rotorua/2.jpg", "rotorua/3.jpg"), "rotorua/rotorua.json", "rotorua/cityhistory.json"),
        City(7051, "Whangarei", listOf("whangarei/1.jpg", "whangarei/2.jpg", "whangarei/3.jpg"), "whangarei/whangarei.json", "whangarei/cityhistory.json"),
        City(6, "Gisborne", listOf("gisborne/1.jpg", "gisborne/2.jpg", "gisborne/3.jpg"), "gisborne/gisborne.json", "gisborne/cityhistory.json"),
        City(83, "Palmerston North", listOf("palmerstonnorth/1.jpg", "palmerstonnorth/2.jpg", "palmerstonnorth/3.jpg"), "palmerstonnorth/palmerstonnorth.json", "palmerstonnorth/cityhistory.json"),
        City(67, "Napier", listOf("napier/1.jpg", "napier/2.jpg", "napier/3.jpg"), "napier/napier.json", "napier/cityhistory.json"),
        City(58, "Taupo", listOf("taupo/1.jpg", "taupo/2.jpg", "taupo/3.jpg"), "taupo/taupo.json", "taupo/cityhistory.json"),
        City(59, "Tauranga", listOf("tauranga/1.jpg", "tauranga/2.jpg", "tauranga/3.jpg"), "tauranga/tauranga.json", "tauranga/cityhistory.json"),
        City(72, "New Plymouth", listOf("newplymouth/1.jpg", "newplymouth/2.jpg", "newplymouth/3.jpg"), "newplymouth/newplymouth.json", "newplymouth/cityhistory.json")
    )

    override fun getAllCities(): List<City> = allCities

    override fun getCityById(id: Int): City = allCities.find { it.id == id }!!

    override fun getCityPlaces(cityPlaces: String): List<CityPlaceTopic> {
        return cityAssetsSource.loadCityPlacesJson(cityPlaces).toDomain()
    }

    override fun getCityHistory(cityHistory: String): CityHistory {
        return cityAssetsSource.loadCityHistoryJson(cityHistory).toDomain()
    }
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