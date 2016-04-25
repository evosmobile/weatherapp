package sky.skyweatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.presenters.MainScreenView;

public class MainScreenActivity extends AppCompatActivity implements MainScreenView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setFavourites(List<CityData> cityData) {

    }

    @Override
    public void displayNoDataMessage() {

    }
}
