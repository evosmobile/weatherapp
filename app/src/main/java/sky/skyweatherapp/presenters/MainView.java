package sky.skyweatherapp.presenters;

import java.util.List;

import sky.skyweatherapp.datamodel.CityData;

/**
 * Created by S on 25/04/2016.
 */
public interface MainView {
    void setFavourites(List<CityData> cityData);

    void displayNoDataMessage();
}
