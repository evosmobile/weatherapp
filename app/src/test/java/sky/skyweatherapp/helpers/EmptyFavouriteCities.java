package sky.skyweatherapp.helpers;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.datamodel.CityData;

/**
 * Created by SMcD on 25/04/2016.
 */
public class EmptyFavouriteCities implements FavouriteCitiesRetriever{
    @Override
    public List<CityData> retrieveFavourites() {
        return new ArrayList<>();
    }

    @Override
    public void saveFavourites(List<CityData> favourites) {

    }
}
