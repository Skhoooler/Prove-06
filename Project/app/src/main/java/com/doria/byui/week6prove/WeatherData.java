package com.doria.byui.week6prove;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class WeatherData {
    private String id;
    private String name;

    @SerializedName("main")
    private Map<String, Float> measurements;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Float> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Map<String, Float> measurements) {
        this.measurements = measurements;
    }
}
