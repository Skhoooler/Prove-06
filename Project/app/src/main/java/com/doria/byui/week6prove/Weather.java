package com.doria.byui.week6prove;

import java.io.IOException;

public class Weather implements Runnable {
    private String cityName;

    Weather(String passedInCityName){
        cityName = passedInCityName;
    }

    @Override
    public void run() {
        String city = "Rexburg";
        WeatherDataLoader dataLoader = new WeatherDataLoader(city);

        WeatherData data = null;
        try {
            data = dataLoader.getWeatherData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Getting the temperature for " + cityName);
        assert data != null;
        System.out.print("Weather Data: ");
        data.display();
    }
}
