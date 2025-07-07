# NZGuide

NZGuide is a simple yet powerful Android app that helps users explore cities in New Zealand. It’s built using Jetpack Compose with Clean Architecture and MVVM, and offers 5‑day weather forecasts, live event listings, rich city histories, and top‑attraction guides.

**🛠️ Note:** NZGuide is currently under active development. Features and UI may change as the app evolves.

## 📸 Demo
![NZGuideVideo2-ezgif com-speed (2)](https://github.com/user-attachments/assets/3e64b2c0-2d6c-4a50-9dcc-6fba62a209d3)

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
