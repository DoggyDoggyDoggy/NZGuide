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
