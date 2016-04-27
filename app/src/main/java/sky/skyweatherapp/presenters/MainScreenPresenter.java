package sky.skyweatherapp.presenters;

import android.util.Log;

import java.util.List;

import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.datamodel.MainScreenDataModel;
import sky.skyweatherapp.view.MainScreenView;

/**
 * Created by SMcD on 25/04/2016.
 */
public class MainScreenPresenter implements MainScreenView.PresenterCallback{
    private final MainScreenView mainScreenView;
    private final MainScreenDataModel model;
    private String TAG = "MainScreenPresenter";

    public MainScreenPresenter(MainScreenView mainScreenView, MainScreenDataModel model) {
        this.mainScreenView = mainScreenView;
        this.model = model;

        mainScreenView.setPresenterCallback(this);

        model.retrieveFavourites();

        checkFavourites();
    }

    private void checkFavourites() {
        mainScreenView.setFavourites(model.getFavourites());

        if (model.getFavourites().size() == 0) {
            mainScreenView.displayNoDataMessage();
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
        model.addFavourite(cityData);
        checkFavourites();
        mainScreenView.displayNewFavouriteMessage();
    }

    @Override
    public void deleteFavourite(CityData cityData) {
        model.deleteFavourite(cityData);
        checkFavourites();
    }

    @Override
    public String getSearchUrl(String query) {
       return model.getCountryUrl(query);
    }
}
