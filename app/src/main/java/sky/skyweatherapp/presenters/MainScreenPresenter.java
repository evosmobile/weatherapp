package sky.skyweatherapp.presenters;

import java.util.List;

import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.datamodel.DataModel;

/**
 * Created by S on 25/04/2016.
 */
public class MainScreenPresenter {
    public MainScreenPresenter(MainView mainView, DataModel model) {
        List<CityData> favouriteCities = model.retrieveFavourites();

        if (favouriteCities.size() == 0) {
            mainView.displayNoDataMessage();
        } else {
            mainView.setFavourites(favouriteCities);
        }
    }
}
