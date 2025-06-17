package denys.diomaxius.nzguide.ui.components.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denys.diomaxius.nzguide.domain.model.weather.DailyForecast
import denys.diomaxius.nzguide.domain.usecase.GetForecastUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val DEFAULT_API_KEY = "896839603a110dc1ea4f2d74b512605d"

@HiltViewModel
class WeatherForecastFiveDaysViewModel @Inject constructor(
    private val getForecastUseCase: GetForecastUseCase
) : ViewModel() {
    private val _forecast = MutableStateFlow<List<DailyForecast>>(emptyList())
    val forecast: StateFlow<List<DailyForecast>> = _forecast.asStateFlow()

    fun getForecast(
        city: String,
        apiKey: String = DEFAULT_API_KEY
    ) {
        viewModelScope.launch {
            _forecast.value = getForecastUseCase(city, apiKey)
        }
    }
}