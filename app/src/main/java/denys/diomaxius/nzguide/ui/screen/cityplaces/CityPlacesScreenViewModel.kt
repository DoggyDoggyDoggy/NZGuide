package denys.diomaxius.nzguide.ui.screen.cityplaces

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import denys.diomaxius.nzguide.domain.model.city.CityPlaceTopic
import denys.diomaxius.nzguide.domain.usecase.GetCityByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CityPlacesScreenViewModel @Inject constructor(
    getCityByIdUseCase: GetCityByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val cityId: String = checkNotNull(savedStateHandle["cityId"])

    private val _cityPlaces = MutableStateFlow<List<CityPlaceTopic>>(emptyList())
    val cityPlaces = _cityPlaces.asStateFlow()

    private val _cityName = MutableStateFlow("")
    val cityName = _cityName.asStateFlow()

    init {
        val city = getCityByIdUseCase(cityId.toInt())
        _cityName.value = city.name
        _cityPlaces.value = city.places
    }
}