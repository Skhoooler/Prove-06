package com.doria.byui.week6prove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getTemperature();
    }

    void getTemperature(){
        Weather weather = new Weather("Twentynine Palms");

        Thread getTemperatureThread = new Thread(weather);
        getTemperatureThread.start();
    }
}
