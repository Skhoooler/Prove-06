package com.doria.byui.week6prove;

public class Weather implements Runnable {
    private String cityName;

    Weather(String passedInCityName){
        cityName = passedInCityName;
    }

    @Override
    public void run() {
        System.out.println("Getting the temperature for " + cityName);
    }
}
