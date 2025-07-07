package denys.diomaxius.nzguide.ui.screen.city

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import denys.diomaxius.nzguide.domain.model.city.City
import denys.diomaxius.nzguide.domain.usecase.GetCityByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CityScreenViewModel @Inject constructor(
    getCityByIdUseCase: GetCityByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val cityId: String = checkNotNull(savedStateHandle["cityId"])

    private val _city = MutableStateFlow<City>(getCityByIdUseCase(cityId.toInt()))
    val city: StateFlow<City> = _city.asStateFlow()
}