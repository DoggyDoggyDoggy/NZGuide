package denys.diomaxius.nzguide.data.local.mapper

import denys.diomaxius.nzguide.data.local.dto.CityHistoryDto
import denys.diomaxius.nzguide.domain.model.city.CityHistory

fun CityHistoryDto.toDomain(): CityHistory = CityHistory(paragraphs = this.paragraphs)