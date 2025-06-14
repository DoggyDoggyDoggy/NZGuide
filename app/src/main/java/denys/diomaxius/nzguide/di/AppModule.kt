package denys.diomaxius.nzguide.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import denys.diomaxius.nzguide.data.remote.api.WeatherApi
import denys.diomaxius.nzguide.data.remote.network.RetrofitClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideEventFindApi(): WeatherApi = RetrofitClient.api
}