package com.doria.byui.week6prove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getTemperature(View view){
        EditText mEdit;
        mEdit = (EditText)findViewById(R.id.city_name);
        String city = mEdit.getText().toString();

        System.out.println(city);
        Weather weather = new Weather(city);

        Thread getTemperatureThread = new Thread(weather);
        getTemperatureThread.start();
    }
}
