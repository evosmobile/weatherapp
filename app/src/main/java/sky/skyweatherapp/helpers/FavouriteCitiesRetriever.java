package sky.skyweatherapp.helpers;

import java.util.List;

import sky.skyweatherapp.datamodel.CityData;

/**
 * Created by SMcD on 25/04/2016.
 */
public interface FavouriteCitiesRetriever {
    List<CityData> retrieveFavourites();

    void saveFavourites(List<CityData> favourites);
}
