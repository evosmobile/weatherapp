package sky.skyweatherapp.view;

import java.util.List;

import sky.skyweatherapp.datamodel.CityData;

/**
 * Created by S on 25/04/2016.
 */
public interface MainScreenView {
    void setFavourites(List<CityData> cityData);

    void displayNoDataMessage();
}
