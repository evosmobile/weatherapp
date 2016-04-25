package sky.skyweatherapp.view;

import java.util.List;

import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.presenters.MainScreenPresenter;

/**
 * Created by S on 25/04/2016.
 */
public interface MainScreenView {
    void setFavourites(List<CityData> cityData);

    void displayNoDataMessage();

    void setPresenterCallback(PresenterCallback presenterCallback);

    void setCitySearchResults(List<CityData> cityData);

    interface PresenterCallback {
        void cityDataRetrieved(String response);
    }
}
