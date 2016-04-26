package sky.skyweatherapp.view;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.R;
import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.datamodel.DataModel;
import sky.skyweatherapp.datamodel.ForecastRetriever;
import sky.skyweatherapp.datamodel.JSONCityDataParser;
import sky.skyweatherapp.helpers.FavouriteCitiesRetriever;
import sky.skyweatherapp.presenters.MainScreenPresenter;

public class MainScreenActivity extends FragmentActivity implements MainScreenView {

    private PresenterCallback presenterCallback = null;
    private NewFavouriteFragment newFavouriteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = getResources().getString(R.string.api_key);

        DataModel model = new DataModel(apiKey, new SharedPreferencesFavouritesRetriever(), new JSONCityDataParser(), new JSONForecastRetriever());

        MainScreenPresenter mainScreenPresenter = new MainScreenPresenter(this, model);

        findViewById(R.id.addNewFavouriteButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                newFavouriteFragment = new NewFavouriteFragment();
                newFavouriteFragment.show(fragmentManager, null);
            }
        });
    }

    @Override
    public void setFavourites(List<CityData> cityData) {

    }

    @Override
    public void displayNoDataMessage() {
        Toast.makeText(this, "No cities selected", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setPresenterCallback(PresenterCallback presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    @Override
    public void setCitySearchResults(final List<CityData> cityData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                newFavouriteFragment.setCountriesListData(cityData);
            }
        });
    }

    public PresenterCallback getPresenterCallback() {
        return presenterCallback;
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
