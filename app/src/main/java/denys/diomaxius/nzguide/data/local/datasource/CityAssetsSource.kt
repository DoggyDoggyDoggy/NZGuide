package denys.diomaxius.nzguide.data.local.datasource

import android.content.Context
import denys.diomaxius.nzguide.data.local.dto.CitiesDto
import denys.diomaxius.nzguide.data.local.dto.CityHistoryDto
import denys.diomaxius.nzguide.data.local.dto.CityPlacesDto
import kotlinx.serialization.json.Json

class CityAssetsSource(private val context: Context) {
    private val jsonParser: Json = Json {
        ignoreUnknownKeys = true
    }

    fun loadCityPlacesJson(fileName: String): CityPlacesDto {
        val json = context.assets.open(fileName)
            .bufferedReader()
            .use { it.readText() }

        return jsonParser.decodeFromString(json)
    }

    fun loadCityHistoryJson(fileName: String): CityHistoryDto {
        val json = context.assets.open(fileName)
            .bufferedReader()
            .use { it.readText() }

        return jsonParser.decodeFromString(json)
    }

    fun loadCitiesJson(fileName: String): CitiesDto {
        val json = context.assets.open(fileName)
            .bufferedReader()
            .use { it.readText() }

        return jsonParser.decodeFromString(json)
    }
}