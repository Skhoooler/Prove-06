package com.doria.byui.week6prove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getTemperature(View view){
        R.id.
        Weather weather = new Weather("Twentynine Palms");

        Thread getTemperatureThread = new Thread(weather);
        getTemperatureThread.start();
    }
}
