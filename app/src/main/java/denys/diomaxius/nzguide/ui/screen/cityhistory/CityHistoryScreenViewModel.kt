package denys.diomaxius.nzguide.ui.screen.cityhistory

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import denys.diomaxius.nzguide.domain.model.city.CityHistory
import denys.diomaxius.nzguide.domain.usecase.GetCityByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CityHistoryScreenViewModel @Inject constructor(
    getCityByIdUseCase: GetCityByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val cityId: String = checkNotNull(savedStateHandle["cityId"])

    private val _cityHistory = MutableStateFlow<CityHistory>(CityHistory(emptyList()))
    val cityHistory = _cityHistory.asStateFlow()

    private val _cityName = MutableStateFlow("")
    val cityName = _cityName.asStateFlow()

    init {
        val city = getCityByIdUseCase(cityId.toInt())
        _cityName.value = city.name
        _cityHistory.value = city.history
    }
}