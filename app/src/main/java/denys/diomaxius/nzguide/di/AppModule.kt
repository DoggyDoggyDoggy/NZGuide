package denys.diomaxius.nzguide.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import denys.diomaxius.nzguide.data.local.datasource.CityAssetsSource
import denys.diomaxius.nzguide.data.local.mapper.toDomain
import denys.diomaxius.nzguide.data.remote.api.EventsFindApi
import denys.diomaxius.nzguide.data.remote.api.WeatherApi
import denys.diomaxius.nzguide.data.remote.network.RetrofitClient
import denys.diomaxius.nzguide.data.repository.CityRepositoryImpl
import denys.diomaxius.nzguide.data.repository.EventsRepositoryImpl
import denys.diomaxius.nzguide.data.repository.WeatherRepositoryImpl
import denys.diomaxius.nzguide.domain.model.app.City
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
    fun provideAssetsSource(@ApplicationContext ctx: Context) =
        CityAssetsSource(ctx)

    @Provides
    @Singleton
    fun provideAllCities(
        cityAssetsSource: CityAssetsSource
    ): List<City> {
        return cityAssetsSource.loadCitiesJson("cities.json").toDomain()
    }

    @Provides
    @Singleton
    fun provideCityRepository(
        allCities: List<City>,
        cityAssetsSource: CityAssetsSource
    ): CityRepository = CityRepositoryImpl(allCities, cityAssetsSource)
}