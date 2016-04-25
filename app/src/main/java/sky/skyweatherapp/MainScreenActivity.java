package sky.skyweatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.datamodel.DataModel;
import sky.skyweatherapp.datamodel.ForecastRetriever;
import sky.skyweatherapp.datamodel.JSONCityDataParser;
import sky.skyweatherapp.helpers.FavouriteCitiesRetriever;
import sky.skyweatherapp.presenters.MainScreenPresenter;
import sky.skyweatherapp.presenters.MainScreenView;

public class MainScreenActivity extends AppCompatActivity implements MainScreenView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = getResources().getString(R.string.api_key);

        DataModel model = new DataModel(apiKey, new SharedPreferencesFavouritesRetriever(), new JSONCityDataParser(), new JSONForecastRetriever());

        MainScreenPresenter mainScreenPresenter = new MainScreenPresenter(this,model);

    }

    @Override
    public void setFavourites(List<CityData> cityData) {

    }

    @Override
    public void displayNoDataMessage() {
        Toast.makeText(this,"No cities selected", Toast.LENGTH_LONG).show();
    }

    private class SharedPreferencesFavouritesRetriever implements FavouriteCitiesRetriever {
        private List<CityData> favourites = new ArrayList<>();

        @Override
        public List<CityData> retrieveFavourites() {
            return favourites;
        }
    }

    private class JSONForecastRetriever implements ForecastRetriever {
        @Override
        public String retrieve(String url) {
            return null;
        }
    }
}
