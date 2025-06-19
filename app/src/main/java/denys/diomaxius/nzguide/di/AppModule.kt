package denys.diomaxius.nzguide.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import denys.diomaxius.nzguide.data.remote.api.EventsFindApi
import denys.diomaxius.nzguide.data.remote.api.WeatherApi
import denys.diomaxius.nzguide.data.remote.network.RetrofitClient
import denys.diomaxius.nzguide.data.repository.CityRepositoryImpl
import denys.diomaxius.nzguide.data.repository.EventsRepositoryImpl
import denys.diomaxius.nzguide.data.repository.WeatherRepositoryImpl
import denys.diomaxius.nzguide.domain.repository.CityRepository
import denys.diomaxius.nzguide.domain.repository.EventsRepository
import denys.diomaxius.nzguide.domain.repository.WeatherRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi = RetrofitClient.weatherApi

    @Provides
    @Singleton
    fun provideEventFindApi(): EventsFindApi = RetrofitClient.eventsApi

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherApi: WeatherApi): WeatherRepository =
        WeatherRepositoryImpl(weatherApi)

    @Provides
    @Singleton
    fun provideEventsRepository(eventsApi: EventsFindApi): EventsRepository =
        EventsRepositoryImpl(eventsApi)

    @Provides
    @Singleton
    fun provideCityRepository(): CityRepository = CityRepositoryImpl()
}