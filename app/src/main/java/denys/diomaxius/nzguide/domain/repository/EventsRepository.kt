package denys.diomaxius.nzguide.domain.repository

import androidx.paging.PagingData
import denys.diomaxius.nzguide.domain.model.events.Event
import kotlinx.coroutines.flow.Flow

interface EventsRepository {
    suspend fun getEvent(id: String): Event

    fun getEventsPager(
        pageSize: Int = 10,
        startDate: String?,
        endDate: String?
    ): Flow<PagingData<Event>>

    fun getEventsByLocationPager(
        location: Int,
        pageSize: Int = 10,
        startDate: String?,
        endDate: String?
    ): Flow<PagingData<Event>>
}