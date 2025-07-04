package denys.diomaxius.nzguide.ui.screen.cityhistory

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import denys.diomaxius.nzguide.domain.usecase.GetCityPlacesUseCase
import javax.inject.Inject

class CityHistoryScreenViewModel @Inject constructor(
    private val getCityPlacesUseCase: GetCityPlacesUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val cityHistoryJsonPath: String = checkNotNull(savedStateHandle["cityHistoryJsonPath"])


}