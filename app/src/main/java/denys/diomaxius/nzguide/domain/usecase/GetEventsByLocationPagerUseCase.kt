package denys.diomaxius.nzguide.domain.usecase

import androidx.paging.PagingData
import denys.diomaxius.nzguide.domain.model.events.Event
import denys.diomaxius.nzguide.domain.repository.EventsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEventsByLocationPagerUseCase @Inject constructor(
    private val repository: EventsRepository
) {
    operator fun invoke(
        location: Int,
        pageSize: Int = 100,
        startDate: String?,
        endDate: String?
    ): Flow<PagingData<Event>> =
        repository.getEventsByLocationPager(
        location = location,
        pageSize = pageSize,
        startDate = startDate,
        endDate = endDate
    )
}