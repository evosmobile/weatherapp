package sky.skyweatherapp.helpers;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.datamodel.CityData;

/**
 * Created by mcdons20 on 26/04/16.
 */
public class CapturingFavouriteCitiesRetriever implements FavouriteCitiesRetriever {
    public Boolean updateCalled = false;
    public List<CityData> capturedFavourites;


    @Override
    public List<CityData> retrieveFavourites() {
        return new ArrayList<>();
    }

    @Override
    public void saveFavourites(List<CityData> favourites) {
        this.capturedFavourites = favourites;
        updateCalled = true;
    }


}
