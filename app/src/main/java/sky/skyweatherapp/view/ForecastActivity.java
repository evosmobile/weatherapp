package sky.skyweatherapp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import sky.skyweatherapp.R;
import sky.skyweatherapp.datamodel.CityData;

/**
 * Created by mcdons20 on 26/04/16.
 */
public class ForecastActivity extends AppCompatActivity {

    private CityData cityData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forecast);

        Intent i = getIntent();

        this.cityData = new CityData(i.getLongExtra("id",-1), i.getStringExtra("city"), i.getStringExtra("country"));
    }
}
