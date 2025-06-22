package denys.diomaxius.nzevents.ui.screen.event

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denys.diomaxius.nzguide.domain.model.events.Event
import denys.diomaxius.nzguide.domain.model.events.Image
import denys.diomaxius.nzguide.domain.model.events.ImageTransform
import denys.diomaxius.nzguide.domain.model.events.ImageWrapper
import denys.diomaxius.nzguide.domain.model.events.SessionsWrapper
import denys.diomaxius.nzguide.domain.model.events.TransformWrapper
import denys.diomaxius.nzguide.domain.usecase.GetEventUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventDetailsScreenViewModel @Inject constructor(
    private val getEventUseCase: GetEventUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val eventId: String = checkNotNull(savedStateHandle["eventId"])

    private val _event = MutableStateFlow<Event>(
        Event(
            id = "",
            url = "",
            name = "",
            description = "",
            datetimeStart = "",
            datetimeEnd = "",
            address = "",
            sessions = SessionsWrapper(
                sessions = listOf()
            ),
            images = ImageWrapper(
                images = listOf(Image(
                    id = 0,
                    isPrimary = false,
                    originalUrl = "",
                    transforms = TransformWrapper(
                        transforms = listOf(ImageTransform(
                            transformationId = 0,
                            url = "",
                            width = 0,
                            height = 0
                        ))
                    )
                ))
            )
        )
    )
    val event:StateFlow<Event> = _event.asStateFlow()

    init {
        getEvent(eventId)
    }

    fun getEvent(id: String) {
        viewModelScope.launch {
            _event.value = getEventUseCase(id)
        }
    }
}