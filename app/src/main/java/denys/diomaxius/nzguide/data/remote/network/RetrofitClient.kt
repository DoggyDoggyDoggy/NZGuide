package denys.diomaxius.nzguide.data.remote.network

import denys.diomaxius.nzguide.data.remote.api.EventsFindApi
import denys.diomaxius.nzguide.data.remote.api.WeatherApi
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val WEATHER_BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private const val EVENTS_BASE_URL = "https://api.eventfinda.co.nz/v2/"
    private const val USERNAME = "nzevents4"
    private const val PASSWORD = "s9rh8jmx73gp"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", Credentials.basic(
                    USERNAME,
                    PASSWORD
                ))
                .build()
            chain.proceed(request)
        }
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    val eventsApi: EventsFindApi by lazy {
        Retrofit.Builder()
            .baseUrl(EVENTS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(EventsFindApi::class.java)
    }

    val weatherApi: WeatherApi by lazy {
        Retrofit.Builder()
            .baseUrl(WEATHER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }
}