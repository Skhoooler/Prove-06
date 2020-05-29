package com.doria.byui.week6prove;

public class WeatherDataLoader {
    private static final String apiKey = "f55c210efa37a59bcecf2e5e57c98ef9";
    private static final String WeatherURLpt1 = "https://api.openweathermap.org/data/2.5/weather?q=";
    private static final String WeatherURLpt2 = "Rexburg&apiKey=";
    private              String cityName;

    WeatherDataLoader(String passedInCityName){
        cityName = passedInCityName;
    }
    private String getWeatherURL(){
        String URL = WeatherURLpt1 + cityName + WeatherURLpt2 + apiKey;
        return URL;
    }
}
