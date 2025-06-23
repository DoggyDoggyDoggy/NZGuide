package denys.diomaxius.nzguide.data.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import denys.diomaxius.nzguide.data.remote.mapper.toDomain
import denys.diomaxius.nzguide.data.remote.api.EventsFindApi
import denys.diomaxius.nzguide.data.remote.paging.EventsPagingSource
import denys.diomaxius.nzguide.domain.model.events.Event
import denys.diomaxius.nzguide.domain.repository.EventsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.collections.first

class EventsRepositoryImpl @Inject constructor(
    private val api: EventsFindApi
) : EventsRepository {

    override suspend fun getEvent(id: String): Event {
        val response = api.getEvent(id)
        try {
            return response.events.first().toDomain()
        } catch(e: Exception) {
            Log.i("EventsRepositoryImpl", "getEvent: $e")
            return Event.empty(id = "API Error")
        }

    }

    override fun getEventsPager(
        pageSize: Int,
        startDate: String?,
        endDate: String?
    ): Flow<PagingData<Event>> {
        return Pager(
            config = PagingConfig(
                pageSize = pageSize,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                EventsPagingSource(
                    api = api,
                    locationId = null,
                    pageSize = pageSize,
                    startDate = startDate,
                    endDate = endDate
                )
            }
        ).flow
    }

    override fun getEventsByLocationPager(
        location: Int,
        pageSize: Int,
        startDate: String?,
        endDate: String?
    ): Flow<PagingData<Event>> {
        return Pager(
            config = PagingConfig(
                pageSize = pageSize,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                EventsPagingSource(
                    api = api,
                    locationId = location,
                    pageSize = pageSize,
                    startDate = startDate,
                    endDate = endDate
                )
            }
        ).flow
    }
}