package sky.skyweatherapp.presenters;

import android.util.Log;

import java.util.List;

import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.datamodel.DataModel;
import sky.skyweatherapp.view.MainScreenView;

/**
 * Created by S on 25/04/2016.
 */
public class MainScreenPresenter implements MainScreenView.PresenterCallback{
    private final MainScreenView mainScreenView;
    private final DataModel model;
    private String TAG = "MainScreenPresenter";

    public MainScreenPresenter(MainScreenView mainScreenView, DataModel model) {
        this.mainScreenView = mainScreenView;
        this.model = model;


        mainScreenView.setPresenterCallback(this);

        //TODO: refactor this
        model.favourites = model.retrieveFavourites();
        if (model.favourites.size() == 0) {
            mainScreenView.displayNoDataMessage();
        } else {
            mainScreenView.setFavourites(model.favourites);
        }
    }

    @Override
    public void cityDataRetrieved(String response) {
        try {
            List<CityData> cityData = model.parseCitySearchResponse(response);
            mainScreenView.setCitySearchResults(cityData);
        }
        catch (Exception e) {
            Log.e(TAG, "cityDataRetrieved: " + e.toString());
        }
    }

    @Override
    public void newFavouriteCitySelected(CityData cityData) {
        model.favourites.add(cityData);
        mainScreenView.setFavourites(model.favourites);
    }
}
