package denys.diomaxius.nzguide.domain.usecase

import denys.diomaxius.nzguide.domain.repository.EventsRepository
import javax.inject.Inject

class GetEventUseCase @Inject constructor(
    private val repository: EventsRepository
) {
    suspend operator fun invoke(id: String) = repository.getEvent(id)
}