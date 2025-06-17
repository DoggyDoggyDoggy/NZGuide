package denys.diomaxius.nzguide.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import denys.diomaxius.nzguide.data.remote.api.WeatherApi
import denys.diomaxius.nzguide.data.remote.network.RetrofitClient
import denys.diomaxius.nzguide.data.repository.WeatherRepositoryImpl
import denys.diomaxius.nzguide.domain.repository.WeatherRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideEventFindApi(): WeatherApi = RetrofitClient.weatherApi

    @Provides
    @Singleton
    fun provideWeatherRepository(apiService: WeatherApi): WeatherRepository =
        WeatherRepositoryImpl(apiService)
}