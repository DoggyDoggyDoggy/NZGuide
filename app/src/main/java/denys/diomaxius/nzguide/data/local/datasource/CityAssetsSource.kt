package denys.diomaxius.nzguide.data.local.datasource

import android.content.Context
import denys.diomaxius.nzguide.data.local.dto.CityPlacesDto
import kotlinx.serialization.json.Json

class CityAssetsSource(private val context: Context) {
    fun loadCityPlacesJson(fileName: String): CityPlacesDto {
        val json = context.assets.open(fileName)
            .bufferedReader()
            .use { it.readText() }

        return Json { ignoreUnknownKeys = true }
            .decodeFromString(json)
    }
}