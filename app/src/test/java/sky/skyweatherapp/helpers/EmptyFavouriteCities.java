package sky.skyweatherapp.helpers;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.datamodel.CityData;

/**
 * Created by S on 25/04/2016.
 */
public class EmptyFavouriteCities implements FavouriteCitiesRetriever{
    @Override
    public List<CityData> retrieveFavourites() {
        return new ArrayList<>();
    }
}
