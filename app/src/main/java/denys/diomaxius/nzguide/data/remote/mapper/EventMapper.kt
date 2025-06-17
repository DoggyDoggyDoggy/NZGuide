package denys.diomaxius.nzguide.data.remote.mapper

import denys.diomaxius.nzguide.domain.model.events.Event
import denys.diomaxius.nzguide.domain.model.events.Events
import denys.diomaxius.nzguide.data.remote.dto.EventDto
import denys.diomaxius.nzguide.data.remote.dto.EventsResponseDto
import denys.diomaxius.nzguide.data.remote.dto.SessionDto
import denys.diomaxius.nzguide.data.remote.dto.SessionsWrapperDto
import denys.diomaxius.nzguide.domain.model.events.Session
import denys.diomaxius.nzguide.domain.model.events.SessionsWrapper


fun EventsResponseDto.toDomain(): Events = Events(
    count = this.attributes.count,
    events = this.events.map { it.toDomain() }
)

fun EventDto.toDomain(): Event = Event(
    id = this.id,
    url = this.url,
    name = this.name,
    description = this.description,
    datetimeStart = this.datetimeStart,
    datetimeEnd = this.datetimeEnd,
    address = this.address,
    sessions = this.sessions.toDomain(),
    images = this.images.toDomain()
)

fun SessionsWrapperDto.toDomain() : SessionsWrapper = SessionsWrapper(
    sessions = this.sessions.map { it.toDomain() }
)

fun SessionDto.toDomain() : Session = Session(
    datetimeSummary = this.datetimeSummary
)