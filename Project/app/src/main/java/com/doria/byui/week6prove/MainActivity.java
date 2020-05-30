package com.doria.byui.week6prove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
int duration = Toast.LENGTH_SHORT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getTemperature(View view){
        EditText mEdit;
        mEdit = (EditText)findViewById(R.id.city_name);
        final String city = mEdit.getText().toString();



        System.out.println(city);
        Weather weather = new Weather(city);
        WeakReference<Weather> weatherWeakReference = new WeakReference<Weather>(weather);
        weather = weatherWeakReference.get();


        Thread getTemperatureThread = new Thread(new Runnable() {
            @Override
            public void run() {

                WeatherDataLoader dataLoader = new WeatherDataLoader(city);

                WeatherData data = null;
                try {
                    data = dataLoader.getWeatherData();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                System.out.println("Getting the temperature for " + city);
                assert data != null;
                System.out.print("Weather Data: ");
                //data.display();
                final String display = data.display();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Context context = getApplicationContext();
                        CharSequence charSequence = display;
                        Toast toast = Toast.makeText(context, charSequence, duration);
                        toast.show();
                    }
                });

            }
        });
        getTemperatureThread.start();

    }
}
