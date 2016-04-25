package sky.skyweatherapp.helpers;

import java.util.List;

import sky.skyweatherapp.datamodel.CityData;

/**
 * Created by S on 25/04/2016.
 */
public interface FavouriteCitiesRetriever {
    List<CityData> retrieveFavourites();
}
