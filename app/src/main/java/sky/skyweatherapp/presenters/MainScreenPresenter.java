package sky.skyweatherapp.presenters;

import java.util.List;

import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.datamodel.DataModel;
import sky.skyweatherapp.view.MainScreenView;

/**
 * Created by S on 25/04/2016.
 */
public class MainScreenPresenter {
    public MainScreenPresenter(MainScreenView mainScreenView, DataModel model) {
        List<CityData> favouriteCities = model.retrieveFavourites();

        if (favouriteCities.size() == 0) {
            mainScreenView.displayNoDataMessage();
        } else {
            mainScreenView.setFavourites(favouriteCities);
        }
    }
}
