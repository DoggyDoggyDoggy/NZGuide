package denys.diomaxius.nzevents.ui.screen.event

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denys.diomaxius.nzguide.domain.model.events.Event
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

    private val _event = MutableStateFlow<Event>(Event.empty())
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