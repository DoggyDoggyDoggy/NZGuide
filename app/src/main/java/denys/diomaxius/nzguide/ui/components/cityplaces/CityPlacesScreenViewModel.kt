package denys.diomaxius.nzguide.ui.components.cityplaces

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import denys.diomaxius.nzguide.domain.model.app.CityPlaceTopic
import denys.diomaxius.nzguide.domain.usecase.GetCityPlacesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CityPlacesScreenViewModel @Inject constructor(
    private val getCityPlacesUseCase: GetCityPlacesUseCase
) : ViewModel() {
    private val _cityPlaces = MutableStateFlow<List<CityPlaceTopic>>(emptyList())
    val cityPlaces = _cityPlaces.asStateFlow()

    fun getCityPlaces(cityPlaces: String) {
        _cityPlaces.value = getCityPlacesUseCase(cityPlaces)
    }

}