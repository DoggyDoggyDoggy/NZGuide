# NZGuide

A simple Android guide app showcasing cities in New Zealand, built with Jetpack Compose following Clean Architecture and MVVM principles. 

## ✨ Key Features

- **City List**: Display a scrollable list of cities with a large background image and name.
- **City Detail Screen**:
  - **Image Slideshow**: Static images showcasing highlights of the city.
  - **5-Day Weather Forecast**: Data fetched via Retrofit from OpenWeather API.
  - **Events Feed**: Live event listings using the EventFinda API.
  - **Top Things to Do**: Offline attractions stored in local assets (parks, museums, etc.).
- **Event Detail Screen**: Detailed view with description, schedule, location, and a “Buy Tickets” button linking to the event provider’s website.
- **Offline Mode**: When offline, weather and events sections are hidden, leaving only the offline attractions list. (in development)

## 🛠 Technologies

- **Jetpack Compose**: A modern, declarative UI toolkit for Android.
- **Kotlinx Serialization**: For efficient parsing and serialization of JSON data.
- **Paging 3**: To load and display large lists of data incrementally.
- **Navigation Compose**: For building a type-safe, declarative navigation graph.
- **Retrofit & Gson**: For networking and JSON conversion when fetching weather and event data.
- **OkHttp**: HTTP client with support for interceptors and network tracing.
- **Coil**: Fast, lightweight image loading library optimized for Kotlin and Compose.
- **Hilt**: Dependency injection framework to manage object creation and scope.
