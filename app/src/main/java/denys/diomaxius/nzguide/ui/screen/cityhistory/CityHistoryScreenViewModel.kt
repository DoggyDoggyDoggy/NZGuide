package denys.diomaxius.nzguide.ui.screen.cityhistory

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import denys.diomaxius.nzguide.domain.model.app.CityHistory
import denys.diomaxius.nzguide.domain.usecase.GetCityHistoryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CityHistoryScreenViewModel @Inject constructor(
    private val getCityHistoryUseCase: GetCityHistoryUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val cityHistoryJsonPath: String = checkNotNull(savedStateHandle["cityHistoryJsonPath"])


    private val _cityHistory = MutableStateFlow<CityHistory>(CityHistory(emptyList()))
    val cityHistory = _cityHistory.asStateFlow()

    fun getCityHistory(cityHistory: String = cityHistoryJsonPath) {
        Log.i("CityHistoryScreenViewModel", cityHistoryJsonPath)
        _cityHistory.value = getCityHistoryUseCase(cityHistory)
    }
}