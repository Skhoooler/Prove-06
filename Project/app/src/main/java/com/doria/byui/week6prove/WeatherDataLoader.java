package com.doria.byui.week6prove;

import android.renderscript.ScriptGroup;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class WeatherDataLoader {
    private static final String apiKey = "f55c210efa37a59bcecf2e5e57c98ef9";
    private static final String WeatherURLpt1 = "https://api.openweathermap.org/data/2.5/weather?q=";
    private static final String WeatherURLpt2 = "Rexburg&apiKey=";
    private              String cityName;

    WeatherDataLoader(String passedInCityName){
        cityName = passedInCityName;
        String apiCharset = StandardCharsets.UTF_8.name();
    }

    /**
     * Gets the Weather Data from the website and stores it inside of a WeatherData object
     * @return A weather Data object full of data for a specific city
     * @throws IOException for something idk
     */
    public WeatherData getWeatherData() throws IOException {
        String results = getWeatherJSON();

        Gson gson = new Gson();
        WeatherData data = gson.fromJson(results, WeatherData.class);

        return data;
    }


    /**
     * A helper method to get the raw JSON from the weather website
     * @return Returns a single string with all of the weather information
     * @throws IOException idk something if it goes wrong?
     */
    private String getWeatherJSON() throws IOException {
        URLConnection connection = new URL(getWeatherURL()).openConnection();

        InputStream response = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(response));

        StringBuilder stringBuilder = new StringBuilder();

        String result;
        while ((result = reader.readLine()) != null){
            stringBuilder.append(result);
        }

        return stringBuilder.toString();
    }

    /**
     * A helper method that returns the compiled URL for the API call
     * @return Returns the fully compiled API call to get the weather data for a city
     */
    private String getWeatherURL(){
        return WeatherURLpt1 + cityName + WeatherURLpt2 + apiKey;
    }
}
