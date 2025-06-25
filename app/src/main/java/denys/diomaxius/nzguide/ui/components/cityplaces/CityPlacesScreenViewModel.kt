package denys.diomaxius.nzguide.ui.components.cityplaces

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import denys.diomaxius.nzguide.domain.model.app.CityPlaceTopic
import denys.diomaxius.nzguide.domain.usecase.GetCityPlacesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CityPlacesScreenViewModel @Inject constructor(
    private val getCityPlacesUseCase: GetCityPlacesUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val cityPlacesJsonPath: String = checkNotNull(savedStateHandle["cityPlacesJsonPath"])

    private val _cityPlaces = MutableStateFlow<List<CityPlaceTopic>>(emptyList())
    val cityPlaces = _cityPlaces.asStateFlow()

    fun getCityPlaces(cityPlaces: String = cityPlacesJsonPath) {
        _cityPlaces.value = getCityPlacesUseCase(cityPlaces)
    }

}