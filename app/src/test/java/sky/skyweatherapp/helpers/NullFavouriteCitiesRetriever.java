package sky.skyweatherapp.helpers;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.datamodel.CityData;

/**
 * Created by S on 26/04/2016.
 */
public class NullFavouriteCitiesRetriever implements FavouriteCitiesRetriever {
    @Override
    public List<CityData> retrieveFavourites() {
        return new ArrayList<>();
    }
}
