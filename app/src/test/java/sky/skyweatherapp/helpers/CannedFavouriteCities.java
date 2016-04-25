package sky.skyweatherapp.helpers;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.datamodel.CityData;

/**
 * Created by S on 25/04/2016.
 */
public class CannedFavouriteCities implements FavouriteCitiesRetriever{

    @Override
    public List<CityData> retrieveFavourites() {

        List<CityData> cityData = new ArrayList<>();

        cityData.add(new CityData(1,"London","GB"));
        cityData.add(new CityData(2,"New York","US"));
        cityData.add(new CityData(3,"Calgary","CA"));

        return cityData;
    }
}
